package com.example.demo.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;

import com.example.demo.service.Address;
import com.example.demo.service.Employee;
import com.example.demo.service.MainService;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
public class NewController 
{

	//final Logger logger = LoggerFactory.getLogger(this.getClass());
	ch.qos.logback.classic.Logger logger =  (ch.qos.logback.classic.Logger) LoggerFactory.getLogger(NewController.class);

	
	@Autowired
	private MainService rep;

	@SuppressWarnings("unchecked")
	@RequestMapping(path="/api/addEmployee_bkp", method=RequestMethod.POST)
	public void addEmployee_bkp(@RequestBody Map<String, Object> emp, HttpSession session)
	{		       

		String jsessionid = RequestContextHolder.currentRequestAttributes().getSessionId(); 
        logger.info(jsessionid + " | INFO : Normal Message.");
        
        logger.error( new java.lang.Error("this is User defined exception").getMessage());

        logger.info(jsessionid + " | \n\n\n***************** This is in NewController(addEmployee_bkp)\n");
	    
        session.setAttribute("uname", "abc");
        
        Map<String, Address> ad =  (Map<String, Address>) emp.get("addr");
        
        List addee = (List) ad.get("itemsRows");

        
        String temp="";

        Employee empl = new Employee();        
        empl.setFirstName(emp.get("firstName") + "");
        empl.setLastName(emp.get("lastName") + "");
        

        List<Address> adrs = new ArrayList<>();
        
        for(int i=0;i<addee.size() ;i++)
        {
        	temp = addee.get(i).toString();
        	
        	temp = temp.replace("{","");
        	temp = temp.replace("}","");
        	            
            List<String> myList = new ArrayList<String>(Arrays.asList(temp.split(", __")));
    
            Address addrs = new Address();
            
            addrs.set__Adrs___hno(myList.get(0).substring(13));
            addrs.set__Adrs___city(myList.get(1).substring(12));
            addrs.set__Adrs___state(myList.get(2).substring(13));
            addrs.setEmployee(empl);
                        
            adrs.add(addrs);

        }

        logger.info(jsessionid + " | \n\n\n***************** This is in NewController(addEmployee_bkp)\n");
                
        rep.addEmployee(empl, adrs);
        
	}
	
	@RequestMapping(value = "/addEmployee")
	public String showEmployeePage(){
		return "addEmployee";
	}
	

	@RequestMapping(path="/api/getEmpByID", method = RequestMethod.POST) 
	public Employee getEmpByID(@RequestBody String eid)
	{

		String jsessionid = RequestContextHolder.currentRequestAttributes().getSessionId(); 
		logger.info(jsessionid + " | \n\n\n***************** This is in getEmpByID(api/getEmpByID)\n");
                

		//ModelAndView modelAndView = new ModelAndView("ShowUser.jsp");
		//try 
		//{
		logger.info(jsessionid + " | ***************** In api/getEmpByID New controller..." + eid);
		//List gUser = rep.findAll();
    	Employee gEmpl = rep.findEmpById(Integer.parseInt(eid));
		List<Employee> gUser = new ArrayList<Employee>();
		gUser.add(gEmpl);


		logger.info(jsessionid + " | ***************** In api/getEmpByID New controller..." + gEmpl.getId());

		

		logger.info(jsessionid + " | ***************** Returning Employee object from (api/getEmpByID)\n");
		return gEmpl;
			
	}
	
	

}
