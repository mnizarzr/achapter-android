package io.github.achapter.view

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import io.github.achapter.R
import io.github.achapter.service.ApiClient
import io.github.achapter.service.response.LoginResponse
import io.github.achapter.util.PreferenceHelper
import io.github.achapter.util.showToast
import kotlinx.android.synthetic.main.activity_login.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginActivity : AppCompatActivity() {

    private lateinit var sharedPreferences: PreferenceHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

//        loginViewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory()).get(LoginViewModel::class.java)

        val client = ApiClient.getService()
        sharedPreferences = PreferenceHelper(this)

        btnLogin.setOnClickListener {
            if (validateInput()) {
                client.submitLogin(inpEmail.text.toString(), inpPassword.text.toString())
                    .enqueue(object : Callback<LoginResponse> {
                        override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                            showToast(t.message!!)
                        }

                        override fun onResponse(
                            call: Call<LoginResponse>,
                            response: Response<LoginResponse>
                        ) {
                            response.body()?.let {
                                with(sharedPreferences) {
                                    setBoolean("IS_LOGGED_IN", true)
                                    setToken(it.token.token)
                                    setInt("USER_ID", it.data.id)
                                    setString("USER_NAME", it.data.name)
                                    setString("USER_EMAIL", it.data.email)
                                }
                                finish()
                            }
                        }

                    })
            } else showToast("Cek kembali")
        }

        txtRegister.setOnClickListener {
            Intent(this, RegisterActivity::class.java).apply {
                startActivity(this)
            }
        }

    }

    private fun validateInput(): Boolean {
        if (inpEmail.toString().isNotEmpty()) return true
        if (inpPassword.toString().isNotEmpty()) return true
        return false
    }

}
