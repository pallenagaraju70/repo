package com.example.demo.Service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.IntStream;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.EmailUtils.EmailUtils;
import com.example.demo.Entity.CityMasterEntity;
import com.example.demo.Entity.CountryMasterEntity;
import com.example.demo.Entity.StateMasterEntity;
import com.example.demo.Entity.UserDataEntity;
import com.example.demo.Repository.CityRepository;
import com.example.demo.Repository.CountryRepository;
import com.example.demo.Repository.StateRepository;
import com.example.demo.Repository.UserRepository;
import com.example.demo.bindings.LoginFrom;
import com.example.demo.bindings.UnlockForm;
import com.example.demo.bindings.UserRegistrationForm;

@Service
public class UserManagmenetServiceImpl implements UserManagingService {

	@Autowired
	private UserRepository userrepo;
	
	@Autowired
	private CountryRepository countryrepo;
	
	@Autowired
	private StateRepository staterepo;
	
	@Autowired
	private CityRepository cityrepo;
	
	@Autowired
	private EmailUtils emailutils;
	
	@Override
	public String login(LoginFrom login) {
		
		UserDataEntity entity =userrepo.findByEmailAndPassword(login.getEmail(), login.getPassword());
		
		if (entity == null)
		{
			return "INVALID CREDENTIALS";
		}
		if(entity != null && entity.getAccstatus().equals("LOCKED"))
		{
			return "Your Account Is Locked";
		}
		return "WELCOME TO FULLSTACK PROJECT FAMILY";
	}

	@Override
	public String EmailCheckup(String email) {
	
		UserDataEntity entity = userrepo.findByEmail(email);
		
		if(entity == null)
		{
		 return "Unique";	
		}
		return "Duplicate";
	}

	@Override
	public Map<Integer, String> loadCountries() {
	List<CountryMasterEntity> countries = countryrepo.findAll();
	Map<Integer, String> countryMap = new HashMap();
	for(CountryMasterEntity entity:countries) {
		countryMap.put(entity.getCountryId(), entity.getCountryName());
	}
		return countryMap;
	}

	@Override
	public Map<Integer, String> loadStates(Integer CountryId) {
		List<StateMasterEntity> states = staterepo.findAll();
		Map<Integer, String> stateMap = new HashMap();
		for(StateMasterEntity entity:states) {
			stateMap.put(entity.getStateId(), entity.getStateName());
		}
		return stateMap;
	}

	@Override
	public Map<Integer, String> loadCities(Integer StateId) {
		List<CityMasterEntity> cities = cityrepo.findAll();
		Map<Integer, String> cityMap = new HashMap();
		for(CityMasterEntity entity:cities) {
			cityMap.put(entity.getCityId(), entity.getCityName());
		}
		return null;
	}

	@Override
	public String UserRegisteration(UserRegistrationForm user) {
	
		UserDataEntity entity = new UserDataEntity();
		
		BeanUtils.copyProperties(user, entity);
		
		entity.setAccstatus("LOCKED");
		
		entity.setPassword(GenerateRandomString());
		
		UserDataEntity entitysaved = userrepo.save(entity);
		
		String email = entitysaved.getEmail();
		String subject ="User Registration -Ashok IT";
		String fileName = "UNLOCK-ACC-EMAIL-BODY.txt";
		String body = readMailBodyContent(fileName, entity);
		
		boolean isSent = emailutils.sendEmail(email, subject, body);
		
		if(entitysaved!=null && isSent)
		{
			return "SUCCESS";
			
		}
		return "Fail";
	}

	private String readMailBodyContent(String fileName, UserDataEntity entity) {
		
		String mailBody = null;
		try {
		StringBuffer sb = new StringBuffer();
		
		FileReader fr = new FileReader(fileName);
		
		BufferedReader br = new BufferedReader(fr);    
		
		String readline =br.readLine();
		
		while(readline != null) {
			sb.append(readline);
			readline = br.readLine();
		}
		
		mailBody = sb.toString();
		
		mailBody = mailBody.replace("{FNAME}", entity.getFirstName());
		mailBody = mailBody.replace("{LNAME}", entity.getLastName());
		mailBody = mailBody.replace("{TEMP-PWD}", entity.getPassword());
		mailBody = mailBody.replace("{EMAIL}", entity.getEmail());
		mailBody = mailBody.replace("{PWD}", entity.getPassword());
		
		br.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return mailBody;
	}

	private String GenerateRandomString() {
		int leftlimit = 40;
		int rightlimit = 90;
		int targetStringLength = 8;
		Random random = new Random();

		String generaterandom = random.ints(leftlimit, rightlimit + 1)

				.filter(i -> (i <= 50 || i >= 90) && (i <= 90 || i >= 98)).limit(targetStringLength)
				.collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).toString();

		return generaterandom;
	}

	@Override
	public String UnlockAccount(UnlockForm unlock) {
		
		UserDataEntity entity = userrepo.findByEmailAndPassword(unlock.getEmail(), unlock.getTemppwd());
		
		if(entity == null)
		{
			return "Invalid EmailId";
			
		}
		entity.setAccstatus("UNLOCKED");
		entity.setPassword(unlock.getNewpassword());
		
		userrepo.save(entity);
		return "ACCOUNT UNLOCKED";
	}

	@Override
	public String Forgetpassword(String email) {
		UserDataEntity entity = userrepo.findByEmail(email);
		
		if(entity == null)
		{
			return "Invalid EmailId";
		}
		
		String subject ="User Registration -Ashok IT";
		String fileName = "RECOVER-PASSWORD-EMAIL-BODY.txt";
		String body = readMailBodyContent(fileName, entity);
		
		boolean isSent = emailutils.sendEmail(email, subject, body);
		if(isSent) {
		return "RECOVER PASSWORD SEND TO YOUR EMAIL";
		}
		return "error";
	}

}
