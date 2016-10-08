package andytran.apis.models;

public final class UnitFactory {
	
	public static Unit makeUnit(UnitType unitType){
		switch(unitType){
		case BINARY:
			return new Binary();
		case DECIMAL:
			return new Decimal();
		case CELSIUS:
			return new Celsius();
		case FAHRENHEIT:
			return new Fahrenheit();
		case KELVIN:
			return new Kelvin();
		default:
			return null;
		}
	}

}
