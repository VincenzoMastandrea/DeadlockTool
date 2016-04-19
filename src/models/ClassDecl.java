package models;

import java.util.HashMap;
import java.util.LinkedList;

public class ClassDecl extends CompilationUnit {
	
	private String className;
	private HashMap<String,Declaration> fields;
	private HashMap<Integer,Declaration> parameters; 
	private HashMap<String, LinkedList<Method>> methods;
	
	public ClassDecl()
	{
		this.className = null;
		this.parameters = null;
		this.fields = null;
		this.methods = null;
	}
	
	public ClassDecl(String className, 
				 HashMap<Integer,Declaration> parameters, 
				 HashMap<String,Declaration> fields, 
			     HashMap<String, LinkedList<Method>> methods)
	{
		this.className = className;
		this.parameters = parameters;
		this.fields = fields;
		this.methods = methods;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}
	
	public LinkedList<Method> getMethodFromID (String methodName)
	{
		if (methods.containsKey(methodName))
			return methods.get(methodName);
		else
			return null;
	}
	
	public LinkedList<Method> getMethodList()
	{
		LinkedList<Method> list = new LinkedList<>();
		for(String key : this.methods.keySet())
		{
			list.addAll(this.methods.get(key));
		}
		return list;
	}
	
	public HashMap<String, LinkedList<Method>> getMethods()
	{
		return methods;
	}
	
	public void setMethods (HashMap<String, LinkedList<Method>> methods )
	{
		this.methods = methods;
	}
	
	public HashMap<String,Declaration> getFields()
	{
		return fields;
	}
	
	public HashMap<Integer,Declaration> getParameters()
	{
		return parameters;
	}
		
	public void setFields (HashMap<String,Declaration> fields )
	{
		this.fields = fields;
	}
	
	public void setParameters (HashMap<Integer,Declaration> parameters )
	{
		this.parameters = parameters;
	}
	

	
	public void print(){
		System.out.println("Class: " + className);
		System.out.println("I parametri sono: ");
		for (Integer key: parameters.keySet()){
			Declaration var = parameters.get(key);  
  	        System.out.println(var.getType().getType() + " -> " + var.getVar().getName());  
		}
		System.out.println("I campi sono: ");
		for (String key: fields.keySet()){
			Declaration var = fields.get(key);  
			System.out.println(var.getType().getType() + " -> " + var.getVar().getName());  
		}
		System.out.println("I metodi sono: ");
		for (String key: methods.keySet()){
			LinkedList<Method> met = methods.get(key);
			for(Method m : met)
				m.print();
		}
	}
	
}
