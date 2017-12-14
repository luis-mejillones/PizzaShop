package com.pizzashop;

import java.util.ArrayList;
import java.util.List;

import com.pizzashop.enums.OrderState;

/**
 * In charde to manage the pizza orders.
 */
public class PizzaOrder {
	/**
	 * Store the list of pizzas for a order
	 */
	List<Pizza> pizzas;
	
	/**
	 * Store the state of order
	 */
	OrderState state;
	
	/**
	 * Default constructor
	 */
	public PizzaOrder() {
		pizzas = new ArrayList<>();
	}
	
	/**
	 * Adds a pizza on internal list
	 * 
	 * @param pizza
	 */
	public void addPizza(Pizza pizza) {
		pizzas.add(pizza);
	}
	
	/**
	 * @return the pizza list
	 */
	public List<Pizza> getPizza() {
		return pizzas;
	}
	
	/**
	 * @param pizza the pizza to set
	 */
	public void setPizza(List<Pizza> pizzas) {
		this.pizzas = pizzas;
	}
	
	/**
	 * @return the state
	 */
	public OrderState getState() {
		return state;
	}
	
	/**
	 * @param state the state to set
	 */
	public void setState(OrderState state) {
		this.state = state;
	}
}
