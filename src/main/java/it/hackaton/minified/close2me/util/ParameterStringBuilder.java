package it.hackaton.minified.close2me.util;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Map;

public class ParameterStringBuilder {
	
	public static String getParamsString(Map<String, String> params, String charset) throws UnsupportedEncodingException {
		StringBuilder result = new StringBuilder();
		
		for (Map.Entry<String, String> entry : params.entrySet()) {
			result.append(URLEncoder.encode(entry.getKey(), charset));
			result.append("=");
			result.append(URLEncoder.encode(entry.getValue(), charset));
			result.append("&");
		}
		String resultString = result.toString();
		return resultString.length() > 0 ? resultString.substring(0, resultString.length() - 1) : resultString;
	}
}
