package org.se.lab;

import java.util.ArrayList;
import java.util.List;

public class ArticleTableStub implements ArticleTable {

    List<Article> articles = new ArrayList<Article>();
    RuntimeException exception;


    @Override
    public void insert(Article p) {
        if(exception != null)
        {
            throw exception;
        }
        articles.add(p);
    }

    @Override
    public void update(Article p) {

    }

    @Override
    public void delete(int id) {
        articles.remove(id);
    }

    @Override
    public Article findById(int id) {
        return articles.get(id);
    }

    @Override
    public List<Article> findAll() {
        if(exception != null)
        {
            throw exception;
        }
        return articles;
    }

}
