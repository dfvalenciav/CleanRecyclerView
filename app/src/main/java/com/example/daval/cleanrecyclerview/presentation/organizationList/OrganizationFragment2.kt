package com.example.daval.cleanrecyclerview.presentation.organizationList


import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import com.example.daval.cleanrecyclerview.databinding.FragmentOrganizationBinding
import com.example.daval.cleanrecyclerview.base.BaseFragment
import com.example.daval.cleanrecyclerview.presentation.models.OrgPresentation
import com.example.daval.cleanrecyclerview.presentation.organizationList.adapter.IOrgListener
import com.example.daval.cleanrecyclerview.presentation.organizationList.adapter.OrgAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class OrganizationFragment2 : BaseFragment<FragmentOrganizationBinding, OrganizationViewModel2> () , IOrgListener {

    override val viewModel by viewModels<OrganizationViewModel2> ()
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
        with(binding.recyclerView){
            adapter = OrgAdapter(this@OrganizationFragment2)
            (adapter as? OrgAdapter)?.submitList(items)
        }
    }

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

    override fun onClickOrg(dataPassed: OrgPresentation) {

        val action = OrganizationFragment2Directions.actionOrganizationFragment2ToDetailOrgFragment(dataPassed)
        binding.recyclerView.findNavController().navigate(action)
        Toast.makeText(requireContext(), dataPassed.organizationName, Toast.LENGTH_LONG).show()
        Log.d("test", dataPassed.organizationCode.toString())
    }

}
