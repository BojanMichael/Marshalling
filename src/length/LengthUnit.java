package length;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import unit.MyUnit;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(namespace="http://ch.fbi.xml.beispielEins", name="lengthUnit")
public class LengthUnit extends MyUnit
{
	public LengthUnit(String unitLabel, double factorToSIUnit) 
	{
		super(unitLabel, factorToSIUnit);
	}
	
	
	
	
}
