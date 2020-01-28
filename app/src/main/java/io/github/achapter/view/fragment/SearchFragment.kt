package io.github.achapter.view.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager

import io.github.achapter.R
import io.github.achapter.adapter.GenreAdapter
import io.github.achapter.model.Genre
import io.github.achapter.view.FeedResultActivity
import io.github.achapter.viewmodel.GenreViewModel
import kotlinx.android.synthetic.main.fragment_search.*

class SearchFragment : Fragment() {

    private lateinit var genreViewModel: GenreViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_search, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        genreViewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory())
            .get(GenreViewModel::class.java)

        genreViewModel.setGenres()

        val genreAdapter = GenreAdapter()
        rvGenre.apply {
            layoutManager = LinearLayoutManager(context)
            addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))
            adapter = genreAdapter
        }

        genreViewModel.getGenres().observe(this, Observer {
            if (it != null) genreAdapter.setData(it)
        })

        genreAdapter.setOnItemClickCallback(object: GenreAdapter.OnItemClickCallback{
            override fun onItemClicked(data: Genre) {
                Intent(context, FeedResultActivity::class.java).apply {
                    putExtra(FeedResultActivity.EXTRA_DATA, data)
                    startActivity(this)
                }
            }

        })

    }

}
