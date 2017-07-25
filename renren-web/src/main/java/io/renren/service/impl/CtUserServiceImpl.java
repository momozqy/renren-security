package io.renren.service.impl;

import io.renren.dao.CtUserDao;
import io.renren.entity.CtUserEntity;
import io.renren.service.CtUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;



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
	public void saveBatch(String userListStr) {
		List<CtUserEntity> userList = new ArrayList<>();
		System.out.println(userListStr);
	//	ctUserDao.saveBatch(userList);
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
