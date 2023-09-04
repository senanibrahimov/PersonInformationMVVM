package com.example.peopleapplications_mvvm.util

import android.view.View
import androidx.navigation.NavDirections
import androidx.navigation.Navigation
import com.example.peopleapplications_mvvm.R

fun Navigation.passto(id:Int,it:View){
    findNavController(it).navigate(id)
}

fun Navigation.passto(id:NavDirections,it:View){
    findNavController(it).navigate(id)
}