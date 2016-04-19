package models;

import java.util.LinkedList;

public class MethodCall extends ExpressionSideEffects {
	
	private final static String EXPSETYPE = "MethodCall";
	
	private String methodName;
	private LinkedList<Expression> parameters;
	private Variable methodThis;
	
	public MethodCall(Variable methodThis, String methodName, LinkedList<Expression> parameters) {
		super(EXPSETYPE);
		// TODO Auto-generated constructor stub
		this.methodName = methodName;
		this.parameters = parameters;
		this.methodThis = methodThis;
	}
	
	public void setMethodName(String methodName)
	{
		this.methodName = methodName;
	}
	
	public void setParameters(LinkedList<Expression> parameters)
	{
		this.parameters = parameters;
	}
	
	public void setMethodThis(Variable methodThis)
	{
		this.methodThis = methodThis;
	}
	
	public String getMethodName()
	{
		return methodName;
	}
	
	public LinkedList<Expression> getParameters()
	{
		return parameters;
	}
	
	public Variable getMethodThis()
	{
		return methodThis;
	}
}
