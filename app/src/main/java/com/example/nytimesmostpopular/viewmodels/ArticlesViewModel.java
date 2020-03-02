package com.example.nytimesmostpopular.viewmodels;

import com.example.nytimesmostpopular.models.Article;
import com.example.nytimesmostpopular.repositories.ArticlesRepository;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ArticlesViewModel extends ViewModel {

    private MutableLiveData<List<Article>> articleList;
    private ArticlesRepository mRepo;

    public void init(){
        if(articleList != null){
            return;
        }
        mRepo = ArticlesRepository.getInstance();
        articleList = mRepo.getArticles();
    }

    public LiveData<List<Article>> getArticles() {
        return articleList;
    }

}
