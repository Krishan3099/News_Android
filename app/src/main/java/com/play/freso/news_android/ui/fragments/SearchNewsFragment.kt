package com.play.freso.news_android.ui.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.play.freso.news_android.R
import com.play.freso.news_android.ui.NewsActivity
import com.play.freso.news_android.ui.NewsViewModel

class SearchNewsFragment: Fragment(R.layout.fragment_search_news) {

    lateinit var viewModel: NewsViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = (activity as NewsActivity).viewModel
    }
}