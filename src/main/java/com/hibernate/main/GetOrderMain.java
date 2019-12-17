package com.hibernate.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hibernate.entities.OrderEntity;
import com.hibernate.repositories.OrderRepository;

public class GetOrderMain {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
		OrderRepository odrep = (OrderRepository) context.getBean("orderReprository");
			OrderEntity od= odrep.getById(9l);
			System.out.println(od.toString());
			
			OrderEntity od1= odrep.getbyName1("Shipped");
					System.out.println(od1.toString());
		
	}

}
