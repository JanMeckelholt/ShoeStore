package com.udacity.shoestore

import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import com.udacity.shoestore.databinding.ActivityMainBinding
import timber.log.Timber


class MainActivity : BaseActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Timber.i("onCreate called")
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

    }

}
