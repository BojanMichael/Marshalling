import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;
import javax.xml.bind.JAXBException;

import language.LanguageHandler;
import length.LengthUnit;

import org.junit.Test;

import unit.MyUnit;


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

		FileOutputStream fOS = null;
		try 
		{
			fOS = new FileOutputStream("./outObject.xml");
		}
		catch (FileNotFoundException e1) 
		{
			System.out.println(e1.getMessage());
			e1.printStackTrace();
		}

		try 
		{
			Factory.saveInstance(fOS,tUList);
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


		//		try
		//		{
		//			FileWriter fstream = new FileWriter("out.xsd");
		//			BufferedWriter out = new BufferedWriter(fstream);
		//			out.write(fileOutString);
		//			out.close();
		//		}
		//		catch (Exception e)
		//		{
		//			System.err.println(e.getMessage());
		//		}
	}

	@Test
	public void saveSchema()
	{
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
