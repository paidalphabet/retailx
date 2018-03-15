package com.retailx.service;

import com.retailx.entity.BaseObject;
import com.retailx.entity.PersistableObject;
import com.retailx.spring.dao.CommonDao;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public abstract class AbstractService  implements BaseService{
	

	@Autowired
	private CommonDao basedao;

	@Override
	public Object getObjectByID(Class clazz, long objectID) {
		return basedao.getObjectByID(clazz, objectID);
	}
	
	@Override
	public Object getObjectByID(Class clazz, String objectID) {
		return basedao.getObjectByID(clazz, objectID);
	}
	
	public void save(final BaseObject object){
		basedao.saveBusinessObject(object);
	}

	public BaseObject update(final BaseObject object){
		basedao.updateBusinessObject(object);
		return object;
	}
	
	public void deleteObject(final BaseObject object){
		basedao.deleteObject(object);
	}

	public List<PersistableObject> getObjects(Class clazz) {
		return  basedao.getObjects(clazz);
	}

}
