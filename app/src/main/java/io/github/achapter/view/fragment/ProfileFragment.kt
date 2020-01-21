package io.github.achapter.view.fragment


import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import io.github.achapter.R
import io.github.achapter.util.PreferenceHelper
import io.github.achapter.view.LoginActivity
import kotlinx.android.synthetic.main.fragment_profile.*

/**
 * A simple [Fragment] subclass.
 */
class ProfileFragment : Fragment() {

    private lateinit var sharedPreferences: PreferenceHelper

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_profile, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        sharedPreferences = PreferenceHelper(view.context)
        val loggedIn = sharedPreferences.getBoolean("IS_LOGGED_IN")

        if(!loggedIn){
            startActivity(Intent(view.context, LoginActivity::class.java))
            findNavController().popBackStack()
        }

        txtUsername.text = sharedPreferences.getString("USER_NAME")
        txtEmail.text = sharedPreferences.getString("USER_EMAIL")


    }

}
