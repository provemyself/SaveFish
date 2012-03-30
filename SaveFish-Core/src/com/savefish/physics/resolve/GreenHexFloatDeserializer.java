package com.savefish.physics.resolve;

/********************************
 * Description: 该类是GreenHexFloat
 *              的反序列化器
 * Author     : 王志伟
 * Date       : 2012/03/12
 *******************************/

import java.lang.reflect.Type;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

public class GreenHexFloatDeserializer implements
		JsonDeserializer<GreenHexFloat> {

	@Override
	public GreenHexFloat deserialize(JsonElement json, Type arg1,
			JsonDeserializationContext arg2) throws JsonParseException {
		String element = json.toString();
		if (element.contains("\"")) {
			element = element.replace("\"", "");
			return new GreenHexFloat(this.floatFromHex(element));
		} else {
			return new GreenHexFloat(Float.parseFloat(element));

		}
	}

	private float floatFromHex(String hex) {
		Long tmp = Long.parseLong(hex, 16);
		return Float.intBitsToFloat(tmp.intValue());
	}

}
