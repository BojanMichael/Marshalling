import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.Locale;
import java.util.Scanner;
import javax.xml.bind.JAXBException;

import language.LanguageHandler;

import org.junit.Test;


public class XMLTester 
{
//	@Test
//	public void unmarshal() 
//	{
//		TimeUnits tUList = null;
//		try 
//		{
//			tUList = (TimeUnits)Factory.loadInstance(new FileInputStream("out.xsd"), TimeUnits.class);
//		} 
//		catch (FileNotFoundException e) 
//		{
//			System.out.println(e.getMessage());
//		} 
//		catch (JAXBException e) 
//		{
//			System.out.println(e.getMessage());
//		}
//
//		if(tUList != null)
//		{
//			for(TimeUnit el : tUList.getTimeUnitList())
//			{
//				System.out.println(el.toString());
//			}
//		}
//	}
	
	@Test
	public void marshal() 
	{
		
//		System.out.println(Locale.getDefault().getLanguage());
		
		TimeUnits tUList = new TimeUnits();
		
		tUList.add(new TimeUnit("km", 1000, false, new LanguageHandler[]{new LanguageHandler("de", "Kilometer", "Beschr"), new LanguageHandler("en", "kilometer", "descr")}));
		tUList.add(new TimeUnit("m", 1, true,  new LanguageHandler[]{new LanguageHandler("de", "Meter", "Beschr"), new LanguageHandler("en", "meter", "descr")}));
//		tUList.add(new TimeUnit("dm", 0.1, false, "Dezimeter"));
//		tUList.add(new TimeUnit("cm", 0.01, false, "Centimeter"));

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
