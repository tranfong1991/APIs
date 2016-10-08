package andytran.apis.models;

public class Binary extends Unit {
		
	public Binary(){
		super("bin");
	}

	public Binary(String binary) {
		this();
		this.numStr = binary;
	}
	
	@Override
	public Unit convertTo(UnitType toType){
		switch(toType){
		case DECIMAL:
			return toDecimal();
		case BINARY:
			return this;
		default:
			return null;
		}
	}

	private Decimal toDecimal(){
		String binary = (String)numStr;
		if(binary == null || binary.isEmpty())
			return null;
		
		int decimal = 0;
		int power = 0;
		for(int i = binary.length() - 1; i >=0; i--){
			char c = binary.charAt(i);
			int digit = Character.getNumericValue(c);
			
			decimal += digit * Math.pow(2, power++);
		}
		
		return new Decimal(decimal);
	}

}
