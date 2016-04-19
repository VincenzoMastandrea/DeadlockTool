package models;

public class Statement extends CompilationUnit {
	
	private String stmtType;
	
	public Statement(String stmtType)
	{
		this.stmtType = stmtType;
	}
	
	public String getStmtType() {
		return stmtType;
	}

	public void setStmtType(String stmtType) {
		this.stmtType = stmtType;
	}
	
	public String toString()
	{
		return stmtType;
	}
		
}
