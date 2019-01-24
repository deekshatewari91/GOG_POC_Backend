package com.example.demo.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.request.RequestContextHolder;

import com.example.demo.dao.EmployeeRepo;
import com.example.demo.dao.LoginRepo;
import com.example.demo.dao.UserRepo;
import com.example.demo.exception.ApplicationError;
import com.example.demo.exception.GOGException;

@Service
public class MainServiceImpl implements MainService {
	
	ch.qos.logback.classic.Logger logger =  (ch.qos.logback.classic.Logger) LoggerFactory.getLogger(MainServiceImpl.class);

	
	
	@Autowired
	private UserRepo repos;
	@Autowired
	private LoginRepo logrepos;
	@Autowired
	private EmployeeRepo emplRepos;

	@Override
	public String create(User user) throws GOGException{
		String jsessionid = RequestContextHolder.currentRequestAttributes().getSessionId(); 
		
		logger.info(jsessionid + "***************** in create() of MainServiceImpl...");
			if (user.getContact() > 999999999L && user.getContact() < 10000000000L) {
				repos.save(user);
				return "success";
			} else {
				ApplicationError error=new ApplicationError("123","Error while creating the user, Invaild contact number.","HIGH");
				throw new GOGException(error);
			}

	}

	@Override
	public HashMap<String, String> login(String login) {
		// String message = "";
		HashMap<String, String> map = new HashMap<String, String>();
		String jsessionid = RequestContextHolder.currentRequestAttributes().getSessionId(); 
		
		logger.info(jsessionid + "Inside login MainServiceImpl");
		try {
			List<Login> logList = (List<Login>) logrepos.findAll();
			for (Login l : logList) {
				if (login.equals(l.getUsername())) {
					map.put("user", l.getUser());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			map.put("error", "error");
		}
		return map;
	}

	@Override
	public User findUser(int uid) {
		String jsessionid = RequestContextHolder.currentRequestAttributes().getSessionId(); 
		
		logger.info(jsessionid + "***************** in findUser() of MainServiceImpl...");
		User user1 = repos.findById(uid).orElse(new User());

		return user1;

	}

	@Override
	public List<String> findAllFirstName() {
		String jsessionid = RequestContextHolder.currentRequestAttributes().getSessionId(); 
		
		logger.info(jsessionid + "***************** in findAllFirstName of MainServiceImpl...");
		List<String> listFname = new ArrayList<String>();
		List<User> listUser = (List<User>) repos.findAll();
		for (User a : listUser) {
			listFname.add(a.getFirstname());
		}

		return listFname;
	}

	@Override
	public String deleteUser(int id) {
		String jsessionid = RequestContextHolder.currentRequestAttributes().getSessionId(); 
	
		logger.info(jsessionid + "***************** in deleteUser of MainServiceImpl...");
		repos.deleteById(id);

		User verifyUser = findUser(id);
		if ((verifyUser.getFirstname() + "").equals("null")) {
			return "Success : User " + id + " is deleted.";
		} else
			return "Error";
	}

	@Override
	public List<User> findAll() {
		String jsessionid = RequestContextHolder.currentRequestAttributes().getSessionId(); 
		logger.info(jsessionid + "***************** in findAll of MainServiceImpl...");
		return (List<User>) repos.findAll();
	}

	@Override
	public void updateStatus(List<User> users) {
		String jsessionid = RequestContextHolder.currentRequestAttributes().getSessionId(); 
		logger.info(jsessionid + "***************** in updateStatus of MainServiceImpl...");
		repos.saveAll(users);

	}

	@Override
	public List<User> findUserbyStatus(boolean stat) {
		String jsessionid = RequestContextHolder.currentRequestAttributes().getSessionId(); 
		logger.info(jsessionid + "***************** in findUserbyStatus of MainServiceImpl...");
		// logger.info("\n\n\n***************** This is in in findUserbyStatus ..\n");
		return repos.findByStatus(stat);

	}

	@Override
	@Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED, readOnly = false, timeout = 100, rollbackFor = Exception.class)
	public void addEmployee(Employee emp, List<Address> addr) {
		String jsessionid = RequestContextHolder.currentRequestAttributes().getSessionId(); 

		logger.info(jsessionid + "***************** in addEmployee of MainServiceImpl...");
		// logger.info("\n\n\n***************** This is in in addEmployee...........
		// ..\n");
		emp.setAddr(addr);

		emplRepos.save(emp);

	}

	@Override
	public Employee findEmpById(int eid) {

		// logger.info("\n\n\n***************** This is in in findEmpById...........
		// ..\n");
		Employee empl = new Employee();
		String jsessionid = RequestContextHolder.currentRequestAttributes().getSessionId(); 
		logger.info(jsessionid + "| ***************** in findEmpById() of MainServiceImpl..." + eid);
		try {

			List<Address> addr = emplRepos.findById(eid).get(0).getAddr();

			empl.setId(eid);
			empl.setFirstName(emplRepos.findById(eid).get(0).getFirstName());
			empl.setLastName(emplRepos.findById(eid).get(0).getLastName());

			// empl.setAddr(emplRepos.findById(eid).get(0).getAddr());

			Address a = null;
			System.out.println("***************** Employee : " + empl);
			List<Address> addrs = new ArrayList<>();
			for (Address adrs : addr) {
				a = new Address();
				a.set__Adrs___hno(adrs.get__Adrs___hno());
				a.set__Adrs___city(adrs.get__Adrs___city());
				a.set__Adrs___state(adrs.get__Adrs___state());
				addrs.add(a);
				System.out.println("***************** Address List: " + addrs);

			}

			empl.setAddr(addrs);

		} catch (Exception ex) {
			logger.info(jsessionid + "***************** in Catch of findEmpById() of MainServiceImpl..." + eid + "..."
					+ ex.getMessage());

		}

		return empl;
	}

}
