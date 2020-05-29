package ru.learn.kotlinchucknorris.interfaces

import retrofit2.Call
import retrofit2.Callback
import retrofit2.http.GET
import ru.learn.kotlinchucknorris.model.ModelFact

interface ApiInterface {

    @GET("random/")
    fun factChuck(): Call<ModelFact>

}