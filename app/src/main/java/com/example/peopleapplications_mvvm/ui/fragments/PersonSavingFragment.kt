package com.example.peopleapplications_mvvm.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import com.example.peopleapplications_mvvm.R
import com.example.peopleapplications_mvvm.databinding.FragmentPersonSavingBinding
import com.example.peopleapplications_mvvm.ui.fragments.viewmodel.DetailsFragmentViewModel
import com.example.peopleapplications_mvvm.ui.fragments.viewmodel.PersonSavingViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class PersonSavingFragment : Fragment() {

  private lateinit var viewmodel:PersonSavingViewModel

  private lateinit var binding: FragmentPersonSavingBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

      binding= DataBindingUtil.inflate(inflater,R.layout.fragment_person_saving,container,false)


        binding.personsavingtoolbar="kisi toolbar"
        binding.personsaving=this


        return binding.root
    }



    fun save(kisiad:String,kisitel:String){
        viewmodel.savedata(kisiad, kisitel)
    }
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    val viewmodell: PersonSavingViewModel by viewModels()
    viewmodel=viewmodell
  }

}