package io.github.mnizarzr.achapter.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import coil.api.load
import com.smarteist.autoimageslider.SliderViewAdapter
import io.github.achapter.R
import kotlinx.android.synthetic.main.item_image_slider.view.*

class SliderAdapter(context: Context) : SliderViewAdapter<SliderAdapter.SliderAdapterVH>() {

    private val context: Context

    override fun onCreateViewHolder(parent: ViewGroup): SliderAdapterVH {
        val inflate: View =
            LayoutInflater.from(parent.context).inflate(R.layout.item_image_slider, null)
        return SliderAdapterVH(inflate)
    }

    override fun onBindViewHolder(viewHolder: SliderAdapterVH, position: Int) {
        viewHolder.textViewDescription.text = "This is slider item $position"
        when (position) {
            0 -> viewHolder.imageViewBackground.load("https://images.pexels.com/photos/218983/pexels-photo-218983.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260")
            1 -> viewHolder.imageViewBackground.load("https://images.pexels.com/photos/747964/pexels-photo-747964.jpeg?auto=compress&cs=tinysrgb&h=750&w=1260")
            2 -> viewHolder.imageViewBackground.load("https://images.pexels.com/photos/929778/pexels-photo-929778.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260")
            else -> viewHolder.imageViewBackground.load("https://images.pexels.com/photos/218983/pexels-photo-218983.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260")
        }
    }

    override fun getCount(): Int {
        return 4
    }

    inner class SliderAdapterVH(itemView: View) : ViewHolder(itemView) {
        var itemView: View
        var imageViewBackground: ImageView
        var textViewDescription: TextView

        init {
            imageViewBackground = itemView.findViewById(R.id.img_slider)
            textViewDescription = itemView.findViewById(R.id.text_slider)
            this.itemView = itemView
        }
    }

    init {
        this.context = context
    }
}