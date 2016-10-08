package andytran.apis.models;

public class Celsius extends Unit {

	public Celsius(){
		super("C");
	}
	
	public Celsius(Double degree) {
		this();
		this.num = String.valueOf(degree);
	}

	@Override
	public Unit convertTo(UnitType toType) {
		switch(toType){
		case FAHRENHEIT:
			return toFahrenheit();
		case CELSIUS:
			return this;
		case KELVIN:
			return toKelvin();
		default:
			return null;
		}
	}
	
	private Kelvin toKelvin() {
		Double celsius = Double.valueOf(num);
		Double result = celsius + 273.15;

		return new Kelvin(result);
	}

	private Fahrenheit toFahrenheit(){
		Double celsius = Double.valueOf(num);
		Double result = celsius * 1.8 + 32;

		return new Fahrenheit(result);
	}

}
