package com.example.daval.cleanrecyclerview.cardSetup.presentation.dialogUser

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import co.cristian.bizumdialog.presentation.main.UserEvent
import co.cristian.bizumdialog.presentation.main.UserViewModel
import com.example.daval.cleanrecyclerview.base.BaseFragment
import com.example.daval.cleanrecyclerview.cardSetup.presentation.cardListAvailable.CardListAvailableFragmentDirections
import com.example.daval.cleanrecyclerview.cardSetup.presentation.dialogUser.adapter.UserAdapter
import com.example.daval.cleanrecyclerview.cardSetup.presentation.dialogs.DataList
import com.example.daval.cleanrecyclerview.cardSetup.presentation.dialogs.Otp
import com.example.daval.cleanrecyclerview.cardSetup.presentation.dialogs.Simple
import com.example.daval.cleanrecyclerview.cardSetup.presentation.models.*
import com.example.daval.cleanrecyclerview.databinding.FragmentMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainFragment : BaseFragment<FragmentMainBinding, UserViewModel>() {

    override val viewModel by viewModels<UserViewModel>()

    private lateinit var items: List<UserPresentation>
    private lateinit var itemsDetail: List<UserDetailPresentation>


    override fun inflateView(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) =
        FragmentMainBinding.inflate(inflater, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getUserList()
    }


    override fun setUI() {
        super.setUI()
        with(binding) {
            simpleButton.setOnClickListener {
                val simpleDialog = SimpleDialog.Builder()
                    .title("Parece que algo\nha ido mal")
                    .subTitle("Por favor, inténtalo de nuevo.")
                    .btnConfirm("Aceptar")

                activity?.showSimpleDialog(simpleDialog)?.onClickButton = {
                    //Implement event necessary
                }

            }

            editTextButton.setOnClickListener {
                val otpDialog = OtpDialog.Builder()
                    .title("Activar Pago Móvil") //pinta la cabecera del dialogo
                    .message("Introduce el código enviado al\n**753 para activar el pago móvil")
                    .btnConfirm("Confirmar")
                    .btnCancel("Ahora no")

                activity?.showOtpDialog(otpDialog)?.onClickButton = {
                    // TODO: revisar
                }

            }

            rvButton.setOnClickListener {
                val rvDialog = DataListDialog.Builder<UserPresentation>()
                    .title("Enviar bizum a")
                    .adapter(UserAdapter())
                    .listData(items)
                    .btnClose(true)

                activity?.showRvDialog(rvDialog)
            }
        }
    }



    override fun observe() {
        viewModel.event.observe(viewLifecycleOwner) { event ->
            when (event) {
                is UserEvent.ListMain -> {
                    items = event.ls
                }
                else -> {}
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