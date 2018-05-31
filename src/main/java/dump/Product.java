package dump;

public class Product {
	private int productId;
	private String proName;
	private double price;
	public Product() {}
	public Product(int id,String name,double price) {
		this.productId=id;
		this.proName=name;
		this.price=price;
	}
	public Product(String name,double price) {
		
		this.proName=name;
		this.price=price;
	}
	

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProName() {
		return proName;
	}

	public void setProName(String proName) {
		this.proName = proName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
}
