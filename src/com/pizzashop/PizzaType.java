package com.pizzashop;

import java.io.Serializable;

/**
 * In charge to manage the available types of pizza offered on The Pizza Shop
 */
public class PizzaType implements Serializable, PizzaFeature {
	private static final long serialVersionUID = 1L;
	String type;
	String name;
	
	/**
	 * Default constructor
	 */
	public PizzaType() {
		super();
	}
	
	/**
	 * Overload constructor
	 * 
	 * @param type Is the type of pizza like "Brazilian"
	 * @param name Is the name of that type like "Brazilian flavor"
	 */
	public PizzaType(String type, String name) {
		super();
		this.type = type;
		this.name = name;
	}
	
	/**
	 * @return String
	 */
	public String getType() {
		return type;
	}
	
	/**
	 * @param type
	 */
	public void setType(String type) {
		this.type = type;
	}
	
	/**
	 * @return String
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		return "PizzaType [type=" + type + ", name=" + name + "]";
	}
}
