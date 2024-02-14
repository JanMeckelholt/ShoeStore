package com.udacity.shoestore.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


@Parcelize
data class Shoe(
    var name: String,
    var size: Double,
    var company: String,
    var description: String,
    val images: List<String> = mutableListOf()
) : Parcelable



var initialShoeValues = mutableListOf<Shoe>(
    Shoe(company = "Nike", name = "Jordan", size = 10.0, description = "Basketball Shoe", images = listOf<String>("@drawable/jordan_1", "@drawable/jordan_2")),
    Shoe(company = "Nike", name = "Pegasus", size = 10.5, description = "Running Shoe", images = listOf<String>("@drawable/pegasus_1", "@drawable/pegasus_2", "@drawable/pegasus_3")),
    Shoe(company = "Adidas", name = "Adizero", size = 7.0, description = "Running Shoe", images = listOf<String>("@drawable/adizero_1")),


)