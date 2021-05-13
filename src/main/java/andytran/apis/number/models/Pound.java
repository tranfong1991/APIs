package andytran.apis.number.models;

public class Pound extends Unit {
	
	public Pound(){
		super("kg");
	}
	
	public Pound(Double pound){
		this();
		this.numStr = String.valueOf(pound);
	}

	@Override
	public Unit convertTo(UnitType toType) {
		switch(toType){
		case KILOGRAM:
			return toKilogram();
		default:
			return null;
		}
	}

	private Kilogram toKilogram() {
		Double pound = Double.valueOf(numStr);
		Double result = pound / 2.20462262185;
		
		return new Kilogram(result);
	}

}
