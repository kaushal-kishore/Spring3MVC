package main.java.com.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WebController {

	/*@RequestMapping("/springController")
	public ModelAndView springController() {

		return new ModelAndView("addUserController");
	}*/
	
	@RequestMapping("/createusers")
	public ModelAndView addUserController() {

		return new ModelAndView("AddUser");
	}
	
	
	//"http://localhost:8080/addViewUserWS/rest/user/addUser"	
	
	@RequestMapping("/viewuser")
	public JSONObject viewuser() {
		JSONObject jsonResponse = new JSONObject();
		try {
			String line = "";
			String resp = "";
			
			String baseUrl = "http://localhost:8080/addViewUserWS/rest/user/viewUser";
			URL url = new URL(baseUrl);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
	        while ((line = br.readLine()) != null) {
	        	resp = resp + line;
	        }
	        br.close();
	        connection.disconnect();
	        jsonResponse = new JSONObject(resp);
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		return jsonResponse;
	}
	
	

	
	@RequestMapping("/Modify")
	public ModelAndView ModifyUser() {
		
		return new ModelAndView("Modify");
	}
	
	

}
