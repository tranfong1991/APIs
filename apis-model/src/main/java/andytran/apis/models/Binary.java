package andytran.apis.models;

public class Binary extends Unit {
		
	public Binary(){
		super("bin");
	}

	public Binary(String binary) {
		this();
		this.num = binary;
	}
	
	@Override
	public Unit convertTo(String toType){
		switch(toType){
		case "decimal":
			return toDecimal();
		case "binary":
			return this;
		default:
			return null;
		}
	}

	private Decimal toDecimal(){
		String binary = (String)num;
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
