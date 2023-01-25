package com.example.utbkv

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btnGetData = findViewById<Button>(R.id.btn_get_data)
        btnGetData.setOnClickListener {
            // Volání API pomocí Retrofit
            val apiClient = ApiClient()

            val apiService = apiClient.getClient(Retrofit::class.java)?.create(ApiService::class.java)
            val call = apiService?.getDataFromDatabase()
            call?.enqueue(object : Callback<List<Data>> {
                override fun onResponse(call: Call<List<Data>>, response: Response<List<Data>>) {
                    if (response.isSuccessful) {
                        val data = response.body()
                        // Zobrazit data na layoutu
                    }
                }
                override fun onFailure(call: Call<List<Data>>, t: Throwable) {
                    // Zpráva o chybě při volání API
                }
            })
        }
    }
}