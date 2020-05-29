package ru.learn.kotlinchucknorris

import android.app.Application
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import ru.learn.kotlinchucknorris.interfaces.ApiInterface

class AppChuckNorris : Application() {

    companion object {
        //const val CONSTANT = 12
        //lateinit var typeface: Typeface
        var retrofit = Retrofit.Builder() // http://api.icndb.com/jokes/
            .baseUrl("http://api.icndb.com/jokes/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        var instance : AppChuckNorris = AppChuckNorris()

        var apiInterface: ApiInterface = retrofit.create(ApiInterface::class.java)
    }
}