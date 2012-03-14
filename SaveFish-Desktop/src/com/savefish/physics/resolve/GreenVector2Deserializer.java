package com.savefish.physics.resolve;

/********************************
 * Description: 该类是GreenVector2
 *              的反序列化器
 * Author     : 王志伟
 * Date       : 2012/03/12
 *******************************/

import java.lang.reflect.Type;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

public class GreenVector2Deserializer implements JsonDeserializer<GreenVector2> {

	Logger logger = Logger.getLogger("com.tulip.test.physics");

	@Override
	public GreenVector2 deserialize(JsonElement element, Type type,
			JsonDeserializationContext context) throws JsonParseException {
		String val = element.toString();
		logger.log(Level.INFO, val);
		if (val.matches("\\{.*\\}")) {
			String[] strs = val.split(",");
			return new GreenVector2(this.toFloat(strs[0]),
					this.toFloat(strs[1]));
		} else if (val.matches("\\d*")) {
			return new GreenVector2(Float.parseFloat(val), 0);
		}
		return new GreenVector2(0, 0);
	}

	private float toFloat(String s) {
		s = s.split(":")[1].trim();
		s = s.replace("{", "").replace("}", "");
		if (s.contains("\"")) {
			s = s.replace("\"", "");
			return parseFromHex(s);
		} else {
			return Float.parseFloat(s);
		}
	}

	private float parseFromHex(String hex) {
		Long i = Long.parseLong(hex, 16);
		Float f = Float.intBitsToFloat(i.intValue());
		return f;
	}

}
