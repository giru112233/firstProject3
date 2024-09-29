package com.example.maru.dao;


import java.util.List;

import jakarta.persistence.EntityManager;

import com.example.maru.entity.ServiceUserEnitity;


public class ServiceUserDao implements CommonDao<ServiceUserEnitity>{
	
	private EntityManager entityManager;
	

	@Override
	public List<ServiceUserEnitity> getAll() {
//		entityManager.findAll();
		
		return null;
	}

	@Override
	public List<ServiceUserEnitity> getWhereId(String id) {
//		entityManager.
		return null;
	}



}