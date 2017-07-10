package io.renren.service.impl;

import io.renren.dao.CtClassDao;
import io.renren.entity.CtClassEntity;
import io.renren.service.CtClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;



@Service("ctClassService")
public class CtClassServiceImpl implements CtClassService {
	@Autowired
	private CtClassDao ctClassDao;
	
	@Override
	public CtClassEntity queryObject(Integer classId){
		return ctClassDao.queryObject(classId);
	}
	
	@Override
	public List<CtClassEntity> queryList(Map<String, Object> map){
		return ctClassDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return ctClassDao.queryTotal(map);
	}
	
	@Override
	public void save(CtClassEntity ctClass){
		ctClassDao.save(ctClass);
	}
	
	@Override
	public void update(CtClassEntity ctClass){
		ctClassDao.update(ctClass);
	}
	
	@Override
	public void delete(Integer classId){
		ctClassDao.delete(classId);
	}
	
	@Override
	public void deleteBatch(Integer[] classIds){
		ctClassDao.deleteBatch(classIds);
	}
	
}
