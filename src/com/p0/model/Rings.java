package com.p0.model;

public class Rings extends Things {
	private String material;
	private String gem;
	private String jeweler;
	
public Rings() {
		super();
	}
	
public Rings(String material, String gem, String jeweler, String itemName, double price) {
	super(itemName, price);
	this.material = material;
	this.gem = gem;
	this.jeweler = jeweler;
		
	

}

public String getMaterial() {
	return material;
}

public void setMaterial(String material) {
	this.material = material;
}

public String getGem() {
	return gem;
}

public void setGem(String gem) {
	this.gem = gem;
}

public String getJeweler() {
	return jeweler;
}

public void setJeweler(String jeweler) {
	this.jeweler = jeweler;
}

@Override
public String toString() {
	return "Rings [material=" + material + ", gem=" + gem + ", jeweler=" + jeweler + ", itemName=" + itemName
			+ ", price=" + price + "]";
}


}


