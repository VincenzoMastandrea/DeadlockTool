/**
 * 
 */
package models;

import java.util.HashMap;

/**
 * @author Vincenzo Mastandrea
 * Base class for an ASP program
 */
public class Program extends CompilationUnit {
	
	private HashMap<String, ClassDecl> classSpec;
	private StmtBlock mainFunction;
	
	//setter
	public Program(HashMap<String, ClassDecl> classSpec, StmtBlock mainFunction)
	{
		this.classSpec = classSpec;
		this.mainFunction = mainFunction;
	}
	
	
	//getter
	public StmtBlock getMF()
	{ 
		return mainFunction;
	}
	
	public ClassDecl getClassDef(String id)
	{
		return classSpec.get(id);
	}
	
	public HashMap<String, ClassDecl> getClasses()
	{
		return classSpec;
	}
	
	
	public void print(){
		System.out.println("Il programma ha le classi:");
		for (String key: classSpec.keySet()){
            ClassDecl cl = classSpec.get(key);  
            cl.print();  
		} 
		System.out.println("La main funcrion é:");
		mainFunction.print();
	}
}