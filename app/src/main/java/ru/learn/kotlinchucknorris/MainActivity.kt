package ru.learn.kotlinchucknorris

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import ru.learn.kotlinchucknorris.model.ModelFact

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        nextBtn.setOnClickListener {
            loadRandomFact()
        }
    }

    private fun loadRandomFact() {
        Log.e("ОШИБКА", "Метод")
        runOnUiThread {
            Log.e("ОШИБКА", "Прогресс")
            progressBar.visibility = View.VISIBLE
        }

        Log.e("ОШИБКА", "Инициализация")
        val call: Call<ModelFact> = AppChuckNorris.apiInterface.factChuck()
        call.enqueue(object: Callback<ModelFact> {
            override fun onFailure(call: Call<ModelFact>, t: Throwable) {
                Log.e("ОШИБКА", t.toString())
            }

            override fun onResponse(call: Call<ModelFact>, response: Response<ModelFact>) {
                val fact: String? = response.body()?.value?.joke
                Log.e("ОШИБКА", fact.toString())
                runOnUiThread {
                    progressBar.visibility = View.GONE
                    factTv.setText(fact)
                }
            }
        })
    }
}

