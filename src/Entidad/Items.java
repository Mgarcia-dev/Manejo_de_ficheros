package Entidad;

import java.io.Serializable;

public class Items implements Serializable{

 static final long serialVersionUID = 7727381759754447938L;
	
	private int id;
	private String name;
	private String description;
	private int stock;
	private double price;
	
	// Constructor
	public Items(int id, String name, String description, int stock, double price) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.stock = stock;
		this.price = price;
	}
	
	public Items() {
		
	}
	
	// Getters y setters
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}

	//ToString
	@Override
	public String toString() {
		return "Items [id=" + id + ", name=" + name + ", description=" + description + ", stock=" + stock + ", price="
				+ price + "]";
	}
	
	
	
}
