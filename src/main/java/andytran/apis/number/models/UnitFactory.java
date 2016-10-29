package andytran.apis.number.models;

public final class UnitFactory {
	
	private UnitFactory(){}
	
	public static Unit makeUnitInstance(UnitType unitType){
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
		case KILOGRAM:
			return new Kilogram();
		case POUND:
			return new Pound();
		default:
			return null;
		}
	}

}
