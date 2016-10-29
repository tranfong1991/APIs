package andytran.apis.number.models;

public class Kelvin extends Unit {
	
	public Kelvin(){
		super("K");
	}
	
	public Kelvin(Double degree){
		this();
		this.numStr = String.valueOf(degree);
	}

	@Override
	public Unit convertTo(UnitType toType) {
		switch(toType){
		case CELSIUS:
			return toCelsius();
		case KELVIN:
			return this;
		case FAHRENHEIT:
			return toFahrenheit();
		default:
			return null;
		}
	}
	
	private Fahrenheit toFahrenheit() {
		Double kelvin = Double.valueOf(numStr);
		Double result = kelvin * 1.8 - 459.67;
		
		return new Fahrenheit(result);
	}

	private Celsius toCelsius(){
		Double kelvin = Double.valueOf(numStr);
		Double result = kelvin - 273.15;
		
		return new Celsius(result);
	}

}
