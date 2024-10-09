package com.example.moviecatchapp.di.module

import android.app.Application
import android.content.Context
import com.example.moviecatchapp.Model.Genre
import com.example.moviecatchapp.di.Retrofit.RetrofitServiceInstance
import com.example.moviecatchapp.di.dao.GenreDao
import com.example.moviecatchapp.di.dao.GenreDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn (SingletonComponent::class)
class AppModule {

    var base_url = "https://api.themoviedb.org/"

    @Provides
    @Singleton
    fun getAppDB(context: Application): GenreDatabase{
        return GenreDatabase.getAppDB(context)
    }

    @Provides
    @Singleton
    fun getDao(appDB: GenreDatabase):GenreDao{
        return appDB.getDao()
    }

    @Provides
    @Singleton
    fun getRetrofitServiceInstance(retrofit: Retrofit) : RetrofitServiceInstance
    {
        return retrofit.create(RetrofitServiceInstance::class.java)
    }

    @Singleton
    @Provides
    fun getRetroInstance():Retrofit{
        return Retrofit.Builder()
            .baseUrl(base_url)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

}