package com.example.nytimesmostpopular.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.nytimesmostpopular.R;
import com.example.nytimesmostpopular.models.Article;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ArticleAdapter extends RecyclerView.Adapter<ArticleAdapter.ArticleViewHolder>{

    Context mCtx;
    List<Article> articleList;

    public ArticleAdapter(Context mCtx, List<Article> articleList) {
        this.mCtx = mCtx;
        this.articleList = articleList;
    }
    @NonNull
    @Override
    public ArticleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mCtx).inflate(R.layout.rv_row_item, parent, false);
        return new ArticleViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ArticleViewHolder holder, int position) {
        Article article = articleList.get(position);
        holder.header.setText(article.getArticle_details());
        holder.author.setText(article.getByline());
        holder.date.setText(article.getPublished_date());
    }

    @Override
    public int getItemCount() {
        return articleList.size();
    }

    class ArticleViewHolder extends RecyclerView.ViewHolder {

        TextView header, author, date;

        public ArticleViewHolder(View itemView) {
            super(itemView);

            header = itemView.findViewById(R.id.tvHeader);
            author = itemView.findViewById(R.id.tvAuthor);
            date = itemView.findViewById(R.id.tvDate);
        }
    }
}
