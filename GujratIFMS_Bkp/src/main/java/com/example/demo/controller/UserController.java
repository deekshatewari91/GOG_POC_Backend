package com.example.demo.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.userdetails.MapReactiveUserDetailsService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.exception.GOGException;
import com.example.demo.service.Address;
import com.example.demo.service.Cities;
import com.example.demo.service.CitiesService;
import com.example.demo.service.Countries;
import com.example.demo.service.CountriesService;
import com.example.demo.service.Login;
import com.example.demo.service.MainService;
import com.example.demo.service.User;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
public class UserController 
{
	ch.qos.logback.classic.Logger logger =  (ch.qos.logback.classic.Logger) LoggerFactory.getLogger(UserController.class);

	
	@Autowired
	private MainService rep;
	
	@Autowired
	private CountriesService cService;
	
	@Autowired
	private CitiesService cityService;

	@RequestMapping("/") 
	public String home()
	{
		return "ShowUser.jsp";
	} 
	
	@Secured("ROLE_ADMIN")
	@RequestMapping(path="/api/getUser") 
	public List<User> findAll()
	{

		String jsessionid = RequestContextHolder.currentRequestAttributes().getSessionId(); 
		logger.info(jsessionid + "***************** In api/getUser User controller...");
		List<User> gUser = rep.findAll();
		System.out.println("ID"+ gUser.get(0).getId());
			
			return gUser;
			
	}
	
	
	@GetMapping("/api/countries")
	public List<Countries> getCountries(HttpSession session)
	{
		List<Countries> countries=(List<Countries>) cService.findAll();
		System.out.println(countries);
		return countries;
	}
	
	@Cacheable(value="citiesCache" , key="#countryId")
	@GetMapping("/api/cities/{countryId}")
	public List<Cities> getCities(@PathVariable("countryId")int countryId)
	{
		List<Cities> cities=cityService.getCitiesBycid(countryId);
		return cities;
	}
	
	
	@RequestMapping(path="/api/addperson") 
	 public HashMap<String, String> create(@RequestBody User user){
		
		ResponseEntity<?> resEntity = null;
		HashMap<String, String> map = new HashMap<String, String>();
    	System.out.println("Inside Add User");		
			if(rep.create(user).equals("success"))
			{
				map.put("success", "success");
			}					
        return map;
    }
	
	@RequestMapping(path="/api/loginUser") 
	public HashMap<String, String> loginUser(@RequestBody String login) {

		String jsessionid = RequestContextHolder.currentRequestAttributes().getSessionId(); 
		logger.info(jsessionid + "Inside login User");
		HashMap<String, String> map = new HashMap<String, String>();
		try {
			
			map = rep.login(login);
			
		} catch (Exception e) {
			System.out.println(e);
			map.put("error", "error");
		}
		
		return map;
	}

	@RequestMapping(path="/getName") 
	public ModelAndView getName()
	{
		String jsessionid = RequestContextHolder.currentRequestAttributes().getSessionId(); 
		logger.info(jsessionid + "***************** In getName User controller...");
		List<String> lfname = new ArrayList<String>();
		ModelAndView modelAndView = new ModelAndView("home.jsp");
		lfname = rep.findAllFirstName();
		
		String listText = "First Names are : ";

		for(String a : lfname)
		{
			listText+=a + ", ";
		}

		listText = listText.substring(0, listText.length() - 2);
		
		listText+=".";
		
		modelAndView.addObject("lfname", listText);
		return modelAndView;
	}
	
	

	@RequestMapping({"/getApprUser"})
	public ModelAndView getAppUser()
	{
		String jsessionid = RequestContextHolder.currentRequestAttributes().getSessionId(); 
		logger.info(jsessionid + "***************** In getAppUser User controller...");
		ModelAndView modelAndView = new ModelAndView("ShowUser.jsp");
		/*try 
		{
			List<User> gUser = rep.findUserbyStatus(1) ;
			
			System.out.println(gUser);
			
		}
		catch(Exception ex)
		{
			modelAndView.addObject("gerror", "Please enter correct values.");			
		}
		*/
		return modelAndView;
	}	
	

	@RequestMapping(path="/deleteUser") 
	public ModelAndView deleteUser(@RequestParam  String id)
	{
		String jsessionid = RequestContextHolder.currentRequestAttributes().getSessionId(); 
		logger.info(jsessionid + "***************** In deleteUser User controller...");
		ModelAndView modelAndView = new ModelAndView("home.jsp");
		try 
		{
			String result = rep.deleteUser(Integer.parseInt(id));
			logger.info(jsessionid + "*********" + result);

			modelAndView.addObject("delMSG", result);	
						
		}
		catch(Exception ex)
		{
			modelAndView.addObject("delMSG", "Error Occurred." + ex.getMessage());			
		}
		
		return modelAndView;
	}
	
	
	
	/***************************************************************************************************************************/
	

	@RequestMapping(path="/api/approveUserParam", method=RequestMethod.POST) 
	public void approveUser(@RequestBody List<User> arr)
	{
		String jsessionid = RequestContextHolder.currentRequestAttributes().getSessionId(); 
		logger.info(jsessionid + "***************** In approveUserParam User controller...");
		
    	//arr.forEach((User) -> User.setStatus(true));
    	
    	rep.updateStatus(arr); 
    	
	}
	

	@RequestMapping(path="/api/addEmployee", method=RequestMethod.POST) 
	public void addEmployee(@RequestBody User user, @RequestBody List<Address> addr)
	{
		String jsessionid = RequestContextHolder.currentRequestAttributes().getSessionId(); 
		logger.info(jsessionid + "***************** In addEmployee User controller...");
	}
	
}