package com.udacity.shoestore

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.udacity.shoestore.databinding.ActivityMainBinding
import com.udacity.shoestore.models.Shoe
import timber.log.Timber

class MainActivity : BaseActivity() {
    private lateinit var binding: ActivityMainBinding
    //private val myShoe : Shoe = Shoe(name = "Boot", company = "Adidas", size = 12.0, description = "great shoe")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Timber.i("onCreate called")
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //binding.myShoe = myShoe
    }
}
