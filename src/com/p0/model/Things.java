package com.p0.model;

public abstract class Things {

protected String itemName;
protected double price;

public Things(){
	super();
}

public Things(String itemName, double price) {
	super();
	this.itemName = itemName;
	this.price = price;

	
}
public String getItemName() {
	return itemName;
}
public void setItemName(String itemName) {
	this.itemName = itemName;
}
public double getPrice() {
	return price;
}
public void setPrice(double price) {
	this.price = price;
}

@Override
public String toString() {
	return "Things [itemName=" + itemName + ", price=" + price + "]";
}

}
