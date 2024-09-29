package com.example.maru.dao;

import java.io.Serializable;
import java.util.List;


public interface CommonDao <T> extends Serializable {

	public List<T> getAll();
	public List<T> getWhereId(String id);
	
}