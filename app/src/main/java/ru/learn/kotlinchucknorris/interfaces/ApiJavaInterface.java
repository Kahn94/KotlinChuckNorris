package ru.learn.kotlinchucknorris.interfaces;

import retrofit2.Call;
import retrofit2.http.GET;
import ru.learn.kotlinchucknorris.model.ModelFact;

public interface ApiJavaInterface {
    @GET("random")
    Call<ModelFact> factChuck();
}
