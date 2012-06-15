package unit;

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(namespace = "http://ch.fbi.xml.beispielEins")
@XmlAccessorType(XmlAccessType.FIELD)
public class MyUnits
{	
	@XmlElement(name="MyUnit List", nillable=false, required=true)
	private ArrayList<MyUnit> myUnitList;
	
	public MyUnits()
	{
		myUnitList = new ArrayList<MyUnit>();
	}
	
	public void add(MyUnit myUnit)
	{
		myUnitList.add((MyUnit)myUnit);
	}

	public ArrayList<MyUnit> getUnitList() 
	{
		return myUnitList;
	}
}