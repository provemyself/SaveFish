package com.savefish.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;

/**
 * @description 读取Json文件，返回字符串
 * @author zhujianxin
 * 
 */
public class JsonHelper {
	public static String readFromJson(String jsonFileName) {
		File file = new File(jsonFileName);
		InputStream stream = null;
		String jsonText = "";
		try {
			stream = new FileInputStream(file);
			char[] buffer = new char[(int) file.length()];
			for (int i = 0; i < buffer.length; i++) {
				buffer[i] = (char) stream.read();
			}
			jsonText = String.valueOf(buffer);
		} catch (FileNotFoundException e) {
			GreenLogger.getInstance().logp(Level.SEVERE,
					JsonHelper.class.getName(), "getJsonText", e.toString(), e);
		} catch (IOException e) {
			GreenLogger.getInstance().logp(Level.SEVERE,
					JsonHelper.class.getName(), "getJsonText", e.toString(), e);
		} finally {
			try {
				if (null != stream)
					stream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return jsonText;
	}

	/**
	 * @description 将内容写入文件
	 * @param fileName
	 * @param content
	 */
	public static void writeTojson(String fileName, String content) {
		FileWriter writer = null;
		try {
			writer = new FileWriter(fileName);
			writer.write(content);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {

			try {
				if (null != writer)
					writer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
