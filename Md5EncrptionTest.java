package com.nit.encrypt;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Scanner;

public class Md5EncrptionTest {
	
	public static String encrypt(String pwd) throws NoSuchAlgorithmException {
		String encrypted=null;
		MessageDigest md=null;
		//get digest instance
		md=MessageDigest.getInstance("SHA-1");
		md.reset(); //for removing previous data
		md.update(pwd.getBytes());//for updating our password
		byte[] src=md.digest(); //convert into encrypted format
		//converting byte[] into String format
		encrypted=Base64.getEncoder().encodeToString(src);
		return encrypted;
	}
	
	public static void main(String[] args) throws Exception{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter password ::");
		String pwd=sc.next();
		//invoking the method
		System.out.println("Origianl Password::"+pwd);
		System.out.println("Encryped password::"+encrypt(pwd));

	}

}
