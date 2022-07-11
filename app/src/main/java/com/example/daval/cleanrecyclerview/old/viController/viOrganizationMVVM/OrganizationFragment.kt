package com.example.daval.cleanrecyclerview.old.viController.viOrganizationMVVM


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.daval.cleanrecyclerview.old.viController.recyclerAdapter
import com.example.daval.cleanrecyclerview.databinding.FragmentOrganizationBinding
import com.example.daval.cleanrecyclerview.R


class OrganizationFragment : Fragment() {

    private lateinit var binding : FragmentOrganizationBinding
    private lateinit var viewModel: organizationViewModel
    private lateinit var recyclerView : RecyclerView
    private lateinit var recyclerViewAdapter : recyclerAdapter
//sublist
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_organization, null, false)
        recyclerView = binding.recyclerView
        viewModel = ViewModelProvider(this).get(organizationViewModel::class.java)
        viewModel.organiztionMutableLiveData.observe(viewLifecycleOwner, Observer {
            recyclerViewAdapter = recyclerAdapter(requireContext(), it)
            recyclerView.adapter = recyclerViewAdapter
        })
        return binding.root
    }
}
