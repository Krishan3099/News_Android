package com.play.freso.news_android.ui.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.play.freso.news_android.R
import com.play.freso.news_android.adapters.NewsAdapter
import com.play.freso.news_android.databinding.FragmentSavedNewsBinding
import com.play.freso.news_android.databinding.FragmentSearchNewsBinding
import com.play.freso.news_android.ui.NewsActivity
import com.play.freso.news_android.ui.NewsViewModel

class SavedNewsFragment: Fragment(R.layout.fragment_saved_news) {

    lateinit var viewModel: NewsViewModel
    private lateinit var newsAdapter: NewsAdapter
    private lateinit var binding: FragmentSavedNewsBinding
    private val TAG = "Search News Fragment"


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentSavedNewsBinding.bind(view)
        viewModel = (activity as NewsActivity).viewModel

        setupRecyclerView()



        newsAdapter.setOnItemClickListener {
            val bundle = Bundle().apply {
                putSerializable("article", it)
            }
            findNavController().navigate(
                R.id.action_searchNewsFragment_to_articleFragment,
                bundle
            )
        }

    }


    private fun setupRecyclerView() {
        newsAdapter = NewsAdapter()
        binding.rvSavedNews.apply {
            adapter = newsAdapter
            layoutManager = LinearLayoutManager(activity)
        }
    }

}