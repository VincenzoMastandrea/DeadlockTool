package models;

public class TypeInt extends Type {

	private final static String TYPE = "Int";
	
	public TypeInt() {
		super(TYPE);
		// TODO Auto-generated constructor stub
	}

	public boolean isInt(){ return true; }

	public boolean isObj(){ return false; }
	
}
