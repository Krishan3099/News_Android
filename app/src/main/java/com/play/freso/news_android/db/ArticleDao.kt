package com.play.freso.news_android.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.play.freso.news_android.models.Article

@Dao
interface ArticleDao{

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertArticle(article: Article): Long

    @Transaction
    @Query("SELECT * FROM articles")
    fun getAllArticles(): LiveData<List<Article>>

    @Transaction
    @Delete
    suspend fun deleteArticle(article: Article)
}