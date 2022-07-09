package com.example.daval.cleanrecyclerview.presentation.organizationList


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.RecyclerView
import com.example.daval.cleanrecyclerview.viController.recyclerAdapter
import com.example.daval.cleanrecyclerview.databinding.FragmentOrganizationBinding
import com.example.daval.cleanrecyclerview.base.BaseFragment
import com.example.daval.cleanrecyclerview.presentation.models.OrgPresentation
import com.example.daval.cleanrecyclerview.presentation.organizationList.adapter.IOrgListener
import com.example.daval.cleanrecyclerview.presentation.organizationList.adapter.OrgAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class OrganizationFragment2 : BaseFragment<FragmentOrganizationBinding, organizationViewModel2> () , IOrgListener {

    override val viewModel by viewModels<organizationViewModel2> ()
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

    override fun onClickOrg() {
        TODO("Not yet implemented")
    }


    /* override fun observe() {
         viewModel.organiztionMutableLiveData.observe(viewLifecycleOwner, Observer {
             var recyclerViewAdapter = recyclerAdapter(requireContext(), it)
             binding.recyclerView.adapter = recyclerViewAdapter
         })
     }*/

}
