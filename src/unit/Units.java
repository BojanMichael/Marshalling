package unit;

import language.LanguageHandler;

public interface Units
{
	public boolean isSIUnit();
	public String getDescription(String language);
	public String getUnitName(String language);
	public boolean addNewLanguage(LanguageHandler language);
}
