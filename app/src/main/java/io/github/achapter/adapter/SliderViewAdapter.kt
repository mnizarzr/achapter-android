package io.github.achapter.adapter

import android.util.Log
import android.view.View
import android.view.ViewGroup
import coil.api.load
import com.smarteist.autoimageslider.SliderViewAdapter
import io.github.achapter.R
import io.github.achapter.util.inflate
import io.github.achapter.model.Promo
import kotlinx.android.synthetic.main.item_image_slider.view.*

class SliderAdapter : SliderViewAdapter<SliderAdapter.SliderAdapterVH>() {

    var listPromos = arrayListOf<Promo>()

    override fun onCreateViewHolder(parent: ViewGroup): SliderAdapterVH =
        SliderAdapterVH(parent.inflate(R.layout.item_image_slider))

    override fun onBindViewHolder(viewHolder: SliderAdapterVH, position: Int) {
        viewHolder.bind(listPromos[position])
    }

    override fun getCount(): Int = listPromos.size

    inner class SliderAdapterVH(private val itemView: View) : ViewHolder(itemView) {
        fun bind(data: Promo) {
            Log.d("TAG", data.toString())
            with(itemView) {
//                text_slider.text = data.text
                img_slider.load(data.banner)
            }
        }
    }

}