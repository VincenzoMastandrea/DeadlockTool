package models;

public class Return extends Statement{

	private final static String STMTTYPE = "Return";
	private Variable returnedVariable;
	
	public Return(Variable returnedVariable) {
		super(STMTTYPE);
		// TODO Auto-generated constructor stub
		this.returnedVariable = returnedVariable;
	}
	
	public void setReturnedExp(Variable returnedVariable)
	{
		this.returnedVariable = returnedVariable;
	}
	
	public Variable getReturnedExp()
	{
		return returnedVariable;
	}
}
