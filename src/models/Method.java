package models;

import java.util.HashMap;
import java.util.LinkedList;

public class Method extends CompilationUnit{
	
	private TypeBase returnedType;
	private String methodName;
	private LinkedList<Declaration> parameters;
	private StmtBlock body;
	private String id;
	
	public Method()
	{
		this.returnedType = null;
		this.methodName   = null;
		this.parameters   = null;
		this.body		  = null;
	}
		
	public Method(TypeBase returnedType, String methodName, LinkedList<Declaration> parameters, StmtBlock body)
	{
		this.returnedType = returnedType;
		this.methodName   = methodName;
		this.parameters   = parameters;
		this.body 		  = body;
	}

	public TypeBase getReturnedType() {
		return returnedType;
	}

	public void setReturnedType(TypeBase returnedType) {
		this.returnedType = returnedType;
	}
	
	public String getMethodName() {
		return methodName;
	}

	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}
	
	public LinkedList<Declaration> getParameters()
	{
		return parameters;
	}
	
	public StmtBlock getBody()
	{
		return body;
	}
	
	public void setParameters(LinkedList<Declaration> parameters)
	{
		this.parameters = parameters;
	}
	
	public void setBody(StmtBlock body)
	{
		this.body = body;
	}
	
	public String getID() {
		return id;
	}

	public void setID(int pos) {
			this.id = methodName + "_" + pos;
	}
	
	public boolean isEqual(Method m)
	{
		if (this.countPar() == m.countPar())
		{
			for (int i=0; i<parameters.size();i++)
			{
				Declaration var = parameters.get(i);
				if (!(var.getType().getType().equals(m.getParameters().get(i).getType().getType())))
					return false;
			}
		}
		else return false;
	    return true;
	}
	
	public boolean isIn(LinkedList<Method> list)
	{
		boolean in = false;
		int size = list.size();
		int pos = 0;
		while ((!in) && (pos<size))
		{
			in = list.get(pos).isEqual(this);
			pos++;
		}
		return in;
	}
	
	
	public int countPar()
	{
		return parameters.size();
	}
	
	public void print() {
		System.out.println("\n Metodo "+ methodName + " " + "id " + id +":");
		System.out.println("tipo di ritorno: " + returnedType.toString());
		System.out.println("I parametri sono: ");
		for (int i=0; i<parameters.size();i++){
			Declaration var = parameters.get(i);
			System.out.println(var.getType().getType() + " -> " + var.getVar().getName());  
		}
		System.out.println("Il corpo é: ");
		body.print();		
	}
	
}
