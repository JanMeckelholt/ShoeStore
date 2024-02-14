package com.udacity.shoestore.screens.shoelisting

import android.content.Context
import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.udacity.shoestore.R
import com.udacity.shoestore.models.Shoe
import timber.log.Timber


class ShoeAdapter(private val shoes: List<Shoe>, private val ctx: Context, private val shoeListingScreenViewModel: ShoeListingScreenViewModel) :
    RecyclerView.Adapter<ShoeAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvShoeName: TextView
        val tvShoeSize: TextView
        val tvShoeCompany: TextView
        val tvShoeDesc: TextView
        val ivShoe: ImageView
        val btnPrev: Button
        val btnNext: Button
        val btnDeleteShoe : Button
        var currentImageIndex: Int

        init {
            // Define click listener for the ViewHolder's View
            tvShoeName = view.findViewById(R.id.tvShoeName)
            tvShoeSize = view.findViewById(R.id.tvShoeSize)
            tvShoeCompany = view.findViewById(R.id.tvShoeCompany)
            tvShoeDesc = view.findViewById(R.id.tvShoeDesc)
            ivShoe = view.findViewById(R.id.ivShoe)
            btnPrev = view.findViewById(R.id.btnPrev)
            btnNext = view.findViewById(R.id.btnNext)
            btnDeleteShoe = view.findViewById(R.id.btnDeleteShoe)

            currentImageIndex = 0
        }
    }


    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        Timber.i("shoeAdapter viewHolder created")
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.card_view_shoe, viewGroup, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.btnDeleteShoe.setOnClickListener {
            Timber.i("shoes: $shoes")
            shoeListingScreenViewModel.deleteShoe(position)
            viewHolder.currentImageIndex = 0
            notifyDataSetChanged()
            Timber.i("removed postion: $position")
            Timber.i("shoes: $shoes")
        }
        viewHolder.btnNext.isVisible = false
        viewHolder.btnPrev.isVisible = false
        viewHolder.btnNext.setOnClickListener {
            if (shoes[position].images.size > viewHolder.currentImageIndex + 1) {
                viewHolder.currentImageIndex++
                viewHolder.ivShoe.setImageDrawable(
                    GetImage(
                        ctx,
                        shoes[position].images[viewHolder.currentImageIndex]
                    )
                )
                Timber.i("current Image Index increased to: ${viewHolder.currentImageIndex}")
                viewHolder.btnPrev.isVisible = true
                if (shoes[position].images.size <= viewHolder.currentImageIndex + 1) {
                    viewHolder.btnNext.isVisible = false
                }
            }
        }
        viewHolder.btnPrev.setOnClickListener {
            if (viewHolder.currentImageIndex > 0) {

                viewHolder.currentImageIndex--
                viewHolder.ivShoe.setImageDrawable(
                    GetImage(
                        ctx,
                        shoes[position].images[viewHolder.currentImageIndex]
                    )
                )
                Timber.i("current Image Index decreased to: ${viewHolder.currentImageIndex}")
                viewHolder.btnNext.isVisible = true
                if (viewHolder.currentImageIndex <= 0) {
                    viewHolder.btnPrev.isVisible = false
                }
            }
        }

        Timber.i("Shoe Position: $position")
        Timber.i("Shoe name: ${shoes[position].name}")
        viewHolder.tvShoeName.text = "Name: ${shoes[position].name}"
        viewHolder.tvShoeSize.text = "Size: ${shoes[position].size}"
        viewHolder.tvShoeCompany.text = "Company: ${shoes[position].company}"
        viewHolder.tvShoeDesc.text = "Description: ${shoes[position].description}"

        if (shoes[position].images.isNotEmpty()) {
            viewHolder.ivShoe.setImageDrawable(
                GetImage(
                    ctx,
                    shoes[position].images[viewHolder.currentImageIndex]
                )
            )
            if (shoes[position].images.size > viewHolder.currentImageIndex + 1) {
                viewHolder.btnNext.isVisible = true
            }
            if (viewHolder.currentImageIndex > 0) {
                viewHolder.btnPrev.isVisible = true
            }
        } else {
            viewHolder.ivShoe.setImageDrawable(
                GetImage(
                    ctx,
                    "@drawable/no_image_available"
                )
            )
            viewHolder
        }
    }

    override fun getItemCount() = shoes.size

    //adapted from https://stackoverflow.com/questions/22664938/get-drawable-by-string
    fun GetImage(c: Context, ImageName: String?): Drawable? {
        return c.resources.getDrawable(
            c.resources.getIdentifier(
                ImageName,
                "drawable",
                c.packageName
            )
        )
    }


}
