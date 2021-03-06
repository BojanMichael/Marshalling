package unit;

import language.LanguageHandler;

@SuppressWarnings("rawtypes")
public interface IMultiLingualUnit extends IUnit
{
	public boolean isSIUnit();
	public String getDescription(String language);
	public String getUnitName(String language);
	public boolean addNewLanguage(LanguageHandler language);
}