package io.github.achapter.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import coil.api.load
import io.github.achapter.R
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        imageView2.load(intent.getStringExtra("img"))
        textView2.text = intent.getStringExtra("judul")

    }
}
