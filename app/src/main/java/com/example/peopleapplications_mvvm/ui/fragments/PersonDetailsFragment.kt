package com.example.peopleapplications_mvvm.ui.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.example.peopleapplications_mvvm.R
import com.example.peopleapplications_mvvm.databinding.FragmentPersonDetailsBinding
import com.example.peopleapplications_mvvm.ui.fragments.viewmodel.DetailsFragmentViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PersonDetailsFragment : Fragment() {

    private lateinit var viewmodel:DetailsFragmentViewModel

    lateinit var binding: FragmentPersonDetailsBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

       binding= DataBindingUtil.inflate(inflater,R.layout.fragment_person_details,container,false)
        binding.tollbarbaslik="kisiler"

         val bundle:PersonDetailsFragmentArgs by navArgs()
         val data=bundle.kisi
          binding.kisilerobyekti=data




        return binding.root

    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

         val viewmodell:DetailsFragmentViewModel by viewModels()
          viewmodel=viewmodell
    }

    fun update(kisiid:Int,kisiad:String,kisi_tel:String){
          viewmodel.update(kisiid,kisiad,kisi_tel)
    }



}