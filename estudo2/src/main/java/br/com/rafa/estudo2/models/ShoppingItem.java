package br.com.rafa.estudo2.models;


import java.io.Serializable;
import java.math.BigDecimal;

public class ShoppingItem implements Serializable {

	private Product product;
	private String category;
	private Long productId;
	
	public ShoppingItem(Product product) {
		this.product = product;
		this.category = product.getCategory().getName();
	}
	
	public Product getProduct() {
		return product;
	}
	
	public  String getCategory() {
		return category;
	}
	
	public BigDecimal getPrice() {
		return product.getPrice();
	}
	
	public BigDecimal getTotal(Integer quantity) {
		return getPrice().multiply(new BigDecimal(quantity));
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((category == null) ? 0 : category.hashCode());
		result = prime * result
				+ ((productId == null) ? 0 : productId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ShoppingItem other = (ShoppingItem) obj;
		if (!category.equals(other.category))
			return false;
		if (productId == null) {
			if (other.productId != null)
				return false;
		} else if (!productId.equals(other.productId))
			return false;
		return true;
	}

}

