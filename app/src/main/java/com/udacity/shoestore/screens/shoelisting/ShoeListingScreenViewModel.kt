package com.udacity.shoestore.screens.shoelisting

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe
import timber.log.Timber

class ShoeListingScreenViewModel : ViewModel() {
    var shoes = MutableLiveData<MutableList<Shoe>>()

    init {
        shoes = MutableLiveData(com.udacity.shoestore.models.initialShoeValues)
    }

    fun addShoe(shoe: Shoe) {
        shoes.value?.add(shoe)
    }

    fun deleteShoe(position : Int) {
        Timber.i("deleting shoe with index $position")
        shoes.value?.removeAt(position)
    }
}