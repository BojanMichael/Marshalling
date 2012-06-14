package unit;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(namespace = "http://ch.fbi.xml.beispielEins")
@XmlAccessorType(XmlAccessType.FIELD)
public class MyUnits 
{
	private ArrayList<MyUnit> myUnitList = new ArrayList<MyUnit>();
	
	public List<MyUnit> getMyUnitList() 
	{
		return myUnitList;
	}

	public void add(Object obj)
	{
		myUnitList.add((MyUnit)obj);
	}
}