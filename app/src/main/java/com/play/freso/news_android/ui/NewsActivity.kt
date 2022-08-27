package com.play.freso.news_android.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.play.freso.news_android.R
import com.play.freso.news_android.databinding.ActivityNewsBinding
import com.play.freso.news_android.db.ArticleDatabase
import com.play.freso.news_android.models.Article
import com.play.freso.news_android.repository.NewsRepository

class NewsActivity : AppCompatActivity() {

    lateinit var binding: ActivityNewsBinding
    lateinit var viewModel: NewsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNewsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val newsRepository = NewsRepository(ArticleDatabase.getInstance(this))
        val viewModelProviderFactory = NewsViewModelProviderFactory(newsRepository)
        viewModel = ViewModelProvider(this, viewModelProviderFactory)[NewsViewModel::class.java]
        val navController = (supportFragmentManager.findFragmentById(R.id.newsNavHostFrag) as NavHostFragment).navController

        binding.bottomNavigationView.setupWithNavController(navController)
    }
}