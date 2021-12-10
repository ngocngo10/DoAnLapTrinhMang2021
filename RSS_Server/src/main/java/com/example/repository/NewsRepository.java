/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.repository;

import com.example.models.News;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Ngoc
 */
@Transactional
@Repository
public interface NewsRepository extends JpaRepository<News, Long>{

    

    public News findByNewsId(int id);

  

    public void deleteByNewsId(int id);

    public News findByNewsTitle(String newsTitle);

}
