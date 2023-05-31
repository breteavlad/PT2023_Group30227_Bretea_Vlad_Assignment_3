package model;

public class Product {
private String name;
private int price;
private int stock;

public Product(String name,int price,int stock) {
	this.name=name;
	this.stock=stock;
	this.price=price;
}

public String getProductName() {
	return name;
}
public int getStockProduct() {
	return stock;
}
public void setStockProduct(int stockProduct) {
	this.stock = stockProduct;
}
public int getStockPrice() {
	return price;
}
public void setStockPrice(int stockPrice) {
	this.price = stockPrice;
}

public String toString() {
	return "The product with name: " +this.name + " has the price : " +this.price + " and the stock: " + this.stock;
}

}
