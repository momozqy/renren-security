package io.renren.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import io.renren.dao.CtClassLevelDao;
import io.renren.entity.CtClassLevelEntity;
import io.renren.service.CtClassLevelService;



@Service("ctClassLevelService")
public class CtClassLevelServiceImpl implements CtClassLevelService {
	@Autowired
	private CtClassLevelDao ctClassLevelDao;
	
	@Override
	public CtClassLevelEntity queryObject(Integer id){
		return ctClassLevelDao.queryObject(id);
	}
	
	@Override
	public List<CtClassLevelEntity> queryList(Map<String, Object> map){
		return ctClassLevelDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return ctClassLevelDao.queryTotal(map);
	}
	
	@Override
	public void save(CtClassLevelEntity ctClassLevel){
		ctClassLevelDao.save(ctClassLevel);
	}
	
	@Override
	public void update(CtClassLevelEntity ctClassLevel){
		ctClassLevelDao.update(ctClassLevel);
	}
	
	@Override
	public void delete(Integer id){
		ctClassLevelDao.delete(id);
	}
	
	@Override
	public void deleteBatch(Integer[] ids){
		ctClassLevelDao.deleteBatch(ids);
	}
	
}
