package com.example.peopleapplications_mvvm.ui.fragments.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.peopleapplications_mvvm.data.repo.DaoRepesitorty
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

 @HiltViewModel
class DetailsFragmentViewModel @Inject constructor(var krepo:DaoRepesitorty):ViewModel() {



    fun update(kisiid:Int,kisiad:String,kisi_tel:String){

        krepo.personupdate(kisiid,kisiad,kisi_tel)

    }
}