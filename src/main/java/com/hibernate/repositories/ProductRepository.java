package com.hibernate.repositories;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.hibernate.entities.ProductEntity;

public class ProductRepository {

	private SessionFactory factory;

	public ProductEntity getByName(String name) {
		Session session = factory.openSession();
		session.beginTransaction();
		String hql = "select p from ProductEntity p where p.name =:name";
		Query query = session.createQuery(hql);
		query.setParameter("name", name);
		List<ProductEntity> pro = query.list();
		session.getTransaction().commit();
		session.close();
		return pro.get(0);

	}

	public SessionFactory getFactory() {
		return factory;
	}

	public void setFactory(SessionFactory factory) {
		this.factory = factory;
	}

}
