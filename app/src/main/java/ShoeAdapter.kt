import android.content.Context
import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ListAdapter
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.udacity.shoestore.R
import com.udacity.shoestore.models.Shoe
import timber.log.Timber


class ShoeAdapter(private val shoes: List<Shoe>, private val ctx: Context) :
    RecyclerView.Adapter<ShoeAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvShoeName: TextView
        val tvShoeSize: TextView
        val tvShoeCompany: TextView
        val tvShoeDesc: TextView
        val ivShoe: ImageView

        init {
            // Define click listener for the ViewHolder's View
            tvShoeName = view.findViewById(R.id.tvShoeName)
            tvShoeSize = view.findViewById(R.id.tvShoeSize)
            tvShoeCompany = view.findViewById(R.id.tvShoeCompany)
            tvShoeDesc = view.findViewById(R.id.tvShoeDesc)
            ivShoe = view.findViewById(R.id.ivShoe)
        }
    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        Timber.i("shoeAdapter viewHolder created")
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.card_view_shoe, viewGroup, false)

        return ViewHolder(view)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

        Timber.i("Shoe Position: $position")
        Timber.i("Shoe name: ${shoes[position].name}")
        viewHolder.tvShoeName.text = "Name: ${shoes[position].name}"
        viewHolder.tvShoeSize.text = "Size: ${shoes[position].size}"
        viewHolder.tvShoeCompany.text = "Company: ${shoes[position].company}"
        viewHolder.tvShoeDesc.text = "Description: ${shoes[position].description}"
        viewHolder.ivShoe.setImageDrawable(GetImage(ctx, shoes[position].images[0]))

    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = shoes.size


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
