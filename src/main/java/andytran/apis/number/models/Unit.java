package andytran.apis.number.models;

public abstract class Unit {
	
	private String abbr;
	protected String numStr;
	
	protected Unit(String abbr){
		this.setAbbr(abbr);
	}

	public String getAbbr() {
		return abbr;
	}

	public void setAbbr(String abbr) {
		this.abbr = abbr;
	}
	
	public String getNumStr() {
		return numStr;
	}

	public void setNumStr(String numStr){
		this.numStr = numStr;
	}
	
	public abstract Unit convertTo(UnitType toType);
	
}
