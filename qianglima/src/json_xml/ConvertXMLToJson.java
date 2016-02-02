package json_xml;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.XML;

public class ConvertXMLToJson {
    
	static String xml = "<name>Sayalic</name><age>25</age><girlfriend>null</girlfriend><gayfriend><age>24.5</age><name>dploop</name><FavoriteFruits>pear</FavoriteFruits><FavoriteFruits>lemon</FavoriteFruits></gayfriend><FavoriteFruits>orange</FavoriteFruits><FavoriteFruits>banana</FavoriteFruits><FavoriteFruits>apple</FavoriteFruits>";
	
	public static void main(String[] args){
		String json = null;
		JSONObject jsonObj = null;
		try{
			jsonObj = XML.toJSONObject(xml);
		}catch(JSONException e){
			e.printStackTrace();
		}
		try{
			json = jsonObj.toString(2);
		}catch(JSONException e){
			e.printStackTrace();
		}
		System.out.println(json);
	}
}
