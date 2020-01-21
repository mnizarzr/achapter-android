package io.github.achapter.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.github.achapter.model.LoginForm

class LoginViewModel : ViewModel(){

    var email = MutableLiveData<String>()
    var password = MutableLiveData<String>()

    val user: MutableLiveData<LoginForm>? = null



}