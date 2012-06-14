import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.SchemaOutputResolver;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.Result;
import javax.xml.transform.stream.StreamResult;

public class Factory 
{
	//	public static void saveInstance (OutputStream outputStream , Object instance) throws JAXBException , IOException 
	//	{
	//		Marshaller marshaller = JAXBContext.newInstance(instance.getClass()).createMarshaller();
	//
	//		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
	//		marshaller.marshal(instance, outputStream);
	//		outputStream.flush();
	//	}

	public static void saveInstance(OutputStream outputStream, Object instance) throws JAXBException, IOException 
	{
		Marshaller marshaller = JAXBContext.newInstance(instance.getClass()).createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
		marshaller.marshal(instance, outputStream);
		outputStream.flush();
	}

	public static Object loadInstance(InputStream inputStream, Class instanceClass) throws JAXBException
	{
		Unmarshaller unmarshaller = JAXBContext.newInstance(instanceClass).createUnmarshaller();
		return unmarshaller.unmarshal(inputStream);
	}


	public static void saveSchema(File baseDir, Class... classes) throws JAXBException, IOException 
	{
		JAXBContext context = JAXBContext.newInstance(classes);
		context.generateSchema(new LocalFileSchemaResorlver(baseDir));
	}
	
	static class LocalFileSchemaResorlver extends SchemaOutputResolver 
	{
		private File baseDir;

		public LocalFileSchemaResorlver(File baseDir) 
		{
			this.baseDir = baseDir;
		}

		public Result createOutput(String namespaceUri, String suggestedFileName) throws IOException 
		{
			return new StreamResult(new File(baseDir, suggestedFileName));
		}
	}
}
