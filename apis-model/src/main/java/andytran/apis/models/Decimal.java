package andytran.apis.models;

import java.util.ArrayDeque;
import java.util.Deque;

public class Decimal extends Unit {
		
	public Decimal(){
		super("dec");
	}

	public Decimal(int decimal) {
		this();
		this.num = String.valueOf(decimal);
	}
	
	@Override
	public Unit convertTo(String toType) {
		switch(toType){
		case "binary":
			return toBinary();
		case "decimal":
			return this;
		default:
			return null;
		}
	}
	
	private Binary toBinary(){
		int decimal = Integer.valueOf(num);
		
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
