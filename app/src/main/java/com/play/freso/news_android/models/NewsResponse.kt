package com.play.freso.news_android.models

import com.play.freso.news_android.models.Article

data class NewsResponse(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)