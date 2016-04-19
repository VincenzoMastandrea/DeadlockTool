package models;

import java.util.LinkedList;

public class NewObject extends ExpressionSideEffects{

	private final static String EXPSETYPE = "Object Creation";
	
	private boolean isActive;	
	private String className;
	private LinkedList<Expression> parameters;
	
	public NewObject(boolean isActive, String className, LinkedList<Expression> parameters) {
		super(EXPSETYPE);
		// TODO Auto-generated constructor stub
		this.isActive = isActive;
		this.className = className;
		this.parameters = parameters;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public LinkedList<Expression> getParameters() {
		return parameters;
	}

	public void setParameters(LinkedList<Expression> parameters) {
		this.parameters = parameters;
	}	
	

}
