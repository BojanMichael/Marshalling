package language;

public class LanguageHandler 
{
	private String language;
	private String context;
	private String key;
	
	public LanguageHandler(String language, String key, String context)
	{
		this.language = language;
		this.key = key;
		this.context = context;
	}

	public String getLanguage() 
	{
		return language;
	}

	public String getContext() 
	{
		return context;
	}

	public void setLanguage(String language) 
	{
		this.language = language;
	}

	public void setContext(String context) 
	{
		this.context = context;
	}
	
	public String getKey() 
	{
		return key;
	}
	
	public void setKey(String key) 
	{
		this.key = key;
	}
}
