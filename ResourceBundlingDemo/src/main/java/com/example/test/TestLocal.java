package com.example.test;

import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.MessageSource;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.ResourceBundleMessageSource;

public class TestLocal {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("springconfig.xml");
		Scanner sc = new Scanner(System.in);
		int ch=0;
		do {
			System.out.println("1. US Englist \n2. UK English \n3. Marathi \n4. other \n5. Exit");
			System.out.println("Select language");
			ch = sc.nextInt();
			MessageSource ms = (MessageSource)ctx.getBean(ResourceBundleMessageSource.class);
			String m =null, w=null, d=null, c=null;
			Locale local = null;
			switch (ch) {
			case 1:
				local = Locale.US;
				System.out.println("Country: "+local.getCountry()+"Language: "+local.getLanguage());
				break;
			case 2:
				local = Locale.UK;
				System.out.println("Country: "+local.getCountry()+"Language: "+local.getLanguage());
				break;
			case 3:
				local = new Locale("my", "marathi");
				System.out.println("Country: " +local.getCountry()+ "Language: " +local.getLanguage());
			case 4:
				local = new Locale("aa", "test");
				break;
			case 5:
				System.out.println("Thank you for visiting...");
				sc.close();
				break;
			default:
				System.out.println("Wrong choice enter right choice: ");
				break;
			}
			m=ms.getMessage("msg.pay",null, local);
			w=ms.getMessage("msg.welcome",new Object[] {"Kishori"}, local);
			d=ms.getMessage("msg.data",null, local);
			c=ms.getMessage("msg.currency",null, local);
			System.out.println("pay : "+m);
			System.out.println("Welcome : "+w);
			System.out.println("data : "+d);
			System.out.println("currency : "+c);
		}while(ch!=5);

	}

}
