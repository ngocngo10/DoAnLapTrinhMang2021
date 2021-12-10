/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.controllers;

import com.example.models.Category;
import com.example.models.News;
import com.example.repository.CategoryRepository;
import com.example.repository.NewsRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author mba0205
 */
@RestController
public class NewsController {

    @Autowired
    private NewsRepository newsRepository;
    @Autowired
    private CategoryRepository categoryRepository;

    @RequestMapping(
            value = "/news",
            method = RequestMethod.GET,
            produces = {"application/json", "application/xml"})
    public List<News> list() {
        return newsRepository.findAll();
    }

    @RequestMapping(
            value = "/news",
            method = RequestMethod.POST,
            produces = {"application/json", "application/xml"})
    public News createNews(@RequestBody News news) {
        try {
            return newsRepository.save(news);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @RequestMapping(
            value = "/news/{id}",
            method = RequestMethod.PUT,
            produces = {"application/json", "application/xml"})
    public News updateNews(@PathVariable("id") int id, @RequestBody News news) {
        News oldNews = newsRepository.findByNewsId(id);
        news.setNewsId(oldNews.getNewsId());
        return newsRepository.save(news);
    }

    @DeleteMapping("/news/{id}")
    public ResponseEntity<?> deleteNews(@PathVariable("id") int id) {
        categoryRepository.deleteByNewsId(id);
        newsRepository.deleteByNewsId(id);
        
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
    @GetMapping("/news/{id}")
    public News getNews(@PathVariable("id") int id) {
        return newsRepository.findByNewsId(id);
    }
    @GetMapping("/{newsTitle}")
    public News getNews2(@PathVariable("newsTitle") String newsTitle) {
        return newsRepository.findByNewsTitle(newsTitle);
    }

}
