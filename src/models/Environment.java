package models;

import java.util.HashMap;

public class Environment {
	
	private HashMap<String,TypeBase> environment;
	
	public Environment()
	{
		environment = new HashMap<>();
	}
	
	public void putAll(HashMap<String,TypeBase> set)
	{
		environment.putAll(set);
	}

	public void putAllIn(HashMap<Integer,TypeBase> set)
	{
		for(Integer key : set.keySet())
		{
			environment.put(set.get(key).getVar().getName(),set.get(key));
		}
	}
	
	public Variable getVar(String key)
	{
		Variable var = new Variable(key);
		var.setType(environment.get(key));
		return var ;
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
