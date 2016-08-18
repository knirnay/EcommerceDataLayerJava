/**
 * 
 */
package com.ecommerce.data;

/**
 * The product category entity.
 * @author NK
 *
 */
public class ProductCategory {
	/*
	 * The category identifier of the product.
	 */
	private int CategoryId;
	
	/*
	 * The name of the product.
	 */
	private String Name;
	
	/*
	 * The parent category identifier of the product.
	 */
	private Integer ParentCategoryId;
	

	/**
	 * true if the category has child category otherwise false.
	 */
	private boolean HasChild;
	
	/**
	 * Gets category identifier.
	 * @return category identifier.
	 */
	public int getCategoryId(){
		return this.CategoryId;
	}
	
	/**
	 * Sets category identifier.
	 * @param categoryId category identifier.
	 */
	public void setCategoryId(int categoryId){
		this.CategoryId = categoryId;
	}
	
	/**
	 * Gets the name of the category.
	 * @return the name of the category.
	 */
	public String getName(){
		return this.Name;
	}
	
	/**
	 * Sets the name of the category.
	 * @param name the namd of the category.
	 */
	public void setName(String name){
		this.Name = name;
	}
	
	/**
	 * Gets the parent category identifier. 
	 * @return Parent category identifier.
	 */
	public Integer getParentCategoryId(){
		return this.ParentCategoryId;
	}
	
	/**
	 * Sets the parent category identifier.
	 * @param parentCategoryId Parent category identifier.
	 */
	public void setParentCategoryId(Integer parentCategoryId){
		this.ParentCategoryId = parentCategoryId;
	}
	
	/**
	 * Gets HasChild.
	 * @return has child.
	 */
	public boolean getHasChild(){
		return this.HasChild;
	}
	
	/**
	 * Sets HasChild.
	 * @param hasChild
	 */
	public void setHasChild(boolean hasChild){
		this.HasChild = hasChild;
	}
}
