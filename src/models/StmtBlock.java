package models;

import java.util.HashMap;
import java.util.LinkedList;

public class StmtBlock extends Statement{
	
	private final static String STMTTYPE = "Block";
	private HashMap<String,Type> varDec;
	private LinkedList<Statement> stmts; 
		
	public StmtBlock(HashMap<String,Type> varDec, LinkedList<Statement> stmts)
	{
		super(STMTTYPE);
		this.varDec = varDec;
		this.stmts = stmts;
	}
	
	public StmtBlock()
	{
		super(STMTTYPE);
		this.varDec = null;
		this.stmts = null;
	}
	
	public HashMap<String,Type> getVars()
	{
		return varDec;
	}
	
	public LinkedList<Statement> getStmts()
	{
		return stmts;
	}
	
	public void setStmts(LinkedList<Statement> stmts)
	{
		this.stmts = stmts;
	}
	
	public void setVarDec(HashMap<String,Type> varDec)
	{
		this.varDec = varDec;
	}
	
	
	public void print() {
		System.out.println("Le variabili sono: ");
		for (String key: varDec.keySet()){
			System.out.println(varDec.get(key) + " -> " + key);
		}
		for(int i=0;i<stmts.size();i++)
		{ String s;
		  System.out.println(i +") " + stmts.get(i).toString());
		}

	}
}
