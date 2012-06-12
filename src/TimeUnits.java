import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(namespace = "http://ch.fbi.xml.beispielEins")
@XmlAccessorType(XmlAccessType.FIELD)
public class TimeUnits 
{
	private List<TimeUnit> timeUnitList = new ArrayList<TimeUnit>();
	
	public TimeUnits()
	{
	}
	
	public List<TimeUnit> getTimeUnitList() 
	{
		return timeUnitList;
	}

	public void add(Object obj)
	{
		timeUnitList.add((TimeUnit)obj);
	}
}
