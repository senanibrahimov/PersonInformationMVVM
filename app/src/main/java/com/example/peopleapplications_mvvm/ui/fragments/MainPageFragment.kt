package com.example.peopleapplications_mvvm.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.core.view.MenuProvider
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.navigation.Navigation
import com.example.peopleapplications_mvvm.R
import com.example.peopleapplications_mvvm.data.entity.Kisiler
import com.example.peopleapplications_mvvm.databinding.FragmentMainPageBinding
import com.example.peopleapplications_mvvm.ui.fragments.adapter.Adapter
import com.example.peopleapplications_mvvm.ui.fragments.viewmodel.MainFragmentViewModel
import com.example.peopleapplications_mvvm.util.passto
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainPageFragment : Fragment(),SearchView.OnQueryTextListener {


    private lateinit var binding: FragmentMainPageBinding
    private lateinit var viewmodel:MainFragmentViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
          binding= DataBindingUtil.inflate(inflater,R.layout.fragment_main_page,container,false)
           (activity as AppCompatActivity).setSupportActionBar(binding.toolbarMainpage)
           binding.homepagefragment=this
          binding.toolbartitle="Kisiler"



           viewmodel.kisilerlistesi.observe(viewLifecycleOwner){
               val adapter=Adapter(it,requireContext(),viewmodel)
               binding.mylayoutadapter=adapter
           }




              requireActivity().addMenuProvider(object :MenuProvider{
                  override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                      menuInflater.inflate(R.menu.main_menu,menu)

                      val item=menu.findItem(R.id.search_menu)

                      val searchView=item.actionView as SearchView
                          searchView.setOnQueryTextListener(this@MainPageFragment)

                  }

                  override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
return false                  }

              },viewLifecycleOwner,Lifecycle.State.RESUMED)



          return binding.root
    }

    override fun onQueryTextSubmit(query: String): Boolean {
        viewmodel.search(query)
        return false    }

    override fun onQueryTextChange(newText: String): Boolean {

        viewmodel.search(newText)
        return false
      }

    override fun onResume() {
        super.onResume()
        viewmodel.kisileriyukle()

    // onresume override etmeyimiin sebebi bizim bu seifeye her qayitdiqda isleyen bi funksiyadir və biz update və insert islemi etdikden sonra arayuzun günncellmesini sagliyir
    }


    fun fabclick(it:View){
        Navigation.passto(R.id.action_mainPageFragment_to_personSavingFragment,it)

    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val viewmodell: MainFragmentViewModel by viewModels()
        viewmodel=viewmodell
    }



}