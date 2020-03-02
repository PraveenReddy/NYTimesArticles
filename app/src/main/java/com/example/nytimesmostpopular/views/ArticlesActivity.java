package com.example.nytimesmostpopular.views;

import android.os.Bundle;

import com.example.nytimesmostpopular.R;
import com.example.nytimesmostpopular.adapters.ArticleAdapter;
import com.example.nytimesmostpopular.models.Article;
import com.example.nytimesmostpopular.viewmodels.ArticlesViewModel;

import java.util.List;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class ArticlesActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ArticleAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        ArticlesViewModel model = ViewModelProviders.of(this).get(ArticlesViewModel.class);
        model.init();
        model.getArticles().observe(this, new Observer<List<Article>>() {
            @Override
            public void onChanged(@Nullable List<Article> articleList) {
                adapter = new ArticleAdapter(ArticlesActivity.this, articleList);
                recyclerView.setAdapter(adapter);
            }
        });
    }
}
