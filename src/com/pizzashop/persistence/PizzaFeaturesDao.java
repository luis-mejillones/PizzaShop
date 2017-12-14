package com.pizzashop.persistence;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import com.pizzashop.ExtraIngredient;
import com.pizzashop.PizzaFeature;
import com.pizzashop.PizzaType;

/**
 * In charge to persist the data. For simplicity purposes this Dao store the object into a text file. 
 */
public class PizzaFeaturesDao {
	public static final String PIZZA_FEATURES_FILE_NAME    = "PizzaFeatures.txt";
	public static final String EXTRA_INGREDIENTS_FILE_NAME = "ExtraIngredients.txt";
	
	Map<String, PizzaFeature> pizzaTypes;
	Map<String, PizzaFeature> extraIngredients;
	
	/**
	 * Default constructor
	 */
	public PizzaFeaturesDao() {
		pizzaTypes = new HashMap<String, PizzaFeature>();
		extraIngredients = new HashMap<String, PizzaFeature>();
		load();
	}
	/**
	 * 
	 * @param pizzaType
	 */
	public void addPizzaType(PizzaType pizzaType) {
		pizzaTypes.put(pizzaType.getType(), pizzaType);
	}

	/**
	 * 
	 * @return
	 */
	public Map<String, PizzaFeature> getPizzaTypes() {
		return pizzaTypes;
	}

	/**
	 * 
	 * @param pizzaTypes
	 */
	public void setPizzaTypes(Map<String, PizzaFeature> pizzaTypes) {
		this.pizzaTypes = pizzaTypes;
	}
	
	/**
	 * 
	 * @param extraIngredient
	 */
	public void addExtraIngredient(ExtraIngredient extraIngredient) {
		extraIngredients.put(extraIngredient.getType(), extraIngredient);
	}

	/**
	 * 
	 * @return
	 */
	public Map<String, PizzaFeature> getExtraIngredient() {
		return extraIngredients;
	}

	/**
	 * 
	 * @param extraIngredients
	 */
	public void setExtraIngredient(Map<String, PizzaFeature> extraIngredients) {
		this.extraIngredients = extraIngredients;
	}
	
	/**
	 * Save object into a text file
	 */
	public void persist() {
		persist(pizzaTypes, PIZZA_FEATURES_FILE_NAME);
		persist(extraIngredients, EXTRA_INGREDIENTS_FILE_NAME);
	}
	
	/**
	 * 
	 * @param map
	 * @param file
	 */
	public void persist(Map<String, PizzaFeature> map, String file) {
		try {
			FileOutputStream f = new FileOutputStream(new File(file));
			ObjectOutputStream o = new ObjectOutputStream(f);

			// Write objects to file
			Iterator<String> keySetIterator = map.keySet().iterator();

			while(keySetIterator.hasNext()){
			  String key = keySetIterator.next();
			  o.writeObject(map.get(key));
			}
			
			o.close();
			f.close();

		} catch (FileNotFoundException e) {
			System.out.println("File not found");
		} catch (IOException e) {
			System.out.println("Error initializing stream");
		}
	}
	
	/**
	 * Retrieve the objects previously saved
	 */
	private void load() {
		load(pizzaTypes, PIZZA_FEATURES_FILE_NAME);
		load(extraIngredients, EXTRA_INGREDIENTS_FILE_NAME);
	}
	
	/**
	 * 
	 * @param map
	 * @param file
	 */
	private void load(Map<String, PizzaFeature> map, String file) {
		try {
			FileInputStream fi = new FileInputStream(new File(file));
			ObjectInputStream oi = new ObjectInputStream(fi);

			// Read objects
			while (fi.available() > 0) {
				PizzaFeature pizzaFeature = (PizzaFeature)oi.readObject();
				if (pizzaFeature != null) {
					map.put(pizzaFeature.getType(), pizzaFeature);
				}
			}

			oi.close();
			fi.close();

		} catch (FileNotFoundException e) {
			System.out.println("File not found (load)");
		} catch (IOException e) {
			System.out.println("Error initializing stream (load)");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
