package com.bamswijayanto.jajanindie.ui.auth

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.bamswijayanto.jajanindie.R
import com.bamswijayanto.jajanindie.data.model.AuthUser
import com.bamswijayanto.jajanindie.databinding.ActivityAuthBinding
import com.bamswijayanto.jajanindie.ui.home.MainActivity

class AuthActivity : AppCompatActivity() {
    lateinit var binding: ActivityAuthBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_auth)
    }
    fun onSuccess(user: AuthUser?){
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }
}