package com.p0.model;

public class Rings {
	
	private String itemName;
	private String material;
	private String gem;
	private String jeweler;
	private String engraving;
	private String currentOwner;
	private String previousOwner;
	private double price;
	
	
	




	





	public Rings(String itemName, String material, String gem, String jeweler, String engraving, String currentOwner,
			String previousOwner, double price) {
		super();
		this.itemName = itemName;
		this.material = material;
		this.gem = gem;
		this.jeweler = jeweler;
		this.engraving = engraving;
		this.currentOwner = currentOwner;
		this.previousOwner = previousOwner;
		this.price = price;
	}





	public Rings() {
		
	}





	public String getItemName() {
		return itemName;
	}





	public void setItemName(String itemName) {
		this.itemName = itemName;
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





	public String getEngraving() {
		return engraving;
	}





	public void setEngraving(String engraving) {
		this.engraving = engraving;
	}





	public String getCurrentOwner() {
		return currentOwner;
	}





	public void setCurrentOwner(String currentOwner) {
		this.currentOwner = currentOwner;
	}





	public String getPreviousOwner() {
		return previousOwner;
	}





	public void setPreviousOwner(String previousOwner) {
		this.previousOwner = previousOwner;
	}





	public double getPrice() {
		return price;
	}





	public void setPrice(double price) {
		this.price = price;
	}

	public String toStringNoOwner() {
		return  "Name:" + itemName + "\n" + "Material:" +" " + material + "\n" + "Gem:" + " " +  gem + "\n" +"Jeweler:" + " " + jeweler
				+ "\n" + "Engraving:" + " " + engraving + "\n" +
				"Price:" + price;
	}
	@Override
	public String toString() {
		return "Rings [itemName=" + itemName + ", material=" + material + ", gem=" + gem + ", jeweler=" + jeweler
				+ ", engraving=" + engraving + ", currentOwner=" + currentOwner + ", previousOwner=" + previousOwner
				+ ", price=" + price + "]";
	}
}

