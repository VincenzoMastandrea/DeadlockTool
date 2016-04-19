package models;

/**
 * @author Vincenzo Mastandrea
 */
public class ExpressionIntValue extends ExpressionValue {
	
	/**
	 * Creates an integer expression value
	 * @param value: an integer value
	 */
	public ExpressionIntValue(int value){
		super(value);		
	}
	
	@Override
	public Integer getValue() 
	{ 
		return (int)value; 
	}
}
