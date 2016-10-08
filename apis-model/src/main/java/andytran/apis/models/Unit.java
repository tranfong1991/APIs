package andytran.apis.models;

public abstract class Unit {
	
	private String abbr;
	protected String num;
	
	protected Unit(String abbr){
		this.setAbbr(abbr);
	}

	public String getAbbr() {
		return abbr;
	}

	public void setAbbr(String abbr) {
		this.abbr = abbr;
	}
	
	public String getNum() {
		return num;
	}

	public void setNum(String num){
		this.num = num;
	}
	
	public abstract Unit convertTo(UnitType toType);
	
}
