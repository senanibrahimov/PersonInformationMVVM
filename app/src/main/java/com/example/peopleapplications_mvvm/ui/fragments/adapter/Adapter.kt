package com.example.peopleapplications_mvvm.ui.fragments.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.peopleapplications_mvvm.R
import com.example.peopleapplications_mvvm.data.entity.Kisiler
import com.example.peopleapplications_mvvm.databinding.RecycelrowBinding
import com.example.peopleapplications_mvvm.ui.fragments.MainPageFragmentDirections
import com.example.peopleapplications_mvvm.ui.fragments.viewmodel.MainFragmentViewModel
import com.example.peopleapplications_mvvm.util.passto
import com.google.android.material.snackbar.Snackbar

class Adapter(var list:ArrayList<Kisiler>, var context:Context,var viewModel: MainFragmentViewModel):RecyclerView.Adapter<Adapter.viewholder>() {
    class viewholder(var binding: RecycelrowBinding):RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewholder {
        val binding= DataBindingUtil.inflate<RecycelrowBinding>(LayoutInflater.from(context),R.layout.recycelrow,parent,false)
        return viewholder(binding)
    }

    override fun onBindViewHolder(holder: viewholder, position: Int) {

        val lists=list[position]
      holder.binding.kisiobyekti=lists


        holder.binding.imageViewDelete.setOnClickListener {

            Snackbar.make(it," do you want delete ${lists.kisiad} ?",Snackbar.LENGTH_LONG).setAction("delete",
                View.OnClickListener {
                viewModel.delete(lists.kisiid)
                }).show()

          holder.binding.cardview.setOnClickListener {
              val kecid=MainPageFragmentDirections.actionMainPageFragmentToPersonDetailsFragment(kisi =lists )

              Navigation.passto(kecid,it)
          }

        }
    }

    override fun getItemCount(): Int {
return list.size   }
}