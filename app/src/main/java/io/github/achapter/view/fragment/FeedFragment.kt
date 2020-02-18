package io.github.achapter.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.smarteist.autoimageslider.IndicatorAnimations
import com.smarteist.autoimageslider.SliderAnimations
import com.smarteist.autoimageslider.SliderView
import io.github.achapter.R
import io.github.achapter.adapter.FeedAdapter
import io.github.achapter.adapter.SliderAdapter
import io.github.achapter.data.PromoFactory
import io.github.achapter.model.BookDisplay
import io.github.achapter.util.showToast
import io.github.achapter.viewmodel.FeedViewModel
import kotlinx.android.synthetic.main.fragment_feed.*

class FeedFragment : Fragment() {

    private lateinit var sliderView: SliderView
    private lateinit var feedViewModel: FeedViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_feed, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        sliderView = view.findViewById(R.id.sliderView)

        val sliderAdapter = SliderAdapter()
        sliderAdapter.listPromos.addAll(PromoFactory.getPromos(4))
        sliderView.sliderAdapter = sliderAdapter
        sliderView.setIndicatorAnimation(IndicatorAnimations.WORM)
        sliderView.setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION)
        sliderView.autoCycleDirection = SliderView.AUTO_CYCLE_DIRECTION_BACK_AND_FORTH
        sliderView.scrollTimeInSec = 4

        sliderView.startAutoCycle()

        feedViewModel = ViewModelProvider(
            this,
            ViewModelProvider.NewInstanceFactory()
        ).get(FeedViewModel::class.java)
        feedViewModel.setFeeds()

        setupRecyclerView(rvFeed)

    }

    private fun setupRecyclerView(recyclerView: RecyclerView) {
        val feedAdapter = FeedAdapter()
        feedViewModel.getFeeds().observe(this, Observer {
            if (it != null) feedAdapter.listFeeds.addAll(it)
            feedAdapter.notifyDataSetChanged()
        })
        feedAdapter.setOnItemClickCallback(object : FeedAdapter.OnItemClickCallback {
            override fun onItemClicked(data: BookDisplay) {
                context?.showToast("${data.title} clicked")
            }
        })
        recyclerView.apply {
            hasFixedSize()
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            adapter = feedAdapter
        }
    }

}

