package models;

/**
 * @author Vincenzo Mastandrea
 * Represents the type of an Object as well as its fields.
 */
public class TypeObject extends Type implements IActualValue {
	
	public TypeObject (String objClass){
		super(objClass);
	}

	public boolean isInt(){ return false; }

	public boolean isObj(){ return true; }

}
