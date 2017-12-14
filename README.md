# PizzaShop
Pizza Shop is a development exercise implemented using micro services under Java and Jersey.

## Design
The design for this is the next image:
![picture](https://github.com/luis-mejillones/PizzaShop/blob/master/ThePizzaShop_Design.png)
  
The solution design have several classes, for simplicity purposes, there is only one service which is doing the all interacion with the exterior.

### OrderService class
This class has all services which return, as xml format, all information necessary to prepare a pizza order, por example, if the user want to know the size of available pizza just can use the URL: http://localhost:8080/PizzaShop/orderservice/size/
or if the user wants to add any new type of pizza, it can be done calling this URL: http://localhost:8080/PizzaShop/orderservice/addpizzatype/; format data to be used is JSON, here an example of this:

{
		"type": "Hawaiian",
		"name": "Hawaiian"
}

### PizzaFeature interface
This interface is being implemented for several classes like: PizzaType or ExtraIngredient classes. Those classes implements the functionality to manage the type os pizzas or all kind of ingredients used to make a pizza.

### Pizza class
This class manage all information and functionality related to a Pizza, information like: type of pizza, which can be more than one, sause, chees type even several extra ingredients. This class is added into PizzaOrder class which can have several pizzas and manage their state which can be: bake, cut, box or whatever state of order.

### PizzaFeatureDao class
This is encharge to persis information and estate of classes. For simplicity actually it is being stores into a text file.
