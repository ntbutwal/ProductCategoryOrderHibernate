package com.hibernate.repositories;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.hibernate.entities.OrderEntity;
import com.hibernate.entities.ProductEntity;

public class OrderRepository {

	private SessionFactory factory;

	public void save(OrderEntity order) {
		Session session = factory.openSession();
		session.beginTransaction();
		session.save(order);
		session.getTransaction().commit();
		session.close();
	}

	public OrderEntity getById(Long orderId) {
		Session session = factory.openSession();
		session.beginTransaction();

		OrderEntity ord = (OrderEntity) session.get(OrderEntity.class, orderId);

		session.getTransaction().commit();
		session.close();

		return ord;
	}
	
	public OrderEntity getbyName1(String status) {
		Session session =factory.openSession();
		session.beginTransaction();
		String hql="select o from OrderEntity o where o.status = status";
		Query query = session.createQuery(hql);
		query.setParameter("status", status);
		OrderEntity ordd= (OrderEntity) query.uniqueResult();
		session.getTransaction().commit();
		session.close();
		return ordd;
	}

	public SessionFactory getFactory() {
		return factory;
	}

	public void setFactory(SessionFactory factory) {
		this.factory = factory;
	}

}
