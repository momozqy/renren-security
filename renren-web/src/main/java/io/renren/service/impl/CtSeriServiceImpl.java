package io.renren.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import io.renren.dao.CtSeriDao;
import io.renren.entity.CtSeriEntity;
import io.renren.service.CtSeriService;



@Service("ctSeriService")
public class CtSeriServiceImpl implements CtSeriService {
	@Autowired
	private CtSeriDao ctSeriDao;
	
	@Override
	public CtSeriEntity queryObject(Integer seriId){
		return ctSeriDao.queryObject(seriId);
	}
	
	@Override
	public List<CtSeriEntity> queryList(Map<String, Object> map){
		return ctSeriDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return ctSeriDao.queryTotal(map);
	}
	
	@Override
	public void save(CtSeriEntity ctSeri){
		ctSeriDao.save(ctSeri);
	}
	
	@Override
	public void update(CtSeriEntity ctSeri){
		ctSeriDao.update(ctSeri);
	}
	
	@Override
	public void delete(Integer seriId){
		ctSeriDao.delete(seriId);
	}
	
	@Override
	public void deleteBatch(Integer[] seriIds){
		ctSeriDao.deleteBatch(seriIds);
	}
	
}
