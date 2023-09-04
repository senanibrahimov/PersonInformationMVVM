package com.example.peopleapplications_mvvm.data.repo

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.peopleapplications_mvvm.data.entity.Kisiler

@Database(entities =[Kisiler::class], version = 1, exportSchema = false)
abstract class RoomDatabase :RoomDatabase(){


    abstract fun getkisilerdao():RoomDao

}