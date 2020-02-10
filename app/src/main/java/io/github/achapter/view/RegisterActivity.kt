package io.github.achapter.view

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import io.github.achapter.R
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        txtLogin.setOnClickListener {
            finish()
        }

        btnRegister.setOnClickListener {
            finish()
            startActivity(Intent(this@RegisterActivity, LoginActivity::class.java))
        }

    }

    override fun onBackPressed() {
        finish()
    }

}
