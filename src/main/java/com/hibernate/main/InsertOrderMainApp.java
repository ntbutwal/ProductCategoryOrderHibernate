package com.hibernate.main;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hibernate.entities.OrderEntity;
import com.hibernate.entities.ProductEntity;
import com.hibernate.repositories.OrderRepository;
import com.hibernate.repositories.ProductRepository;

public class InsertOrderMainApp {
	public static void main(String[]args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
		OrderRepository odrep= (OrderRepository) context.getBean("orderReprository");
		ProductRepository prrep = (ProductRepository) context.getBean("productReprository");
		
		OrderEntity order= new OrderEntity();
		order.setOrderDate(new Date());
		order.setShippingAddress("3025 Virginia Dare Ct");
		order.setStatus("Shipped");
		
		ProductEntity p1= prrep.getByName("Apple Macbook");
		ProductEntity p2= prrep.getByName("Samsung Phone");
		
		ArrayList<ProductEntity> product = new ArrayList<ProductEntity>();
		product.add(p1);
		product.add(p2);
		order.setProductent(product);
		odrep.save(order);
		
	}

}
