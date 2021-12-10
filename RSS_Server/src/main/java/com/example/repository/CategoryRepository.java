/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.repository;

import com.example.models.Category;
import com.example.models.News;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Ngoc
 */
@Transactional
@Repository
public interface CategoryRepository extends JpaRepository<Category, Long>{

   List<Category> findByNewsId(final int newsID);

    public void deleteByNewsId(int id);



  

    public Category findByCategoriesIdAndNewsId(int categoriesId, int newsId);

   

    public Category findByNewsIdAndCategoriesId(int newsId, int categoriesId);

 //   public void deleteByNewsIdAndCategoriesId(int newsId, int categoriesId);

    public void deleteByCategoriesId(int categoriesId);

 

   
}
