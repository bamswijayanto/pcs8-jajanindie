package com.bamswijayanto.jajanindie.ui.home

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.bamswijayanto.jajanindie.R
import com.bamswijayanto.jajanindie.databinding.ActivityMainBinding
import com.bamswijayanto.jajanindie.ui.auth.AuthActivity
import com.bamswijayanto.jajanindie.ui.auth.JajanindieAuth

class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        /*binding.buttonLogout.setOnClickListener {
            JajanindieAuth.logout(this) {
                startActivity(Intent(this, AuthActivity::class.java))
                finish()
            }
        }*/
        init()
    }

    private fun init() {
        binding.bottomNav.setOnNavigationItemSelectedListener{
            when(it.itemId){
                R.id.ic_home -> navigate(R.id.homeFragment)
                R.id.ic_manga -> navigate(R.id.mangaFragment)
                R.id.ic_favorite -> navigate(R.id.favoriteFragment)
                R.id.ic_profile -> navigate(R.id.profileFragment)
                else -> false
            }
        }
    }

    private fun navigate(id: Int): Boolean {
        findNavController(R.id.navHost).navigate(id)
        return true
    }
}