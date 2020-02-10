package io.github.achapter.view

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import io.github.achapter.R
import io.github.achapter.util.PreferenceHelper
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var navController: NavController
    private lateinit var sharedPreferences: PreferenceHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sharedPreferences = PreferenceHelper(this)
        val loggedIn = sharedPreferences.getBoolean("IS_LOGGED_IN")

        navController = findNavController(R.id.navHostFragment)
        bottomNav.setupWithNavController(navController)

        navController.addOnDestinationChangedListener { controller, destination, arguments ->
            when (destination.id) {
                R.id.profileFragment -> if (!loggedIn) onUnauthenticated(controller)
                R.id.cartFragment -> if (!loggedIn) onUnauthenticated(controller)
            }
        }

    }

    private fun onUnauthenticated(controller: NavController) {
        startActivity(Intent(this, LoginActivity::class.java))
        controller.popBackStack()
    }

}
