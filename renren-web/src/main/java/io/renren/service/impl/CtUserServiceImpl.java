package io.renren.service.impl;

import io.renren.dao.CtUserDao;
import io.renren.entity.CtUserEntity;
import io.renren.service.CtUserService;
import io.renren.utils.EncryptUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
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
	public void saveBatch(String userListStr,boolean isVip) {
		String[] userStrs = userListStr.split("\n");
		List<CtUserEntity> userList = new ArrayList<>();
		List<CtUserEntity> userUpdateList = new ArrayList<>();
		for (int i=0;i<userStrs.length;i++){
			if (!EncryptUtils.isMobileNO(userStrs[i]))
				continue;
			CtUserEntity user = new CtUserEntity();
			user.setMobile(userStrs[i]);
			user.setRegTime(new Date());
			user.setActiveTime(new Date());
			user.setUserName(userStrs[i]);
			user.setNickname(userStrs[i]);
			user.setStatus(2);
			user.setType(isVip?2:1);
			user.setPassword(EncryptUtils.getMD5(userStrs[i]));
			if(ctUserDao.queryByUser(user)!=null)
				userUpdateList.add(user);
			else {
					userList.add(user);
			}
		}
		if(isVip&&userList.size()!=0)
			ctUserDao.saveBatch(userList);
		if(userUpdateList.size()!=0)
			ctUserDao.updateUserTypeBatch(userUpdateList);
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
