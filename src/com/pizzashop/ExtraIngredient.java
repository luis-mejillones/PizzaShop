package com.pizzashop;

import java.io.Serializable;

/**
 * In charge to manage extra ingredients added on pizzas
 */
public class ExtraIngredient implements Serializable, PizzaFeature {
	private static final long serialVersionUID = 1L;
	
	/**
	 * Type of ingredient like "Topping"
	 */
	String type;
	
	/**
	 * Ingredient name like "Bacon"
	 */
	String name;
	
	/**
	 * Default constructor
	 */
	public ExtraIngredient() {
		super();
	}

	/**
	 * Overloaded constructor
	 * 
	 * @param type Is the type of extra ingredient.
	 * @param name Is the name of ingredient
	 */
	public ExtraIngredient(String type, String name) {
		this.type = type;
		this.name = name;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getType() {
		return type;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setType(String type) {
		this.type = type;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getName() {
		return name;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		return "Extra ingredient [type=" + type + ", name=" + name + "]";
	}
}
