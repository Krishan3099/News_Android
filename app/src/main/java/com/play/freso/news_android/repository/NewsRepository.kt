package com.play.freso.news_android.repository

import androidx.room.Query
import com.play.freso.news_android.api.RetrofitInstance
import com.play.freso.news_android.db.ArticleDatabase
import com.play.freso.news_android.models.Article

class NewsRepository(
    val db: ArticleDatabase
) {
    suspend fun getBreakingNews(countryCode: String, pageNumber: Int) =
        RetrofitInstance.api.getBreakingNews(countryCode, pageNumber)

    suspend fun searchNews(searchQuery: String, pageNumber: Int) =
        RetrofitInstance.api.searchForNews(searchQuery, pageNumber)

    suspend fun insertArticle(article: Article) = db.articleDao.insertArticle(article)

    suspend fun deleteArticle(article: Article) = db.articleDao.deleteArticle(article)

    fun getSavedNews() = db.articleDao.getAllArticles()
}