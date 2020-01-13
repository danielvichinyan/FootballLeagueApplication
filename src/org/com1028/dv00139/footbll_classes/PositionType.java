package org.com1028.dv00139.footbll_classes;

/** 
 * Defines the properties of a football position
 *  
 * @author Daniel Vichinyan 
 */ 
public enum PositionType {
	GK("Goalkeeper"), CB("Centre Back"), LB("Left Back"), RB("Right Back"), CM("Centre Midfielder"), LM("Left Midfielder"), RM("Right Midfielder"), CF("Centre Forward");
	
	private String positionName = null;
	
	 /** 
	   * Constructor. Sets the field values. 
	   *  
	   * @param positionName
	   */ 
	private PositionType(String positionName) {
		this.positionName = positionName;
	}
	
	public String getPositionName() {
		return this.positionName;
	}
}
