/**
 * 
 */
package models;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * @author Vincenzo Mastandrea
 * Base class for an ASP program
 */
public class Program extends CompilationUnit {



	private String programName;
	private HashMap<String, ClassDecl> classSpec;
	private StmtBlock mainFunction;

	public Program(HashMap<String, ClassDecl> classSpec, StmtBlock mainFunction)
	{
		this.classSpec = classSpec;
		this.mainFunction = mainFunction;
	}

	public Program(HashMap<String, ClassDecl> classSpec, StmtBlock mainFunction, String name)
	{
		this.classSpec = classSpec;
		this.mainFunction = mainFunction;
		this.programName = name;
	}

	public String getProgramName() {
		return programName;
	}

	public void setProgramName(String programName) {
		this.programName = programName;
	}

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