package com.example.peopleapplications_mvvm.data.repo

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.peopleapplications_mvvm.data.entity.Kisiler

@Dao
interface RoomDao {

    @Query("SELECT*FROM Kisiler")
       fun tumkisiler():List<Kisiler>

      @Query("SELECT*FROM Kisiler Where kisi_name like '%' || :kisiadarama|| '%'")
      fun searchs(kisiadarama:String):List<Kisiler>
}