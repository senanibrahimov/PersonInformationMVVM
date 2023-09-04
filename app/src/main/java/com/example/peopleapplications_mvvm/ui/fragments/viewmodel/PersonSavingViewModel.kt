package com.example.peopleapplications_mvvm.ui.fragments.viewmodel

import androidx.lifecycle.ViewModel
import com.example.peopleapplications_mvvm.data.repo.DaoRepesitorty
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PersonSavingViewModel@Inject constructor(var krepo:DaoRepesitorty):ViewModel() {


    fun savedata(kisiad:String,kisitel:String){
       krepo.save(kisiad,kisitel)
    }
}