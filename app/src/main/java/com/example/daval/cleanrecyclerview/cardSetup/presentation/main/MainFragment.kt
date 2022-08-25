package com.example.daval.cleanrecyclerview.cardSetup.presentation.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.daval.cleanrecyclerview.base.BaseFragment
import com.example.daval.cleanrecyclerview.cardSetup.presentation.dialogs.DataList
import com.example.daval.cleanrecyclerview.cardSetup.presentation.dialogs.Otp
import com.example.daval.cleanrecyclerview.cardSetup.presentation.dialogs.Simple
import com.example.daval.cleanrecyclerview.cardSetup.presentation.main.adapter.ConfigurationAdapter
import com.example.daval.cleanrecyclerview.cardSetup.presentation.main.interfaces.IUserListener
import com.example.daval.cleanrecyclerview.cardSetup.presentation.models.*
import com.example.daval.cleanrecyclerview.databinding.FragmentMainBinding
import com.example.daval.cleanrecyclerview.databinding.HolderItemConfigurationBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.holder_item_configuration.view.*

@AndroidEntryPoint
class MainFragment : BaseFragment<FragmentMainBinding, MainViewModel>(), IUserListener {

    override val viewModel by viewModels<MainViewModel>()

    private lateinit var items: List<UserPresentation>
    private lateinit var itemsDetail: List<UserDetailPresentation>
    private lateinit var itemsConfig: List<ConfigPresentation>
    private var configMobilePaymente : MutableList<Boolean> = mutableListOf()


    override fun inflateView(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) =
        FragmentMainBinding.inflate(inflater, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getConfigList()
        configMobilePaymente.clear()
    }


    override fun setUI() {
        super.setUI()
        with(binding) {

            buttonAccept.text = "Continuar"
            buttonAccept.setOnClickListener { }
            buttonAccept.setOnClickListener {
                val allEqual : Boolean = configMobilePaymente.stream().distinct().limit(2).count() <= 1
                if(allEqual && configMobilePaymente.size >1) {
                    val action =MainFragmentDirections.actionMainFragmentToCardListAvailableFragment()
                    findNavController().navigate(action)
                } else {
                    val action =MainFragmentDirections.actionMainFragmentToCardListTrustDeviceFragment()
                    findNavController().navigate(action)
                }

            }
        }
    }

    private fun setAdapter(configItems: List<ConfigPresentation>) {
        with(binding.rvConfig) {
            if (adapter == null) {
                layoutManager = LinearLayoutManager(
                    this@MainFragment.requireContext(),
                    LinearLayoutManager.VERTICAL,
                    false
                )
                adapter = ConfigurationAdapter(this@MainFragment)
            }
            (adapter as? ConfigurationAdapter)?.submitList(configItems)
        }
    }


    override fun observe() {
        viewModel.event.observe(viewLifecycleOwner) { event ->
            when (event) {
                is MainEvent.ListConfig -> {
                    setAdapter(event.ls)
                }
                else -> {}
            }
        }
    }

    private fun switchStatus(
        boolean: Boolean,
        text: String,
        holder: HolderItemConfigurationBinding
    ) {
        holder.status.text = text
        holder.switchValue.isChecked = boolean
    }

    override fun onClickUser(position: Int, holder: HolderItemConfigurationBinding) {

        when (position) {
            0 -> { //Position in Card Touch ID

                if (!holder.root.switchValue.isChecked) {
                    switchStatus(false, "Desactivado", holder)
                } else {
                    val simpleDialog = SimpleDialog.Builder()
                        .title("Activar Touch ID")
                        .message("Recordaremos tu usuario para que\napartir de ahora puedas usar tu\nhuella para acceder a la aplicación.")
                        .subTitle("¿Activar Touch ID ahora?")
                        .btnConfirm("Sí, activar Touch ID")
                        .btnCancel("Ahora no")

                    activity?.showSimpleDialog(simpleDialog)?.onClickButton = {
                        if (it.contentEquals(simpleDialog.btnConfirm)) {

                            switchStatus(true, "Activado", holder)
                            configMobilePaymente.add(true)
                        } else {
                            switchStatus(false, "Desactivado", holder)
                        }
                    }
                }
            }

            1 -> { //Position in Card Pago Móvil

                if (!holder.root.switchValue.isChecked) {
                    switchStatus(false, "Desactivado", holder)
                } else {
                    val simpleDialog = SimpleDialog.Builder()
                        .title("Activar Pago Móvil")
                        .message("Podrás habilitar tus tarjetas para\npagar con ellas cómoda y\nrápidamente utilizando tu móvil.")
                        .subTitle("¿Activar Pago móvil ahora?")
                        .btnConfirm("Sí, activar Pago móvil")
                        .btnCancel("Ahora no")

                    activity?.showSimpleDialog(simpleDialog)?.onClickButton = { simple ->
                        if (simple.contentEquals(simpleDialog.btnConfirm)) {

                            val otpDialog = OtpDialog.Builder()
                                .title("Activar Pago Móvil")
                                .message("Introduce el código enviado al\n**753 para activar el pago móvil.")
                                .btnConfirm("Confirmar")
                                .btnCancel("Ahora no")

                            activity?.showOtpDialog(otpDialog)?.onClickButton = { otp ->
                                if (otp.contentEquals(otpDialog.btnConfirm)) {

                                    switchStatus(true, "Activado", holder)
                                    configMobilePaymente.add(true)

                                } else {
                                    switchStatus(false, "Desactivado", holder)
                                }
                            }

                        } else {
                            switchStatus(false, "Desactivado", holder)
                        }
                    }
                }
            }
        }
    }

}


fun FragmentActivity?.showOtpDialog(model: OtpDialog.Builder): Otp {
    val dialog = Otp()
    dialog.modelDialog = model
    this?.let {
        dialog.show(it.supportFragmentManager, Otp::class.java.name)
    }
    return dialog
}

fun FragmentActivity?.showSimpleDialog(model: SimpleDialog.Builder): Simple {
    val dialog = Simple()
    dialog.modelDialog = model
    this?.let {
        dialog.show(it.supportFragmentManager, Simple::class.java.name)
    }
    return dialog
}

fun FragmentActivity?.showRvDialog(model: DataListDialog.Builder<UserPresentation>): DataList<UserPresentation> {
    val dialog = DataList<UserPresentation>()
    dialog.modelDialog = model
    this?.let {
        dialog.show(it.supportFragmentManager, Simple::class.java.name)
    }
    return dialog
}