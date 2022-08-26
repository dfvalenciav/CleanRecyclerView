package com.example.daval.cleanrecyclerview.cardSetup.presentation.organizationList


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.daval.cleanrecyclerview.databinding.FragmentOrganizationBinding
import com.example.daval.cleanrecyclerview.base.BaseFragment
import com.example.daval.cleanrecyclerview.cardSetup.presentation.models.OrgPresentation
import com.example.daval.cleanrecyclerview.cardSetup.presentation.organizationList.adapter.IOrgListener
import com.example.daval.cleanrecyclerview.cardSetup.presentation.organizationList.adapter.OrgAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class OrganizationFragment : BaseFragment<FragmentOrganizationBinding, OrganizationViewModel>() ,
    IOrgListener {

    override val viewModel by viewModels<OrganizationViewModel> ()
    private lateinit var items: List<OrgPresentation>

    override fun inflateView(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = FragmentOrganizationBinding.inflate(inflater, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getOrgList()
    }

    private fun setAdapter(items: List<OrgPresentation>) {
        with(binding.rvOrganization){
            adapter = OrgAdapter(this@OrganizationFragment)
            (adapter as? OrgAdapter)?.submitList(items)
        }
    }
    /***
     * Observing viewmodel result
     */
    override fun observe() {
        viewModel.event.observe(viewLifecycleOwner) {event ->
            when(event){
                is OrgEvent.ListOrg -> {
                    items = event.ls
                    setAdapter(items)
                }
            }
        }
    }

    /**
     * Navigation passing arguments : OrgPresentation
     * */
    override fun onClickOrg(dataPassed: OrgPresentation) {

    }
}
