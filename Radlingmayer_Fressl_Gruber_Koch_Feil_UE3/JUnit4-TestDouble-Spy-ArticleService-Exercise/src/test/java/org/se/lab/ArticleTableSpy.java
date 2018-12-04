package org.se.lab;

import java.util.ArrayList;
import java.util.List;

public class ArticleTableSpy implements ArticleTable {
    public List<String> logs = new ArrayList<String>();
    private ArticleTable articleTable;


    @Override
    public void insert(Article p) {
        logs.add("ArticleTable.insert " + p);
        articleTable.insert(p);
    }

    @Override
    public void update(Article p) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public Article findById(int id) {
        return null;
    }

    @Override
    public List<Article> findAll() {
        List<Article> articles = articleTable.findAll();
        String s = "ArticleTable.findAll() " + articles;
        logs.add(s);
        return articles;
    }

    public ArticleTableSpy(ArticleTable articleTable) {
        if (articleTable == null) {
            throw new IllegalArgumentException();
        }
        this.articleTable = articleTable;
    }

}