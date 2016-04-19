package models;

public class ExpressionSideEffects extends Statement {

	private final static String STMTTYPE = "Assignment";

	private String expseType; 
	
	public ExpressionSideEffects(String expseType) {
		super(STMTTYPE);
		// TODO Auto-generated constructor stub
		this.expseType = expseType;
	}
	
	public String getExpseType() {
		return expseType;
	}

	public void setExpseType(String expseType) {
		this.expseType = expseType;
	}

}
