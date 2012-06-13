package unit;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(namespace="http://ch.fbi.xml.beispielEins",name="MyUnit")
public abstract class MyUnit implements Units
{
	@XmlElement(name="unit_label", nillable=false, required=true)	
	private String unitLabel;
	
	@XmlElement(name="factor_to_SI_unit", nillable=false, required=true)	
	private double factorToSiUnit;
		
	@XmlElement(name="unit_name", nillable=true, required=false)
	private String unitName;
	
	public MyUnit(String unitLabel, double factorToSIUnit)
	{
		this.unitLabel = unitLabel;
		this.factorToSiUnit = factorToSIUnit;
	}
	public MyUnit(String unitLabel,double factorToSIUnit,String unitName)
	{
		this.unitLabel = unitLabel;
		this.factorToSiUnit = factorToSIUnit;
		this.unitName = unitName;
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
	public String getUnitName() 
	{
		return unitName;
	}
	
	@Override
	public String getDescription()
	{
//		Please implement this method
		return null;
	}
	
	@Override
	public boolean isSIUnit()
	{
//		Please implement this method
		return false;
	}

	@Override
	public String toString() 
	{
		return "TimeUnit [UNIT_LABEL=" + unitLabel + ", FACTOR_TO_SI_UNIT=" + factorToSiUnit + ", UNIT_NAME=" + unitName + "]";
	}
}
