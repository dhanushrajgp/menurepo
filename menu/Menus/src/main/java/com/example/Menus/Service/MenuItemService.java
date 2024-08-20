package com.example.Menus.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Menus.Entity.MenuItem;
import com.example.Menus.Exceptions.InvalidMenuItemException;
import com.example.Menus.Exceptions.MenuItemNotFoundException;
import com.example.Menus.Repository.MenuRepository;

import jakarta.validation.Valid;
import jakarta.validation.ValidationException;

import java.util.List;

@Service
public class MenuItemService {

    @Autowired
    private MenuRepository menuItemRepository;

 
    public MenuItem addMenuItem(@Valid MenuItem menuItem) throws InvalidMenuItemException {
        try {
            return menuItemRepository.save(menuItem);
        } catch (Exception ex) {
            throw new InvalidMenuItemException("Invalid Menu Item: " + ex.getMessage());
        }
    }



    public List<MenuItem> getMenuItemsByDishId(Integer dishId) throws MenuItemNotFoundException {
        List<MenuItem> menuItems = menuItemRepository.findByDishId(dishId);
        if (menuItems.isEmpty()) {
            throw new MenuItemNotFoundException("No MenuItems found for dishId: " + dishId);
        }
        return menuItems;
    }

   
    public List<MenuItem> getMenuItemsByDishType(String dishType) throws MenuItemNotFoundException {
        List<MenuItem> menuItems = menuItemRepository.findByDishType(dishType);
        if (menuItems.isEmpty()) {
            throw new MenuItemNotFoundException("No MenuItems found for dishType: " + dishType);
        }
        return menuItems;
    }

}
