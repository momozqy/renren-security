package io.renren.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import io.renren.dao.CtUserDao;
import io.renren.entity.CtUserEntity;
import io.renren.service.CtUserService;



@Service("ctUserService")
public class CtUserServiceImpl implements CtUserService {
	@Autowired
	private CtUserDao ctUserDao;
	
	@Override
	public CtUserEntity queryObject(Long userId){
		return ctUserDao.queryObject(userId);
	}
	
	@Override
	public List<CtUserEntity> queryList(Map<String, Object> map){
		return ctUserDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return ctUserDao.queryTotal(map);
	}
	
	@Override
	public void save(CtUserEntity ctUser){
		ctUserDao.save(ctUser);
	}
	
	@Override
	public void update(CtUserEntity ctUser){
		ctUserDao.update(ctUser);
	}
	
	@Override
	public void delete(Long userId){
		ctUserDao.delete(userId);
	}
	
	@Override
	public void deleteBatch(Long[] userIds){
		ctUserDao.deleteBatch(userIds);
	}
	
}
