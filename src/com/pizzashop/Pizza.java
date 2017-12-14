package com.pizzashop;

import java.util.ArrayList;
import java.util.List;

import com.pizzashop.enums.CheeseType;
import com.pizzashop.enums.CrustType;
import com.pizzashop.enums.SauceType;
import com.pizzashop.enums.SizePizza;

/**
 * In charge to manage a pizza with their ingredients and features. 
 */
public class Pizza {
	List<PizzaType> pizzaTypes;
	List<CheeseType> cheeseTypes;
	List<SauceType> sauceTypes;
	CrustType crustType;
	List<ExtraIngredient> extraIngredients; 
	Size size;
	
	/**
	 * Default constructor
	 */
	public Pizza() {
		pizzaTypes = new ArrayList<>();
		cheeseTypes = new ArrayList<>();
		sauceTypes = new ArrayList<>();
		extraIngredients = new ArrayList<>();
	}
	
	/**
	 * Adds a pizza type on a list
	 * 
	 * @param pizzaType
	 */
	public void addPizzaType(PizzaType pizzaType) {
		pizzaTypes.add(pizzaType);
	}
	
	/**
	 * @return List<PizzaType> Which is the list of pizza types for a order
	 */
	public List<PizzaType> getPizzaType() {
		return pizzaTypes;
	}

	/**
	 * @param pizzaType
	 */
	public void setPizzaType(List<PizzaType> pizzaType) {
		this.pizzaTypes = pizzaType;
	}

	/**
	 * Adds a cheese type for a pizza
	 * 
	 * @param cheeseType
	 */
	public void addCheeseType(CheeseType cheeseType) {
		this.cheeseTypes.add(cheeseType);
	}
	
	/**
	 * @return List<CheeseType> Which is the cheese selected for a pizza
	 */
	public List<CheeseType> getCheeseType() {
		return cheeseTypes;
	}

	/**
	 * @param cheeseType
	 */
	public void setCheeseType(List<CheeseType> cheeseType) {
		this.cheeseTypes = cheeseType;
	}

	/**
	 * Adds a sauce for a pizza
	 * 
	 * @param sauceType
	 */
	public void addSauceType(SauceType sauceType) {
		sauceTypes.add(sauceType);
	}
	
	/**
	 * @return List<SauceType> Which is the selected sauces for a pizza
	 */
	public List<SauceType> getSauceType() {
		return sauceTypes;
	}
	
	/**
	 * @param sauceType
	 */
	public void setSauceType(List<SauceType> sauceType) {
		this.sauceTypes = sauceType;
	}
	
	/**
	 * A pizza can have just one crust type
	 * 
	 * @return CrustType
	 */
	public CrustType getCrustType() {
		return crustType;
	}
	
	/**
	 * @param crustType
	 */
	public void setCrustType(CrustType crustType) {
		this.crustType = crustType;
	}

	/**
	 * Adds an extra ingredient for a pizza
	 * 
	 * @param extraIngredient
	 */
	public void addExtraIngredient(ExtraIngredient extraIngredient) {
		extraIngredients.add(extraIngredient);
	}
	
	/**
	 * @return
	 */
	public List<ExtraIngredient> getExtraIngredient() {
		return extraIngredients;
	}

	/**
	 * @param extraIngredient
	 */
	public void setExtraIngredient(List<ExtraIngredient> extraIngredient) {
		this.extraIngredients = extraIngredient;
	}
	
	/**
	 * @return
	 */
	public Size getSize() {
		return size;
	}

	/**
	 * @param size
	 */
	public void setSize(Size size) {
		this.size = size;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		return "Pizza [pizzaTypes=" + pizzaTypes + ", cheeseTypes="
				+ cheeseTypes + ", sauceTypes=" + sauceTypes + ", crustType="
				+ crustType + ", extraIngredients=" + extraIngredients
				+ ", size=" + size + "]";
	}
}
