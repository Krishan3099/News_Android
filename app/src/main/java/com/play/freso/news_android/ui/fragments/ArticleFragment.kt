package com.play.freso.news_android.ui.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.play.freso.news_android.R
import com.play.freso.news_android.databinding.FragmentArticleBinding
import com.play.freso.news_android.databinding.FragmentSavedNewsBinding
import com.play.freso.news_android.ui.NewsActivity
import com.play.freso.news_android.ui.NewsViewModel

class ArticleFragment: Fragment(R.layout.fragment_article) {

    lateinit var viewModel: NewsViewModel
    lateinit var binding: FragmentArticleBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentArticleBinding.bind(view)
        viewModel = (activity as NewsActivity).viewModel
    }

}