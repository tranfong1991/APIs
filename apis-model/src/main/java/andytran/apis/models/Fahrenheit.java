package andytran.apis.models;

public class Fahrenheit extends Unit {
	
	public Fahrenheit(){
		super("F");
	}
	
	public Fahrenheit(Double degree) {
		this();
		this.num = String.valueOf(degree);
	}

	@Override
	public Unit convertTo(String toType) {
		switch(toType){
		case "celsius":
			return toCelsius();
		case "fahrenheit":
			return this;
		default:
			return null;
		}
	}
	
	private Celsius toCelsius(){
		Double fahrenheit = Double.valueOf(num);
		Double result = (fahrenheit - 32) / 1.8;
		
		return new Celsius(result);
	}

}
