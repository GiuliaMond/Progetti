package com.perigea.progettohibernate.dao;

import org.hibernate.Query;

import com.perigea.progettohibernate.entity.Autore;

public class AutoreDao extends GenericDao{
	
	public void save(Autore autore) {
		
		getCurrentSession().save(autore);
	}
	
	public Autore get(int id) {
		return (Autore) getCurrentSession().get(Autore.class, id);
	}
	
	public void update(Autore autore) {
		//...
	}
	
	public void delete(int id) {
		//...
	}

	/*
	public Autore getByName(String nome) {
		Query query= getCurrentSession().createSQLQuery("select * from autore where name="+nome);
		//query.getFirstResult();
	}
	*/
}
