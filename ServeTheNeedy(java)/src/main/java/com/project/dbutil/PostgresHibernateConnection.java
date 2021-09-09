package com.project.dbutil;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class PostgresHibernateConnection {
	public static Session getSession() {
		SessionFactory sf=new Configuration().configure("hiberanate.cfg.xml")
				.buildSessionFactory();
		Session session=sf.openSession();
		return session;
	}
}
