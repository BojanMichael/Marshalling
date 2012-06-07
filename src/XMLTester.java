import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.Scanner;
import javax.xml.bind.JAXBException;
import org.junit.Test;


public class XMLTester 
{
	@Test
	public void unmarshal() 
	{
		TimeUnits tUList = null;
		try 
		{
			tUList = (TimeUnits)Factory.loadInstance(new FileInputStream("out.xsd"), TimeUnits.class);
		} 
		catch (FileNotFoundException e) 
		{
			System.out.println(e.getMessage());
		} 
		catch (JAXBException e) 
		{
			System.out.println(e.getMessage());
		}

		if(tUList != null)
		{
			for(TimeUnit el : tUList.getTimeUnitList())
			{
				System.out.println(el.toString());
			}
		}
	}
	
	@Test
	public void marshal() 
	{
		TimeUnits tUList = new TimeUnits();
		tUList.add(new TimeUnit("km", 1000, false, "Kilometer"));
		tUList.add(new TimeUnit("m", 1, true, "Meter"));
		tUList.add(new TimeUnit("dm", 0.1, false, "Dezimeter"));
		tUList.add(new TimeUnit("cm", 0.01, false, "Centimeter"));

		String fileOutString = "";
		byte [] array;
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		try 
		{
			Factory.saveInstance(os,tUList);

			os.close();
			array = os.toByteArray();

			Scanner s = new Scanner (new ByteArrayInputStream(array));
			while (s.hasNextLine())
			{
				String b = s.nextLine(); 
				System.out.println(b);
				fileOutString += b+"\n";
			}
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}

		try
		{
			FileWriter fstream = new FileWriter("out.xsd");
			BufferedWriter out = new BufferedWriter(fstream);
			out.write(fileOutString);
			out.close();
		}
		catch (Exception e)
		{
			System.err.println(e.getMessage());
		}
	}

}
