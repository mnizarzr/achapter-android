package io.github.achapter.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import io.github.achapter.R
import io.github.achapter.service.ApiClient
import io.github.achapter.service.response.RegisterResponse
import io.github.achapter.util.showToast
import kotlinx.android.synthetic.main.activity_register.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import timber.log.Timber

class RegisterActivity : AppCompatActivity() {

    private val apiService = ApiClient.getService()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        txtLogin.setOnClickListener { finish() }

        btnRegister.setOnClickListener { doRegister() }

    }

    private fun doRegister() {
        val email = inpEmail.text.toString()
        val password = inpPassword.text.toString()
        val name = inpName.text.toString()

        apiService.submitRegister(email, password, name).enqueue(object: Callback<RegisterResponse>{
            override fun onFailure(call: Call<RegisterResponse>, t: Throwable) {
                Timber.e(t)
            }

            override fun onResponse(
                call: Call<RegisterResponse>,
                response: Response<RegisterResponse>
            ) {
                response.body()?.let {
                    if(it.status == 201) showToast("User registered")
                    finish()
                }
            }
        })
    }

    override fun onBackPressed() {
        finish()
    }

}
