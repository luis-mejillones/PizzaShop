package com.pizzashop;

/**
 * Define behavior for Pizza feature implementation.
 */
public interface PizzaFeature {
	/**
	 * Returns the type of pizza feature like "Topping"
	 * 
	 * @return String
	 */
	public abstract String getType();

	/**
	 * Sets the type of pizza feature like "Topping"
	 * 
	 * @param type
	 */
	public abstract void setType(String type);

	/**
	 * Returns the name of pizza feature like "Bacon"
	 * 
	 * @return String
	 */
	public abstract String getName();

	/**
	 * Sets the type of pizza feature like "Topping"
	 * 
	 * @param name
	 */
	public abstract void setName(String name);
}
