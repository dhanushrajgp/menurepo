package com.example.Menus.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import com.example.Menus.Entity.MenuItem;
import com.example.Menus.Exceptions.InvalidMenuItemException;
import com.example.Menus.Exceptions.MenuItemNotFoundException;
import com.example.Menus.Models.ErrorResponseDto;
import com.example.Menus.Service.MenuItemService;

import jakarta.validation.Valid;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class MenuItemController {

    @Autowired
    private MenuItemService menuItemService;

    @GetMapping("/health-check")
    public ResponseEntity<String> getServerHealth() {
        return ResponseEntity.status(HttpStatus.OK).body("Server running..");
    }

    @PostMapping("/check-post")
    public ResponseEntity<String> addPostCheck(@RequestBody String string) throws InvalidMenuItemException {
        
        return ResponseEntity.status(HttpStatus.CREATED).body(string);
    }
    
    
    @PostMapping("/dish")
    public ResponseEntity<?> addMenu(@Valid @RequestBody MenuItem menu) throws InvalidMenuItemException{
        MenuItem addedMenu = menuItemService.addMenuItem(menu);
        return ResponseEntity.status(HttpStatus.CREATED).body(addedMenu);
        
    }

    @GetMapping("/dishId/{dishId}")
    public ResponseEntity<List<MenuItem>> getMenuItemsByDishId(@PathVariable Integer dishId) throws MenuItemNotFoundException {
        List<MenuItem> items = menuItemService.getMenuItemsByDishId(dishId);
        return ResponseEntity.ok(items);
    }

    @GetMapping("/search/{dishType}")
    public ResponseEntity<?> getMenuItemsByDishType(@PathVariable String dishType) throws MenuItemNotFoundException {
        List<MenuItem> items = menuItemService.getMenuItemsByDishType(dishType);
        return ResponseEntity.ok(items);
    }
    
 
    
    
}

