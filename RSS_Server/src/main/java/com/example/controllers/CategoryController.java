/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.controllers;

import com.example.repository.NewsRepository;
import com.example.models.Category;
import com.example.models.News;
import com.example.repository.CategoryRepository;
import java.util.List;
import static org.hibernate.criterion.Projections.id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author mba0205
 */
@RestController
public class CategoryController {

    @Autowired
    private CategoryRepository categoryRepository;

// Lấy tất cả các chủ đề của 1 bài báo
    @RequestMapping(
            value = "/news/{id}/categories",
            method = RequestMethod.GET,
            produces = {"application/json", "application/xml"})
    public List<Category> list(@PathVariable("id") int id) {
        return categoryRepository.findByNewsId(id);

    }
// Láy 1 chủ đề của 1 bài báo

    @GetMapping("/news/{newsId}/categories/{categoriesId}")
    public Category getCategory(@PathVariable("newsId") int newsId, @PathVariable("categoriesId") int categoriesId) {
        return categoryRepository.findByCategoriesIdAndNewsId(categoriesId, newsId);
    }

//Tạo 1 chủ đề trong 1 bài báo nào đó
    @PostMapping("/news/{newsId}/categories")
    public Category createCategory(@RequestBody Category category,@PathVariable("newsId") int newsId) {
        try {
            category.setNewsId(newsId);
            return categoryRepository.save(category);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    
 //Cập nhật các 1 chủ đề của 1 loại báo nào đó
    @PutMapping("/news/{newsId}/categories/{categoriesId}")
    public Category updateCategory(@PathVariable("categoriesId") int categoriesId,@PathVariable("newsId") int newsId, @RequestBody Category category) {
        Category oldCategories = categoryRepository.findByNewsIdAndCategoriesId(newsId,categoriesId);
        category.setNewsId(oldCategories.getNewsId());
        category.setCategoriesId(oldCategories.getCategoriesId());
        
        return categoryRepository.save(category);
    }
 // Xóa 1 chủ đề nào đó trong 1 loại báo   
    @DeleteMapping("/categories/{categoriesId}")
    public ResponseEntity<?> deleteCategory(@PathVariable("categoriesId") int categoriesId ) {
        categoryRepository.deleteByCategoriesId(categoriesId);
   //     newsRepository.deleteByNewsId(id);
        
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
