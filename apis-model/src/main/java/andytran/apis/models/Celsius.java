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
	public Unit convertTo(String toType) {
		switch(toType){
		case "fahrenheit":
			return toFahrenheit();
		case "celsius":
			return this;
		default:
			return null;
		}
	}
	
	private Fahrenheit toFahrenheit(){
		Double celsius = Double.valueOf(num);
		Double result = celsius * 1.8 + 32;

		return new Fahrenheit(result);
	}

}
