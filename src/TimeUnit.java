import java.util.ArrayList;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import language.LanguageHandler;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(namespace="http://ch.fbi.xml.beispielEins",name="time_unit")
public class TimeUnit implements LengthUnit 
{
	@XmlElement(name="unit_label", nillable=false, required=true)	
	private String UNIT_LABEL;
	
	@XmlElement(name="factor_to_SI_unit", nillable=false, required=true)	
	private double FACTOR_TO_SI_UNIT;
	
	@XmlElement(name="unit_name", nillable=true, required=false)
	private String UNIT_NAME;
	
	@XmlElement(name="is_si_unit", nillable=true, required=true)
	private boolean IS_SI_UNIT;
	
	@XmlElement(name="languageHandler")
	private ArrayList<LanguageHandler> languageHandlerList = new ArrayList<LanguageHandler>();
	
	
	public TimeUnit(String unitLabel, double factorToSIUnit, boolean isSi)
	{
		this.UNIT_LABEL=unitLabel;
		this.FACTOR_TO_SI_UNIT=factorToSIUnit;
		this.IS_SI_UNIT = isSi;
	}
	
	public TimeUnit(String unitLabel, double factorToSIUnit, boolean isSi, LanguageHandler[] languageSet)
	{
		this.UNIT_LABEL=unitLabel;
		this.FACTOR_TO_SI_UNIT=factorToSIUnit;
		this.IS_SI_UNIT = isSi;
		
		fillLanguageSet(languageSet);
	}
	
	@SuppressWarnings("unused")
	private TimeUnit()
	{ 
		//only for JAXB -> Almost magic 
	}
	
	private void fillLanguageSet(LanguageHandler[] languageSet)
	{
		for(LanguageHandler lang : languageSet)
			languageHandlerList.add(lang);
	}
	
	public ArrayList<LanguageHandler> getlanguageHandlerList()
	{
		return languageHandlerList;
	}
	
	public void insertNewLanguage(LanguageHandler languageSet)
	{
		languageHandlerList.add(languageSet);
	}
	
	
	

	@Override
	public String toString() 
	{
		return "TimeUnit [UNIT_LABEL=" + UNIT_LABEL + ", FACTOR_TO_SI_UNIT="
				+ FACTOR_TO_SI_UNIT + ", UNIT_NAME=" + UNIT_NAME + "]";
	}
	
	@Override
	public double getFactorTo(Unit unit) 
	{
		return (unit.getFactorToSIUnit() / this.FACTOR_TO_SI_UNIT);
	}
	
	@Override
	public double getFactorToSIUnit() 
	{
		return FACTOR_TO_SI_UNIT;
	}
	@Override
	public String getUnitLabel() 
	{
		return UNIT_LABEL;
	}
	@Override
	public boolean isSIUnit() 
	{
		return IS_SI_UNIT;
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getUnitName() {
		// TODO Auto-generated method stub
		return null;
	}
}