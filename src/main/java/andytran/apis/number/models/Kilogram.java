package andytran.apis.number.models;

public class Kilogram extends Unit {
	
	public Kilogram(){
		super("kg");
	}
	
	public Kilogram(Double kg){
		this();
		this.numStr = String.valueOf(kg);
	}

	@Override
	public Unit convertTo(UnitType toType) {
		switch(toType){
		case POUND:
			return toPound();
		default:
			return null;
		}
	}
	
	private Pound toPound(){
		Double kg = Double.valueOf(numStr);
		Double result = kg * 2.20462262185;
		
		return new Pound(result);
	}

}
