package com.example.peopleapplications_mvvm.data.repo

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.peopleapplications_mvvm.data.entity.Kisiler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class DaoRepesitorty(var kdao:RoomDao) {

    var lists:MutableLiveData<ArrayList<Kisiler>>

   init {
       lists=MutableLiveData()  //bu seife acilanda mutable listi bele yazib yaradiriq və bunla tetiklemis oluruq
   }

    fun personupdate(kisiid:Int,kisiad:String,kisi_tel:String){



            }

    fun save(kisiad:String,kisitel:String){

    }

    fun searchword(word:String){
         kdao.searchs(word)

       val list= kdao.searchs(word) as ArrayList<Kisiler>

        lists.value=list


    }

    fun delete(kisiid:Int){

    }

    fun tümkisiler(){




         val job= CoroutineScope(Dispatchers.Main).launch {

             var list=kdao.tumkisiler() as ArrayList<Kisiler>


             lists.value=list

         }

    }
    fun kisilerigetir():MutableLiveData<ArrayList<Kisiler>>{

        return lists
    }
}