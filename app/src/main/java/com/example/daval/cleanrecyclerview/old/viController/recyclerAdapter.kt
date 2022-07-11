package com.example.daval.cleanrecyclerview.old.viController

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.daval.cleanrecyclerview.R
import com.example.daval.cleanrecyclerview.old.viController.viModel.dataModel

class recyclerAdapter (private val context: Context, private var arrayOrgAdapter : ArrayList<dataModel>) : RecyclerView.Adapter<recyclerAdapter.MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view : View
        val mInflater = LayoutInflater.from(context)
        view = mInflater.inflate(R.layout.org_list_item, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val name = arrayOrgAdapter.get(position).organizationName
        val code = arrayOrgAdapter.get(position).organizationCode
        holder.organizationName.setText(name)
        holder.organizationCode.setText(code)
    }

    override fun getItemCount()= arrayOrgAdapter.size

    class MyViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView) {
        val organizationName : TextView
        val organizationCode : TextView
//binding
        init {
            organizationName = itemView.findViewById(R.id.organizationName)
            organizationCode = itemView.findViewById(R.id.organizationCode)
        }
    }

}