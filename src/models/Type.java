package models;

/**
 * @author Vincenzo Mastandrea
 * Represents the types used in a program. 
 */

public abstract class Type {
	
	private String type;
	private boolean isFuture;
	
	public Type(String type)
	{
		this.type = type;
        this.isFuture = false;
	}
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public boolean isFuture() { return isFuture; }

	public void setFuture(boolean future) { isFuture = future; }
	
	public String toString()
	{
		return type;
	}
}
