package com.example.daval.cleanrecyclerview.cardSetup.presentation.config

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.daval.cleanrecyclerview.utils.showOtpDialog
import com.example.daval.cleanrecyclerview.utils.showSimpleDialog
import com.example.daval.cleanrecyclerview.base.BaseFragment
import com.example.daval.cleanrecyclerview.cardSetup.presentation.config.adapter.ConfigurationAdapter
import com.example.daval.cleanrecyclerview.cardSetup.presentation.config.interfaces.IUserListener
import com.example.daval.cleanrecyclerview.cardSetup.presentation.models.*
import com.example.daval.cleanrecyclerview.databinding.FragmentMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ConfigFragment : BaseFragment<FragmentMainBinding, ConfigViewModel>(), IUserListener {

    override val viewModel by viewModels<ConfigViewModel>()

    private lateinit var itemsConfig: List<ConfigPresentation>
    private var configMobilePayment: MutableList<Boolean> = mutableListOf()


    override fun inflateView(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) =
        FragmentMainBinding.inflate(inflater, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getConfigList()
        configMobilePayment.clear()
    }


    override fun setUI() {
        super.setUI()
        with(binding) {

            buttonAccept.text = "Continuar"
            buttonAccept.setOnClickListener { }
            buttonAccept.setOnClickListener {
                val allEqual: Boolean =
                    configMobilePayment.stream().distinct().limit(2).count() <= 1
                if (allEqual && configMobilePayment.size > 1) {
                    val action =
                        ConfigFragmentDirections.actionMainFragmentToCardListAvailableFragment()
                    findNavController().navigate(action)
                } else {
                    val action =
                        ConfigFragmentDirections.actionMainFragmentToCardListTrustDeviceFragment()
                    findNavController().navigate(action)
                }

            }
        }
    }


    private fun setAdapter(items: List<ConfigPresentation>) {
        with(binding.rvConfig) {
            if (adapter == null) {
                layoutManager = LinearLayoutManager(
                    this@ConfigFragment.requireContext(),
                    LinearLayoutManager.VERTICAL,
                    false
                )
                adapter = ConfigurationAdapter(this@ConfigFragment)
            }
            (adapter as? ConfigurationAdapter)?.submitList(items)
        }
    }


    override fun observe() {
        viewModel.event.observe(viewLifecycleOwner) { event ->
            when (event) {
                is ConfigEvent.ListConfig -> {
                    itemsConfig = event.ls
                    setAdapter(itemsConfig)
                }
                else -> {}
            }
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun updateAdapter(items: List<ConfigPresentation>) {
        binding.rvConfig.apply {
            (adapter as? ConfigurationAdapter)?.submitList(items)
            adapter?.notifyDataSetChanged()
        }
    }

    private fun changeStatusSw(data: ConfigPresentation, enable: Boolean) {
        itemsConfig.find {
            data == it
        }?.indicatorSwitch = enable
        updateAdapter(itemsConfig)
    }

    override fun onClick(data: ConfigPresentation, enable: Boolean) {

        when (data.type) {
            StateEnum.TOUCH_ID -> {

                if (!enable) {

                    changeStatusSw(data, false)
                } else {
                    val simpleDialog = SimpleDialog.Builder()
                        .title("Activar Touch ID")
                        .message("Recordaremos tu usuario para que\napartir de ahora puedas usar tu\nhuella para acceder a la aplicación.")
                        .subTitle("¿Activar Touch ID ahora?")
                        .btnConfirm("Sí, activar Touch ID")
                        .btnCancel("Ahora no")

                    activity?.showSimpleDialog(simpleDialog)?.onClickButton = {
                        if (it.contentEquals(simpleDialog.btnConfirm)) {

                            changeStatusSw(data, true)
                            configMobilePayment.add(true)
                        } else {
                            changeStatusSw(data, false)
                        }
                    }
                }

            }
            StateEnum.PAGO_MOVIL -> {

                if (!enable) {
                    changeStatusSw(data, false)
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

                                    changeStatusSw(data, true)
                                    configMobilePayment.add(true)

                                } else {
                                    changeStatusSw(data, false)
                                }
                            }

                        } else {
                            changeStatusSw(data, false)
                        }
                    }
                }

            }
            else -> {}
        }
    }
}