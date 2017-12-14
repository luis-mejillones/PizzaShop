package com.pizzashop;

import java.util.Iterator;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.json.JSONArray;
import org.json.JSONObject;

import com.pizzashop.enums.CheeseType;
import com.pizzashop.enums.CrustType;
import com.pizzashop.enums.SauceType;
import com.pizzashop.enums.SizePizza;
import com.pizzashop.persistence.PizzaFeaturesDao;
import com.sun.jersey.spi.inject.Inject;

/**
 * Rest service to display all information related to "Pizza Shop" like pizza types, chhese types, sizes, etc
 * and add any pizza order. Also this service is able to add new types of pizza and new type of ingredients
 */
@Path("/orderservice")
public class OrderService {
	public static final int HTTP_STATUS_CREATED = 201;
	
	/**
	 * PizzaFeaturesDao class is used to persist some pizza features like pizza types, ingredients, etc
	 */
	@Inject
	private PizzaFeaturesDao pizzaFeatures;
	
	/**
	 * Service to return available cheese types.
	 * URL to reach: http://localhost:8080/PizzaShop/orderservice/cheestypes/
	 *  
	 * @return xml data
	 */
	@Path("/cheestypes")
	@GET
	@Produces("application/xml")
	public String getCheeseTypes() {
		StringBuilder stringBuilder = new StringBuilder();
		
		for (CheeseType type : CheeseType.values()) {
			stringBuilder.append("<cheesetype>" + type + "</cheesetype>");	
		}

		return "<cheestypes>" + stringBuilder.toString() + "</cheestypes>";
	}

	/**
	 * Service to return available sauces.
	 * URL to reach: http://localhost:8080/PizzaShop/orderservice/saucetypes/
	 *  
	 * @return xml data
	 */
	@Path("/saucetypes")
	@GET
	@Produces("application/xml")
	public String getSauceTypes() {
		StringBuilder stringBuilder = new StringBuilder();
		
		for (SauceType type : SauceType.values()) {
			stringBuilder.append("<saucetype>" + type + "</saucetype>");	
		}

		return "<saucetypes>" + stringBuilder.toString() + "</saucetypes>";
	}

	/**
	 * Service to return available crust types.
	 * URL to reach: http://localhost:8080/PizzaShop/orderservice/crusttypes/
	 *  
	 * @return xml data
	 */
	@Path("/crusttypes")
	@GET
	@Produces("application/xml")
	public String getCrustTypes() {
		StringBuilder stringBuilder = new StringBuilder();
		
		for (CrustType type : CrustType.values()) {
			stringBuilder.append("<crusttype>" + type + "</crusttype>");	
		}

		return "<crusttypes>" + stringBuilder.toString() + "</crusttypes>";
	}

	/**
	 * Service to return available pizza sizes.
	 * URL to reach: http://localhost:8080/PizzaShop/orderservice/size/
	 *  
	 * @return xml data
	 */
	@Path("/size")
	@GET
	@Produces("application/xml")
	public String getSizesPizza() {
		StringBuilder stringBuilder = new StringBuilder();
		
		for (SizePizza size : SizePizza.values()) {
			stringBuilder.append("<sizepizza>" + size + "</sizepizza>");	
		}

		return "<sizespizza>" + stringBuilder.toString() + "</sizespizza>";
	}

	/**
	 * Service to add any pizza type. Incoming data should be json format.
	 * Example of data:
	 * {
	 *		"type": "Hawaiian",
	 *		"name": "Hawaiian"
	 * }
	 * 
	 * URL to reach: http://localhost:8080/PizzaShop/orderservice/addpizzatype/
	 *  
	 * @return xml data
	 */
	@POST
	@Path("/addpizzatype")
	@Consumes("application/json")
	public Response addPizzaType(String jsonRequest) {
		JSONObject requestedJSON = new JSONObject(jsonRequest);
		PizzaType pizzaType = new PizzaType();
		pizzaType.setType(requestedJSON.getString("type"));
		pizzaType.setName(requestedJSON.getString("name"));
		pizzaFeatures.addPizzaType(pizzaType);
		pizzaFeatures.persist();
		String result = "Pizza type saved : " + pizzaType;
		
		return Response.status(HTTP_STATUS_CREATED).entity(result).build();
	}
	
	/**
	 * Service to return available pizza types.
	 * URL to reach: http://localhost:8080/PizzaShop/orderservice/pizzatypes/
	 *  
	 * @return xml data
	 */
	@Path("/pizzatypes")
	@GET
	@Produces("application/xml")
	public String getPizzaTypes() {
		StringBuilder stringBuilder = new StringBuilder();
		Map<String, PizzaFeature> pizzaTypes = pizzaFeatures.getPizzaTypes();
		Iterator<String> keySetIterator = pizzaTypes.keySet().iterator();

		while(keySetIterator.hasNext()){
		  String key = keySetIterator.next();
		  stringBuilder.append("<pizza-type>" + pizzaTypes.get(key) + "</pizza-type>");
		}

		return "<pizza-types>" + stringBuilder.toString() + "</pizza-types>";
	}
	
	/**
	 * Service to add any pizza ingredient. Incoming data should be json format.
	 * Example of data:
	 * {
	 *		"type": "Topping",
	 *		"name": "Bacon"
	 * }
	 * 
	 * URL to reach: http://localhost:8080/PizzaShop/orderservice/addpizzatype/
	 *  
	 * @return xml data
	 */
	@POST
	@Path("/addingredient")
	@Consumes("application/json")
	public Response addIngredient(String jsonRequest) {
		JSONObject requestedJSON = new JSONObject(jsonRequest);
		ExtraIngredient extraIngredient = new ExtraIngredient();
		extraIngredient.setType(requestedJSON.getString("type"));
		extraIngredient.setName(requestedJSON.getString("name"));
		pizzaFeatures.addExtraIngredient(extraIngredient);
		pizzaFeatures.persist();
		String result = "Extra ingredient saved : " + extraIngredient;
		
		return Response.status(HTTP_STATUS_CREATED).entity(result).build();
	}

	/**
	 * Service to return available extra ingredients.
	 * URL to reach: http://localhost:8080/PizzaShop/orderservice/ingredients/
	 *  
	 * @return xml data
	 */
	@Path("/ingredients")
	@GET
	@Produces("application/xml")
	public String getExtraIngredients() {
		StringBuilder stringBuilder = new StringBuilder();
		Map<String, PizzaFeature> extraIngredients = pizzaFeatures.getExtraIngredient();
		Iterator<String> keySetIterator = extraIngredients.keySet().iterator();

		while(keySetIterator.hasNext()){
		  String key = keySetIterator.next();
		  stringBuilder.append("<extra-ingredient>" + extraIngredients.get(key) + "</extra-ingredient>");
		}

		return "<extra-ingredients>" + stringBuilder.toString() + "</extra-ingredients>";
	}
	
	/**
	 * Service to add any order. Incoming data should be json format.
	 * Example of data:
	 * {
	 *		"pizzatype": [{"type":"Brazilian,", "name": "Brazilian,"}],
	 *		"cheesetype":["MOZZARELLA"],
	 *		"saucetype":["PESTO"],
	 *		"crusttype": "THICK",
	 *		"extraingredient":[{"type":"Toppings", "name": "Bacon"}], 
	 *		"size": {"size":"LARGE", "slices": 5}
	 * }
	 * 
	 * URL to reach: http://localhost:8080/PizzaShop/orderservice/addorder/
	 *  
	 * @return xml data
	 */
	@POST
	@Path("/addorder")
	@Consumes("application/json")
	public Response addOrder(String jsonRequest) {
		Pizza pizza = new Pizza();
		JSONObject requestedJSON = new JSONObject(jsonRequest);

		/**
		 * Retrieve pizza type
		 */
		JSONArray pizzaTypes = requestedJSON.getJSONArray("pizzatype");

        for(int i = 0; i < pizzaTypes.length(); i++) {
            JSONObject jsonObject = pizzaTypes.getJSONObject(i);
            String type = jsonObject.getString("type");
            String name = jsonObject.getString("name");
            PizzaType pizzaType = new PizzaType(type, name);
            pizza.addPizzaType(pizzaType);
        }

        /**
         * Retrieve selected cheese
         */
		JSONArray cheeseTypes = requestedJSON.getJSONArray("cheesetype");

        for(int i = 0; i < cheeseTypes.length(); i++) {
        	CheeseType cheeseType = CheeseType.valueOf(cheeseTypes.getString(i));
            pizza.addCheeseType(cheeseType);
        }
        
        /**
         * Retrieve selected sauce
         */
		JSONArray sauceTypes = requestedJSON.getJSONArray("saucetype");

        for(int i = 0; i < sauceTypes.length(); i++) {
        	SauceType sauceType = SauceType.valueOf(sauceTypes.getString(i));
            pizza.addSauceType(sauceType);
        }
        
        /**
         * Retrieve crust type
         */
        CrustType crustType = CrustType.valueOf(requestedJSON.getString("crusttype"));
        pizza.setCrustType(crustType);
        
        /**
         * Retrieve some extra ingredients
         */
        JSONArray extraIngredients = requestedJSON.getJSONArray("extraingredient");

        for(int i = 0; i < extraIngredients.length(); i++) {
            JSONObject jsonObject = extraIngredients.getJSONObject(i);
            String type = jsonObject.getString("type");
            String name = jsonObject.getString("name");
            ExtraIngredient extraIngredient = new ExtraIngredient(type, name);
            pizza.addExtraIngredient(extraIngredient);
        }
        
        /**
         * Retrieve pizza size and optionally can send number of slices if default is not useful
         */
        JSONObject jsonObject = requestedJSON.getJSONObject("size");
        String size = jsonObject.getString("size");
        int slices = jsonObject.getInt("slices");
        Size sizePizza = new Size(SizePizza.valueOf(size), size, slices);
        pizza.setSize(sizePizza);
        
        /**
         * Save order on PizzaOrder class
         */
        PizzaOrder pizzaOrder = new PizzaOrder();
        pizzaOrder.addPizza(pizza);
        
		String result = "Pizza Order saved : " + pizza;
		
		return Response.status(HTTP_STATUS_CREATED).entity(result).build();
	}
}
