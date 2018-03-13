package com.retailx.service;

import com.retailx.entity.BaseObject;

public interface BaseService {
	
	public Object getObjectByID(final Class clazz, long objectID);
	
	public Object getObjectByID(final Class clazz, String objectID);
	
	public void save(final BaseObject object);
	
	public BaseObject update(final BaseObject object);
	
	public void deleteObject(final BaseObject object);

}
