package com.retailx.spring.dao;

import com.retailx.entity.BaseObject;
import com.retailx.entity.PersistableObject;

import java.util.List;

public interface BaseDao{
	
	public Object getObjectByID(final Class clazz, final long objectID);
	
	public Object getObjectByID(final Class clazz, final String objectID);
	
	public Object updateBusinessObject(final BaseObject object);

	public Object saveBusinessObject(final BaseObject object);
	
	public void deleteObject(final BaseObject object);

    public List<PersistableObject> getObjects(Class clazz);
}
