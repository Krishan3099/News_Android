package com.play.freso.news_android.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.play.freso.news_android.R
import com.play.freso.news_android.databinding.ItemArticlePreviewBinding
import com.play.freso.news_android.models.Article

class NewsAdapter: RecyclerView.Adapter<NewsAdapter.ArticleViewHolder>(){
    inner class ArticleViewHolder(val binding: ItemArticlePreviewBinding) : RecyclerView.ViewHolder(binding.root)

    private val diffUtil = object : DiffUtil.ItemCallback<Article>(){
        override fun areItemsTheSame(oldItem: Article, newItem: Article): Boolean {
            return oldItem.url == newItem.url
        }

        override fun areContentsTheSame(oldItem: Article, newItem: Article): Boolean {
            return oldItem == newItem
//            return when {
//                oldItem.url != newItem.url -> false
//                oldItem.content != oldItem.content -> false
//                else -> true
//            }
        }

    }

    val listDiffer = AsyncListDiffer(this, diffUtil)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder {
        return ArticleViewHolder(
            ItemArticlePreviewBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
//        return ArticleViewHolder(
//            LayoutInflater.from(parent.context).inflate(
//                R.layout.item_article_preview,
//                parent,
//                false
//            )
//        )
    }

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
        val article = listDiffer.currentList[position]
        holder.binding.apply {
            tvSource.text = article.source.name
            tvTitle.text = article.title
            tvDescription.text = article.description
            tvPublishedAt.text = article.publishedAt
            Glide
                .with(this.root)
                .load(article.urlToImage)
                .into(ivArticleImage)
        }
        holder.binding.root.setOnClickListener {
            onItemClickListener?.let{it(article)}
        }
    }


    override fun getItemCount(): Int {
        return listDiffer.currentList.size
    }

    fun setData(newList: List<Article>) = listDiffer.submitList(newList)

    private var onItemClickListener: ((Article) -> Unit)? = null

    fun setOnItemClickListener(listener: (Article) -> Unit){
        onItemClickListener = listener
    }
}