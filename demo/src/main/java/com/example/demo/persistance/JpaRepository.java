package com.example.demo.persistance;

import java.util.List;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

@NoRepositoryBean
public interface JpaRepository<T, ID> extends PagingAndSortingRepository<T,ID>, QueryByExampleExecutor<T>{ 

	List<T> findAll();
	
	List<T> findAll(Sort var1);
	
	List<T> finaAllById(Iterable<ID> var1);
	
	<S extends T> List<S> saveAll(Iterable<S> var1);
	
	void flush();
	
	<S extends T> S saveAndFlush(S var1);
	
	void deleteInBatch(Iterable<T> var1);
	
	void deleteAllInBatch();
	
	T getOne(ID var1);
	
	<S extends T> List<S> findAll(Example<S> var1);
	
	<S extends T> List<S> findAll(Example<S> var1, Sort var2);
	
	
}
