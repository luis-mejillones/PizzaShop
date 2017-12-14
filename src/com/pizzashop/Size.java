package com.pizzashop;

import com.pizzashop.enums.SizePizza;

/**
 * In charge to manage the available sizes of pizza
 */
public class Size implements PizzaFeature {
	/**
	 * Default number of slices regarding size
	 */
	public static final int TWO_SLICES   = 2;
	public static final int FOUR_SLICES  = 4;
	public static final int SIX_SLICES   = 6;
	public static final int EIGHT_SLICES = 8;
	
	/**
	 * Size of pizza define on SizePizza enum
	 */
	SizePizza type;
	
	/**
	 * Name of size
	 */
	String name;
	
	/**
	 * In charge to store the customized number of slices 
	 */
	int numberSlices;
	
	/**
	 * Overload constructor
	 * 
	 * @param type
	 * @param name
	 * @param numberSlices
	 */
	public Size(SizePizza type, String name, int numberSlices) {
		setType(type.name());
		this.name = name;

		// Only when this parameter has a positive value will be replaces on default slice number
		if (numberSlices > 0) {
			this.numberSlices = numberSlices;
		}
	}

	/**
	 * Return type
	 */
	@Override
	public String getType() {
		return type.name();
	}

	/**
	 * Sets the type of size defined on SizePizza enum and sets the default number of slices
	 */
	@Override
	public void setType(String type) {
		this.type = SizePizza.valueOf(type);
		switch (this.type) {
			case PERSONAL:
				setNumberSlices(TWO_SLICES);
				break;
			case SMALL:
				setNumberSlices(FOUR_SLICES);
				break;
			case MEDIUM:
				setNumberSlices(SIX_SLICES);
				break;
			case LARGE:
				setNumberSlices(EIGHT_SLICES);
				break;
		}
	}

	/**
	 * Return the name of size
	 */
	@Override
	public String getName() {
		return name;
	}

	/**
	 * Sets name
	 */
	@Override
	public void setName(String name) {
		this.name = name;		
	}

	/**
	 * Return the number of slices
	 * @return
	 */
	public int getNumberSlices() {
		return numberSlices;
	}

	/**
	 * Sets the number of slices
	 * @param numberSlices
	 */
	public void setNumberSlices(int numberSlices) {
		this.numberSlices = numberSlices;
	}
}
