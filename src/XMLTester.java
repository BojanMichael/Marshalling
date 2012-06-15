import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Locale;
import javax.xml.bind.JAXBException;
import language.LanguageHandler;

import org.junit.Test;

import unit.MyUnit;
import unit.MyUnits;


public class XMLTester 
{
//		@Test
		public void unmarshal() 
		{
			TimeUnits tUList = null;
			try 
			{
				tUList = (TimeUnits)Factory.loadInstance(new FileInputStream("./objects/out.xml"), "./schemas", "out.xsd", TimeUnits.class);
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

		String lg = Locale.getDefault().getLanguage();
		
		// Length Unit
		MyUnits lengthUnits = new MyUnits();		
		lengthUnits.add(new MyUnit("km", 1000, false, new LanguageHandler[]{new LanguageHandler("de", "Kilometer", "Beschr"), new LanguageHandler("en", "kilometer", "descr")}));
		lengthUnits.add(new MyUnit("m", 1, true,  new LanguageHandler[]{new LanguageHandler("de", "Meter", "Beschr"), new LanguageHandler("en", "meter", "descr")}));
		
		// Time Unit
		MyUnits timeUnits = new MyUnits();
		timeUnits.add(new MyUnit("min", 1/60, false, new LanguageHandler[]{new LanguageHandler("de", "Minuten", "Beschr"), new LanguageHandler("en", "minutes", "descr")}));
		timeUnits.add(new MyUnit("s", 1, true,  new LanguageHandler[]{new LanguageHandler("de", "Sekunden", "Beschr"), new LanguageHandler("en", "seconds", "descr")}));
		
		
		
		// funktioniert
		FileOutputStream fOS = null;
		try 
		{
			fOS = new FileOutputStream("./objects/out.xml");
		}
		catch (FileNotFoundException e1) 
		{
			System.out.println(e1.getMessage());
			e1.printStackTrace();
		}

		try 
		{
			Factory.saveInstance(fOS, lengthUnits);
		} 
		catch (JAXBException e) 
		{
			System.out.println(e.getMessage());
			e.printStackTrace();
		} 
		catch (IOException e) 
		{
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
		
		
		// tests, if the length unit is working
		for(MyUnit unit : lengthUnits)
		{
			System.out.println("--------------------------------------------------------------------------");
			System.out.println("Name in " + lg + "\t\t" + unit.getUnitName(lg));
			System.out.println("Description in " + lg + "\t" + unit.getDescription(lg));
			System.out.println("--------------------------------------------------------------------------");
		}
		
		// tests, if the time unit is working
		for(MyUnit unit : timeUnits)
		{
			System.out.println("--------------------------------------------------------------------------");
			System.out.println("Name in " + lg + "\t\t" + unit.getUnitName(lg));
			System.out.println("Description in " + lg + "\t" + unit.getDescription(lg));
			System.out.println("--------------------------------------------------------------------------");
		}
	}

	//@Test
	public void saveSchema()
	{
		
		// bi mir isch das nid gange ;)
		
		
		
		File fOS = null;
		fOS = new File("schemas");

		try 
		{
			Factory.saveSchema(fOS, MyUnit.class);
		} 
		catch (JAXBException e) 
		{
			System.out.println(e.getMessage());
			e.printStackTrace();
		} 
		catch (IOException e) 
		{
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}

}
