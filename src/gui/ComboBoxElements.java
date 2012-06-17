package gui;

public class ComboBoxElements 
{
	private String key;
	private String element;
	private boolean isVisible;
	
	public ComboBoxElements(String key, String element, boolean isVisible)
	{
		this.key = key;
		this.element = element;
		this.isVisible = isVisible;
	}

	public String getKey() 
	{
		return key;
	}

	public String getElement() 
	{
		return element;
	}

	public boolean isVisible() 
	{
		return isVisible;
	}
	
}
