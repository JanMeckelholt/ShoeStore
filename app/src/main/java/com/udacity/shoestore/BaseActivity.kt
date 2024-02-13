package com.udacity.shoestore

import android.os.Handler
import android.os.Looper
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.google.android.material.snackbar.Snackbar
import timber.log.Timber

open class BaseActivity : AppCompatActivity() {

    fun showErrorSnackBar(message: String) {
        val snackBar =
            Snackbar.make(findViewById(android.R.id.content), message, Snackbar.LENGTH_LONG)
        val snackBarView = snackBar.view
        snackBarView.setBackgroundColor(ContextCompat.getColor(this, R.color.errorColor))
        snackBar.show()
    }

    private var doubleBackToExitPressedOnce = false
    override fun onBackPressed() {
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.navHostFragment)
        val backStackEntryCount = navHostFragment?.childFragmentManager?.backStackEntryCount
        Timber.i("backstackEntryCount: $backStackEntryCount")
        if (backStackEntryCount == 0) {
            if (doubleBackToExitPressedOnce) {
                super.onBackPressed()
                return
            }

            this.doubleBackToExitPressedOnce = true
            Toast.makeText(this, "Click BACK again to exit the App", Toast.LENGTH_SHORT).show()

            Handler(Looper.getMainLooper()).postDelayed(Runnable {
                doubleBackToExitPressedOnce = false
            }, 2000)
        } else {
            super.onBackPressed()
        }


    }

}