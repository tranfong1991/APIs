package andytran.apis.models;

public class Fahrenheit extends Unit {
	
	public Fahrenheit(){
		super("F");
	}
	
	public Fahrenheit(Double degree) {
		this();
		this.numStr = String.valueOf(degree);
	}

	@Override
	public Unit convertTo(UnitType toType) {
		switch(toType){
		case CELSIUS:
			return toCelsius();
		case FAHRENHEIT:
			return this;
		case KELVIN:
			return toKelvin();
		default:
			return null;
		}
	}
	
	private Kelvin toKelvin() {
		Double fahrenheit = Double.valueOf(numStr);
		Double result = (fahrenheit + 459.67) / 1.8;
		
		return new Kelvin(result);
	}

	private Celsius toCelsius(){
		Double fahrenheit = Double.valueOf(numStr);
		Double result = (fahrenheit - 32) / 1.8;
		
		return new Celsius(result);
	}

}
