package com.example.todoapplication.utils

import android.view.View
import androidx.navigation.NavDirections
import androidx.navigation.Navigation

fun Navigation.migration(it:View,id:Int){
    findNavController(it).navigate(id)
}

fun Navigation.migration(it:View,id:NavDirections){
    findNavController(it).navigate(id)
}