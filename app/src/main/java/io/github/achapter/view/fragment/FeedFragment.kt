package io.github.achapter.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.smarteist.autoimageslider.IndicatorAnimations
import com.smarteist.autoimageslider.SliderAnimations
import com.smarteist.autoimageslider.SliderView
import io.github.achapter.R
import io.github.achapter.adapter.FeedAdapter
import io.github.achapter.data.FeedFactory
import io.github.achapter.adapter.SliderAdapter
import kotlinx.android.synthetic.main.fragment_feed.*

class FeedFragment : Fragment() {

    private lateinit var sliderView: SliderView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_feed, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        sliderView = view.findViewById(R.id.sliderView)

        val sliderAdapter = SliderAdapter(view.context)
        sliderView.sliderAdapter = sliderAdapter
        sliderView.setIndicatorAnimation(IndicatorAnimations.WORM)
        sliderView.setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION)
        sliderView.autoCycleDirection = SliderView.AUTO_CYCLE_DIRECTION_BACK_AND_FORTH
        sliderView.scrollTimeInSec = 4

        sliderView.startAutoCycle()

        setupRecyclerView(rvFeed)

    }

    private fun setupRecyclerView(recyclerView: RecyclerView){
        val rvAdapter = FeedAdapter(FeedFactory.getFeeds(4))
        recyclerView.apply {
            hasFixedSize()
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            adapter = rvAdapter
        }
    }

}

