package models;

import java.util.HashMap;

public class Environment {
	
	private HashMap<String,Declaration> environment;
	
	public Environment()
	{
		environment = new HashMap<>();
	}
	
	public void putAll(HashMap<String,Declaration> set)
	{
		environment.putAll(set);
	}
	
	public void putAllInt(HashMap<Integer,Declaration> set)
	{
		for(Integer key : set.keySet())
		{
			environment.put(set.get(key).getVar().getName(),set.get(key));
		}
	}
	
	public Variable getVar(String key)
	{
		return environment.get(key).getVar();
	}
	
	public void print()
	{
		System.out.println("**********");
		System.out.println("Start scope:");
		System.out.println(environment.size());
		
		for(String key : environment.keySet())
		{
			Variable var = environment.get(key).getVar();
			System.out.println(var.getName() + " --> " + var.getType().getType());
		}
		System.out.println("End scope");
		System.out.println("**********");
	}

}
