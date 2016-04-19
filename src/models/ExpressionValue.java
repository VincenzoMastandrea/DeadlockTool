package models;

/**
 * @author Vincenzo Mastandrea
 */
public class ExpressionValue extends Element {
	
	protected Object value;
	
	public Object getValue(){ return value; }
	
	/**
	 * Creates an expression with value
	 * @param value the value of the expression
	 */
	public ExpressionValue(Object value) {
		this.value = value;
	}
	
	

}
