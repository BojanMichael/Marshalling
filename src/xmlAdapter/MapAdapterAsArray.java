package xmlAdapter;

import java.util.Map;
import javax.xml.bind.annotation.adapters.XmlAdapter;

import unit.MyUnit;
import language.LanguageHandler;

public class MapAdapterAsArray extends XmlAdapter<LanguageHandler[], Map<String, LanguageHandler>>
{

	@Override
	public LanguageHandler[] marshal(Map<String, LanguageHandler> arg0)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, LanguageHandler> unmarshal(LanguageHandler[] arg0)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
}