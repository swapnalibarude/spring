package com.bookapp.model.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class BookDaoImplHib implements BookDao {
	private SessionFactory factory;
	

	public BookDaoImplHib() {
		factory = HibernateConnectionFactory.getSessionFactory();
	}

	@Override
	public List<Book> getAll() {
		Session session=factory.openSession();
		List<Book>books=session.createQuery("select b from Book b",Book.class).getResultList();
		session.close();
		return books;
	}

	@Override
	public void addBook(Book book) {
		Session session=factory.openSession();
		Transaction tx=session.getTransaction();
		try {
			tx.begin();
			session.save(book);
			tx.commit();
		} catch (HibernateException ex) {
			
		}
		session.close();
	}

	@Override
	public Book delBook(int id) {
		
		return null;
	}

	@Override
	public Book updateBook(int id, double price) {
	
		return null;
	}

	@Override
	public Book getBookById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
