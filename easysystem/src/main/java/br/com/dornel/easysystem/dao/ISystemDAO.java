package br.com.dornel.easysystem.dao;

import java.io.Serializable;
import java.util.List;

public interface ISystemDAO<T, PK extends Serializable> {

	void save(T contact);
	
	void update(T contact);
	
	void delete(PK id);
	
	T findById(PK id);
	
	List<T> findByName(String name);
	
	List<T> findAll();

}
