package andytran.apis.models;

public final class UnitFactory {
	
	public static Unit makeUnit(String unitType){
		switch(unitType){
		case "binary":
			return new Binary();
		case "decimal":
			return new Decimal();
		case "celsius":
			return new Celsius();
		case "fahrenheit":
			return new Fahrenheit();
		default:
			return null;
		}
	}

}
