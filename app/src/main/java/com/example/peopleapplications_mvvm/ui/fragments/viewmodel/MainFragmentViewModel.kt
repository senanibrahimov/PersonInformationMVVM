package com.example.peopleapplications_mvvm.ui.fragments.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.peopleapplications_mvvm.data.entity.Kisiler
import com.example.peopleapplications_mvvm.data.repo.DaoRepesitorty
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainFragmentViewModel @Inject constructor(var krepo:DaoRepesitorty):ViewModel() {

    var kisilerlistesi=MutableLiveData<ArrayList<Kisiler>>()

    init {

        kisilerlistesi=krepo.kisilerigetir()
        kisileriyukle()
    }


    fun search(word:String){
      krepo.searchword(word)
        Log.e("basliq","${word}")
    }
    fun delete(kisiid:Int){
        krepo.delete(kisiid)
    }

    fun kisileriyukle(){
        krepo.tümkisiler()
    }
}