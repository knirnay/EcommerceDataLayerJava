/**
 * 
 */
package com.ecommerce.data;

/**
 * The specification entity.
 * @author NK
 *
 */
public class Specification {	
	/**
	 * The name of the specification.
	 */
	private String Name;
	
	/**
	 * The value of the specification.
	 */
	private String SpecValue;
	
	/**
	 * Gets the Name of the specification.
	 * @return The name.
	 */
	public String getName() {
		return this.Name;
	}

	/**
	 * Sets the name of the specification.
	 * @param name The name.
	 */
	public void setName(String name) {
		this.Name = name;
	}

	/**
	 * Gets the value of the specification.
	 * @return The specification value.
	 */
	public String getSpecValue(){
		return this.SpecValue;
	}
	
	
	/**
	 * Sets the value of the specification.
	 * @param specValue The specification value.
	 */
	public void setSpecValue(String specValue){
		this.SpecValue = specValue;
	}
}
