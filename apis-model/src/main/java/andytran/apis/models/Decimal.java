package andytran.apis.models;

import java.util.ArrayDeque;
import java.util.Deque;

public class Decimal extends Unit {
		
	public Decimal(){
		super("dec");
	}

	public Decimal(int decimal) {
		this();
		this.numStr = String.valueOf(decimal);
	}
	
	@Override
	public Unit convertTo(UnitType toType) {
		switch(toType){
		case BINARY:
			return toBinary();
		case DECIMAL:
			return this;
		default:
			return null;
		}
	}
	
	private Binary toBinary(){
		int decimal = Integer.valueOf(numStr);
		
		if(decimal < 0)
			return null;
		
		if(decimal == 0)
			return new Binary("0");
		
		Deque<Integer> stack = new ArrayDeque<>();
		StringBuilder stringBuilder = new StringBuilder();
		
		while(decimal != 0){
			stack.push(decimal % 2);
			decimal /= 2;
		}
		
		//reverse the stack of binary
		while(!stack.isEmpty()){
			stringBuilder.append(stack.pop());
		}
		
		return new Binary(stringBuilder.toString());
	}

}
