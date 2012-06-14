package language;

import javax.xml.bind.annotation.XmlElement;

public class LanguageHandlerMapElement
{
	@XmlElement(name = "languageSet", required = true)
	public LanguageHandler languageSet;
	
	@XmlElement(name = "language")
	public String language;
	
	@SuppressWarnings("unused")
	private LanguageHandlerMapElement()
	{
		// Required by JAXB
	}
	
	public LanguageHandlerMapElement(String language, LanguageHandler languageSet)
	{
		super();
		this.language = language;
		this.languageSet = languageSet;
	}
}
