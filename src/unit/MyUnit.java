package unit;

import java.util.HashMap;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import xmlTools.MapAdapterAsArray;

import language.LanguageHandler;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(namespace="http://ch.fbi.xml.beispielEins", name="MyUnit")
public class MyUnit implements IMultiLingualUnit
{
	@XmlElement(name="unit_label", nillable=false, required=true)	
	private String unitLabel;

	@XmlElement(name="factor_to_SI_unit", nillable=false, required=true)	
	private double factorToSiUnit;

	@XmlElement(name="unit_name", nillable=true, required=false)
	private boolean isSiUnit;

	@XmlJavaTypeAdapter(MapAdapterAsArray.class)
	@XmlElement(name = "languageMap")
	private HashMap<String, LanguageHandler> languageHandlerHashMap;

	public MyUnit(String unitLabel, double factorToSIUnit, boolean isSiUnit, LanguageHandler[] languageSet)
	{
		this.unitLabel = unitLabel;
		this.factorToSiUnit = factorToSIUnit;
		this.isSiUnit = isSiUnit;

		fillMap(languageSet);
	}

	private void fillMap(LanguageHandler[] languageSet)
	{
		languageHandlerHashMap = new HashMap<String, LanguageHandler>();

		for(LanguageHandler lang : languageSet)
			languageHandlerHashMap.put(lang.getLanguage(), lang);
	}

	@SuppressWarnings("unused")
	private MyUnit()
	{
		//only for JAXB -> Almost magic
	}

	//	@Override
	public String getUnitLabel() 
	{
		return unitLabel;
	}

	//	@Override
	public double getFactorToSiUnit()
	{
		return factorToSiUnit;
	}

	@Override
	public String getDescription(String language)
	{
		return languageHandlerHashMap.get(language).getDescription();
	}

	@Override
	public boolean isSIUnit()
	{
		return isSiUnit;
	}

	@Override
	public String getUnitName(String language)
	{
		return languageHandlerHashMap.get(language).getName();
	}

	@Override
	public boolean addNewLanguage(LanguageHandler language)
	{
		if(languageHandlerHashMap != null)
		{
			languageHandlerHashMap.put(language.getLanguage(), language);
			return true;
		}

		return false;
	}

	@Override
	public String toString() 
	{
		return "TimeUnit [UNIT_LABEL=" + unitLabel + ", FACTOR_TO_SI_UNIT=" + factorToSiUnit + ", UNIT_NAME=" + "[UnitName] " + "]";
	}

	@Override
	public double getFactorToSIUnit() 
	{
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getFactorTo(IUnit unit) 
	{
		// TODO Auto-generated method stub
		return 0;
	}
}
