package com.play.freso.news_android

data class NewsResponse(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)