package com.hibernate.main;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hibernate.entities.CategoryEntity;
import com.hibernate.entities.OrderEntity;
import com.hibernate.entities.ProductEntity;
import com.hibernate.repositories.OrderRepository;

public class InsertMainApp {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
		OrderRepository order = (OrderRepository) context.getBean("orderReprository");

		CategoryEntity ct = new CategoryEntity();
		ct.setName("Electronics");
		ct.setDescription("All Electronics Product");

		OrderEntity od = new OrderEntity();
		od.setOrderDate(new Date());
		od.setShippingAddress("3025 Virginia Dare Ct");
		od.setStatus("Shipped");

		ProductEntity pd = new ProductEntity();
		pd.setName("Iphone");
		pd.setDescription("This is latest iphone 11promax");
		

		ProductEntity pd1 = new ProductEntity();
		pd1.setName("Macbook");
		pd1.setDescription("This is latest macbook 16inch promax");

		pd.setCategory(ct);
		ArrayList<ProductEntity> product = new ArrayList<ProductEntity>();
		product.add(pd);
		product.add(pd1);
		od.setProductent(product);
		order.save(od);

	}

}
