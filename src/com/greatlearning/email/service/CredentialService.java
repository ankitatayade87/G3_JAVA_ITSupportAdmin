package com.greatlearning.email.service;
import java.util.Random;

import com.greatlearning.email.model.Employee;

public class CredentialService implements ICredentialService {
	private String upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	private String lower = "abcdefghijklmnopqrstuvwxyz";
	private String number ="0123456789";
	private String spl = "!@#$%^&*()_+?=-";
	private String passwordChars = upper + lower + number + spl;
	Random random = new Random();
			
	@Override
	public void generateEmail(Employee employee) {
		// TODO Auto-generated method stub
		String emailAddress = employee.getFirstName()+employee.getLastName()+"@"+employee.getDepartment()+".gl.in";
		employee.setEmailAddress(emailAddress);
				
		
	}

	@Override
	public void generatePassword(Employee employee) {
		// TODO Auto-generated method stub
		String password = "";
		for(int i = 0; i < 8; i++)
		{
			password = password + passwordChars.charAt(random.nextInt(passwordChars.length()));
		}
		employee.setPassword(password);
		
	}

	@Override
	public void showCredentials(Employee employee) {
		// TODO Auto-generated method stub
		System.out.println("Dear "+employee.getFirstName()+" your generated credentials are as follows:\n"
				+"Email\t --->"+ employee.getEmailAddress()+ "\nPassword --->" +employee.getPassword());
	}

	
}
