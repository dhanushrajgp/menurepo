package com.example.Menus.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

@Entity
@Table(name="Menus")
public class MenuItem {

    public MenuItem(@NotNull(message = "Category must be given") String dishType,
			@NotNull(message = "Name must be given") String dishName,
			@NotNull @Positive(message = "Unit price must be a positive integer") Integer unitPrice, String dishDesc) {
		super();
		this.dishType = dishType;
		this.dishName = dishName;
		this.unitPrice = unitPrice;
		this.dishDesc = dishDesc;
	}

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="dishId")
    private Integer dishId;

    @NotNull(message = "Category must be given")
    @Column(name="dishType")
    private String dishType;

    @NotNull(message = "Name must be given")
    @Column(name="dishName")
    private String dishName;

    @NotNull
    @Positive(message = "Unit price must be a positive integer")
    @Column(name="unitPrice")
    private Integer unitPrice;

    @Column(name="dishDesc")
    private String dishDesc;

	public Integer getDishId() {
		return dishId;
	}

	public void setDishId(Integer dishId) {
		this.dishId = dishId;
	}

	public String getDishType() {
		return dishType;
	}

	public void setDishType(String dishType) {
		this.dishType = dishType;
	}

	public String getDishName() {
		return dishName;
	}

	public MenuItem() {
		super();
	}

	public void setDishName(String dishName) {
		this.dishName = dishName;
	}

	public Integer getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(Integer unitPrice) {
		this.unitPrice = unitPrice;
	}

	public String getDishDesc() {
		return dishDesc;
	}

	public void setDishDesc(String dishDesc) {
		this.dishDesc = dishDesc;
	}

    // Getters and Setters
}

