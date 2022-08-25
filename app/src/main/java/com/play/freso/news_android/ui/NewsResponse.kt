package com.play.freso.news_android.ui

data class NewsResponse(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)