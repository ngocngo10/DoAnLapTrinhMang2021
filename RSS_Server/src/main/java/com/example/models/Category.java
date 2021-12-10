/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.models;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author mba0205 lam sao de chay
 */

@Entity
@Table(name = "categories")
public class Category implements Serializable {
    private static final long serialVersionUID = -297553281792804396L;

    public static Category findByCategoryId(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int categoriesId;
    
    @Column(name = "categories_title")
    private String categoriesTitle;
    
    @Column(name = "news_id")
    private int newsId;
    
    @Column(name = "rss_link")
    private String rssLink;

    public int getCategoriesId() {
        return categoriesId;
    }

    public void setCategoriesId(int categoriesId) {
        this.categoriesId = categoriesId;
    }

    public String getCategoriesTitle() {
        return categoriesTitle;
    }

    public void setCategoriesTitle(String categoriesTitle) {
        this.categoriesTitle = categoriesTitle;
    }
    
    public int getNewsId() {
        return newsId;
    }

    public void setNewsId(int newsId) {
        this.newsId = newsId;
    }

    public String getRssLink() {
        return rssLink;
    }

    public void setRssLink(String rssLink) {
        this.rssLink = rssLink;
    }
//    public String getTitle() {
//        return categoriesTitle;
//    }
//
//    public int getId() {
//        return categoriesId;
//    }
//
//    public String getRssLink() {
//        return rssLink;
//    }
//
//    public int getNewsId() {
//        return newsId;
//    }
//
//    public void setId(int id) {
//        this.categoriesId = id;
//    }
//
//    public void setTitle(String title) {
//        this.categoriesTitle = title;
//    }
//
//    public void setNewsId(int newsId) {
//        this.newsId = newsId;
//    }
//
//    public void setRssLink(String rssLink) {
//        this.rssLink = rssLink;
//    }

    
}
