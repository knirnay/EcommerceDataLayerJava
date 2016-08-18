/**
 * 
 */
package com.ecommerce.data;

import java.util.List;

/**
 * The product entity.
 * @author NK
 *
 */
public class Product {
	/**
	 * The product identifier.
	 */
	private int ProductId;
	
	
	/**
	 * The category identifier of the product.
	 */
	private int CategoryId;
	
	/**
	 * The name of the product.
	 */
	private String Name;

	/**
	 * The description about the product.
	 */
	private String Description;
	
	/**
	 * The product specifications.
	 */
	private List<Specification> Specs;
	
	/**
	 * The product categories.
	 */
	private List<ProductCategory> ProductCategories;
	
	/**
	 * Gets the product Identifier.
	 * @return The Product identifier.
	 */
	public int getProductId(){
		return this.ProductId;
	}
	
	/**
	 * Sets the product identifier.
	 * @param productId The product Identifier.
	 */
	public void setProductId(int productId){
		this.ProductId = productId;
	}
	
	/**
	 * Gets the category identifier.
	 * @return The category identifier.
	 */
	public int getCategoryId(){
		return this.CategoryId;
	}
	
	/**
	 * Sets the category identifier.
	 * @param categoryId The category identifier.
	 */
	public void setCategoryId(int categoryId){
		this.CategoryId = categoryId;
	}
	
	/**
	 * Get the description about the product.
	 * @return The description about the product.
	 */
	public String getDescription(){
		return this.Description;
	}
	
	/**
	 * Sets the description about the product.
	 * @param description The description about the product.
	 */
	public void setDescription(String description){
		this.Description = description;
	}
	
	/**
	 * Gets the specification of the product.
	 * @return The specifications of the product.
	 */
	public List<Specification> getSpecs(){
		return this.Specs;
	}
	
	/**
	 * Sets the specification of the product.
	 * @param specs The specification of the product.
	 */
	public void setSpecs(List<Specification> specs){
		this.Specs = specs;
	}
	
	/**
	 * Gets the product categories.
	 * @return The product categories.
	 */
	public List<ProductCategory> getProductCategories(){
		return this.ProductCategories;
	}
	
	/**
	 * Sets the product categories.
	 * @param productCategories The product categories.
	 */
	public void setProductCategories(List<ProductCategory> productCategories){
		this.ProductCategories = productCategories;
	}
	
	/**
	 * Gets the name.
	 * @return The name.
	 */
	public String getName() {
		return Name;
	}

	
	/**
	 * Sets the name.
	 * @param name The name.
	 */
	public void setName(String name) {
		Name = name;
	}
}
