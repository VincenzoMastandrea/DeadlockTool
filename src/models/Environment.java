package models;

import java.util.HashMap;
import java.util.LinkedList;

public class Environment {
	
	private HashMap<String, Type> environment;
	
	public Environment()
	{
		environment = new HashMap<>();
	}

	public void put(String s, Type t)
	{
		environment.put(s,t);
	}

	public void putAll(HashMap<String, Type> set)
	{
		environment.putAll(set);
	}

	public void putAllInt(LinkedList<Variable> list)
	{
		for(int i=0; i<list.size(); i++)
		{
			environment.put(list.get(i).getName(),list.get(i).getType());
		}
	}
	
	public Variable getVar(String key)
	{
		Variable var = new Variable(key);
		var.setType(environment.get(key));
		return var;
	}
	
	public void print()
	{
		System.out.println("**********");
		System.out.println("Start scope:");
		System.out.println(environment.size());
		
		for(String key : environment.keySet())
		{
			Variable var = getVar(key);
			System.out.println(var.getName() + " --> " + var.getType().getType());
		}
		System.out.println("End scope");
		System.out.println("**********");
	}

}
