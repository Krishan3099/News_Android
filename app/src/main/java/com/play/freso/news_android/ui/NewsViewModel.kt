package com.play.freso.news_android.ui

import androidx.lifecycle.ViewModel
import com.play.freso.news_android.repository.NewsRepository

class NewsViewModel(
    val newsRepository: NewsRepository
) : ViewModel() {

}