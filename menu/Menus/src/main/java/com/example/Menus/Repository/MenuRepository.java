package com.example.Menus.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.Menus.Entity.MenuItem;

@Repository
public interface MenuRepository extends JpaRepository<MenuItem, Integer> {

    @Query("SELECT m FROM MenuItem m WHERE m.dishId = :dishId")
    List<MenuItem> findByDishId(@Param("dishId") Integer dishId);

    @Query("SELECT m FROM MenuItem m WHERE m.dishType = :dishType")
    List<MenuItem> findByDishType(@Param("dishType") String dishType);
}
