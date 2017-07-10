package io.renren.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import io.renren.dao.CtPressDao;
import io.renren.entity.CtPressEntity;
import io.renren.service.CtPressService;



@Service("ctPressService")
public class CtPressServiceImpl implements CtPressService {
	@Autowired
	private CtPressDao ctPressDao;
	
	@Override
	public CtPressEntity queryObject(Integer id){
		return ctPressDao.queryObject(id);
	}
	
	@Override
	public List<CtPressEntity> queryList(Map<String, Object> map){
		return ctPressDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return ctPressDao.queryTotal(map);
	}
	
	@Override
	public void save(CtPressEntity ctPress){
		ctPressDao.save(ctPress);
	}
	
	@Override
	public void update(CtPressEntity ctPress){
		ctPressDao.update(ctPress);
	}
	
	@Override
	public void delete(Integer id){
		ctPressDao.delete(id);
	}
	
	@Override
	public void deleteBatch(Integer[] ids){
		ctPressDao.deleteBatch(ids);
	}
	
}
