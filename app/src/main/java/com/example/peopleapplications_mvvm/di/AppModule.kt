package com.example.peopleapplications_mvvm.di

import android.content.Context
import androidx.room.Room
import com.example.peopleapplications_mvvm.data.repo.DaoRepesitorty
import com.example.peopleapplications_mvvm.data.repo.RoomDao
import com.example.peopleapplications_mvvm.data.repo.RoomDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.internal.Contexts
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    @Singleton
    fun provideDaoRepesitorty(kdao:RoomDao):DaoRepesitorty{
        return DaoRepesitorty(kdao)
    }

    @Provides
    @Singleton
    fun providekdaoRoomDao(@ApplicationContext context:Context):RoomDao{
        val vt=Room.databaseBuilder(context,RoomDatabase::class.java,"rehber.sqlite").createFromAsset("rehber.sqlite").allowMainThreadQueries().build()
        return vt.getkisilerdao()
    }
}