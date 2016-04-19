package models;

public class Return extends Statement{

	private final static String STMTTYPE = "Return";
	private Expression returnedExp;
	
	public Return(Expression returnedExp) {
		super(STMTTYPE);
		// TODO Auto-generated constructor stub
		this.returnedExp = returnedExp;
	}
	
	public void setReturnedExp(Expression returnedExp)
	{
		this.returnedExp = returnedExp;
	}
	
	public Expression getReturnedExp()
	{
		return returnedExp;
	}
}
