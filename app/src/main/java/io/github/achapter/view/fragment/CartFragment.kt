package io.github.achapter.view.fragment


import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController

import io.github.achapter.R
import io.github.achapter.util.PreferenceHelper
import io.github.achapter.view.LoginActivity

/**
 * A simple [Fragment] subclass.
 */
class CartFragment : Fragment() {

    private lateinit var sharedPreferences: PreferenceHelper

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_cart, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        sharedPreferences = PreferenceHelper(view.context)
        val loggedIn = sharedPreferences.getBoolean("IS_LOGGED_IN")

        if(!loggedIn){
            findNavController().popBackStack()
            startActivity(Intent(view.context, LoginActivity::class.java))
        }

    }

}
