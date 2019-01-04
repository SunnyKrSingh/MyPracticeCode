package com.nit.encrypt;

import java.util.Base64;
import java.util.Scanner;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class AESEncryptionTest {
	private static final String secKey="aesEncryptionKey";
	private static final String ivector="encryptionIntVec"; 
	
	public static String encrpt(String pwd) throws Exception {
		Cipher cipher=null;
		SecretKeySpec skey=null;
		IvParameterSpec ivspec=null;
		
		//create the SecreateKey object
		skey=new SecretKeySpec(secKey.getBytes("UTF-8"), "AES");
		//create InitVector object
		ivspec=new IvParameterSpec(ivector.getBytes("UTF-8"));
		//get Cipher instance
		cipher=Cipher.getInstance("AES/CBC/PKCS5PADDING");
		//initialize the cipher
		cipher.init(Cipher.ENCRYPT_MODE, skey, ivspec);
		//do the final encrption
		byte[] encrypted=cipher.doFinal(pwd.getBytes());
		return Base64.getEncoder().encodeToString(encrypted);
	}
	
	public static String decrypt(String encrypted) throws Exception {
		Cipher cipher=null;
		SecretKeySpec skey=null;
		IvParameterSpec ivspec=null;
		
		//create the SecreateKey object
		skey=new SecretKeySpec(secKey.getBytes("UTF-8"), "AES");
		//create InitVector object
		ivspec=new IvParameterSpec(ivector.getBytes("UTF-8"));
		//get Cipher instance
		cipher=Cipher.getInstance("AES/CBC/PKCS5PADDING");
		//initialize the cipher
		cipher.init(Cipher.DECRYPT_MODE, skey, ivspec);
		//do the final encrption
		byte[] decoded=cipher.doFinal(Base64.getDecoder().decode(encrypted));
		return new String(decoded);
	}

	public static void main(String[] args)throws Exception {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter password ::");
		String pwd=sc.next();
		System.out.println("Originol password ::"+pwd);
		String encryptedValue=encrpt(pwd);
		System.out.println("Encrypted Password ::"+encrpt(encryptedValue));
		System.out.println("============================================");
		String decryptedValue=decrypt(encryptedValue);
		System.out.println("After Decryption ::"+decryptedValue);

	}

}
