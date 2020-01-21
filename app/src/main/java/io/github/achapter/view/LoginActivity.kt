package io.github.achapter.view

import android.content.SharedPreferences
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import io.github.achapter.R
import io.github.achapter.service.ApiService
import io.github.achapter.service.IService
import io.github.achapter.service.response.ResponseLogin
import io.github.achapter.util.PreferenceHelper
import io.github.achapter.util.toast
import io.github.achapter.viewmodel.LoginViewModel
import kotlinx.android.synthetic.main.activity_login.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit

class LoginActivity : AppCompatActivity() {

    private lateinit var sharedPreferences: PreferenceHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

//        loginViewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory()).get(LoginViewModel::class.java)

        val client = ApiService.getClient().create(IService::class.java)
        sharedPreferences = PreferenceHelper(this)

        btnLogin.setOnClickListener {
            if (validateInput()) {
                client.submitLogin(inpEmail.text.toString(), inpPassword.text.toString())
                    .enqueue(object : Callback<ResponseLogin> {
                        override fun onFailure(call: Call<ResponseLogin>, t: Throwable) {
                            toast(t.message!!)
                        }

                        override fun onResponse(
                            call: Call<ResponseLogin>,
                            response: Response<ResponseLogin>
                        ) {
                            response.body()?.let {
                                with(sharedPreferences) {
                                    setBoolean("IS_LOGGED_IN", true)
                                    setToken(it.token.token)
                                    setInt("USER_ID", it.data.id)
                                    setString("USER_NAME", it.data.name)
                                    setString("USER_EMAIL", it.data.email)
                                    setString("USER_ADDRESS", it.data.address)
                                }
                                finish()
                            }
                        }

                    })
            } else toast("Cek kembali")
        }

    }

    private fun validateInput(): Boolean {
        if (inpEmail.toString().isNotEmpty()) return true
        if (inpPassword.toString().isNotEmpty()) return true
        return false
    }

}
