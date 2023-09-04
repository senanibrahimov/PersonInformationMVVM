package com.example.peopleapplications_mvvm.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull
import java.io.Serializable


    @Entity(tableName = "Kisiler")
data class Kisiler(
                      @PrimaryKey(autoGenerate = true)
                      @NotNull @ColumnInfo(name = "kisi_id")  var kisiid:Int,
                      @NotNull @ColumnInfo(name = "kisi_name")  var kisiad:String,
                      @NotNull @ColumnInfo(name = "kisi_tel")  var kisitel:String):Serializable{

}
