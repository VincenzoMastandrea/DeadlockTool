package models;

public class Declaration {
	
	private TypeBase type;
	private Variable var;
	
	public Declaration(TypeBase type, Variable var)
	{
		this.type = type;
		this.var = var;
	}
	
	public TypeBase getType() {
		return type;
	}

	public void setType(TypeBase type) {
		this.type = type;
	}

	public Variable getVar() {
		return var;
	}

	public void setVar(Variable var) {
		this.var = var;
	}
	
	public String toString()
	{
		return type.getType() + " " + var.getName();
	}
}
