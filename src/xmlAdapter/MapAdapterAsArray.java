package xmlAdapter;

import java.util.HashMap;
import java.util.Map;
import javax.xml.bind.annotation.adapters.XmlAdapter;
import language.LanguageHandler;
import language.LanguageHandlerMapElement;

public class MapAdapterAsArray extends XmlAdapter<LanguageHandlerMapElement[], Map<String, LanguageHandler>>
{
	@Override
	public LanguageHandlerMapElement[] marshal(Map<String, LanguageHandler> map) throws Exception 
	{
		LanguageHandlerMapElement[] mapElements = new LanguageHandlerMapElement[map.size()];
		int i = 0;
		
		for(Map.Entry<String, LanguageHandler> entry : map.entrySet())
		{
			mapElements[i++] = new LanguageHandlerMapElement(entry.getKey(), entry.getValue());
		}

		return mapElements;
	}

	@Override
	public Map<String, LanguageHandler> unmarshal(LanguageHandlerMapElement[] mapLanguage) throws Exception 
	{
		Map<String, LanguageHandler> map = new HashMap<String, LanguageHandler>();
		for(LanguageHandlerMapElement mapElement : mapLanguage)
		{
			map.put(mapElement.language, mapElement.languageSet);
		}
		return map;
	}	
}