package models;

public class IfThenElse extends Statement{
	
	private final static String STMTTYPE = "ITE";
	private Expression condition;
	private Statement trueSide;
	private Statement falseSide;
	
	public IfThenElse(Expression condition, Statement trueSide, Statement falseSide) {
		super(STMTTYPE);
		// TODO Auto-generated constructor stub
		this.condition = condition;
		this.trueSide = trueSide;
		this.falseSide = falseSide;
	}
	
	public void setCondition(Expression condition)
	{
		this.condition = condition;
	}
	
	public void setTrueSide(Statement trueSide)
	{
		this.trueSide = trueSide;
	}
	
	public void setFalseSide(Statement falseSide)
	{
		this.falseSide = falseSide;
	}
	
	public Expression getCondition()
	{
		return condition;
	}
	
	public Statement getTrueSide()
	{
		return trueSide;
	}
	
	public Statement getFalseSide()
	{
		return falseSide;
	}
	
	

}
