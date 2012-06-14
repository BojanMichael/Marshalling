package language;

public class LanguageHandler 
{
	private String language;
	private String name;
	private String description;
	
	public LanguageHandler(String language, String name, String description)
	{
		this.language = language;
		this.name = name;
		this.description = description;
	}
	
	private LanguageHandler()
	{
		//used for marshalling
	}

	public String getLanguage() 
	{
		return language;
	}

	public String getName() 
	{
		return name;
	}

	public void setLanguage(String language) 
	{
		this.language = language;
	}

	public void setName(String name) 
	{
		this.name = name;
	}
	
	public String getDescription() 
	{
		return description;
	}

	public void setDescription(String description) 
	{
		this.description = description;
	}
}
