package co.gui;

import java.util.HashMap;

import org.json.simple.JSONObject;

import net.nurigo.java_sdk.api.Message;
import net.nurigo.java_sdk.exceptions.CoolsmsException;

public class SmsApp {
	public String sendSms(String to, String from, String content){
		String api_key = "NCSZTGIMBOGWIMIB";
	    String api_secret = "OHMB7DRYUKNU87Q3BSIX7LCVEGMD4KQ9";
	    Message coolsms = new Message(api_key, api_secret);

	    // 4 params(to, from, type, text) are mandatory. must be filled
	    HashMap<String, String> params = new HashMap<String, String>();
	    params.put("to", to); // 수신번호
	    params.put("from", from); // 발신번호
	    params.put("type", "SMS"); // Message type ( SMS, LMS, MMS, ATA )
	    params.put("text", content); // 문자내용    
	    params.put("app_version", "JAVA SDK v1.2"); // application name and version
	    try {
	        JSONObject obj = (JSONObject) coolsms.send(params);
	        System.out.println(obj.toString());
	        return "Success";
	      } catch (Exception e) {
//	        System.out.println(e.getMessage());
//	        System.out.println(e.getCode());
	    	e.printStackTrace();
	        return "Fail";
	      }
	}
}
