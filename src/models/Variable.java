package models;

/**
 * @author Vincenzo Mastandrea
 * Base class for variables . i.e. (x, y, n)
 */
public class Variable extends Element {
	
	private String name;
	private TypeBase type;
	
	public Variable(String name, TypeBase type) {
		this.type = type;
		this.name = name;
	}
	
	public Variable(String name) {
		this.type = null;
		this.name = name;
	}
	
	public String getName(){
		return name;
	}
	
	public TypeBase getType() {
		return type;
	}

	public void setType(TypeBase type) {
		this.type = type;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String toString() {
		return name;
	}
	
}
