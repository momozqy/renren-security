package io.renren.service;

import io.renren.entity.CtUserEntity;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2017-07-10 17:20:28
 */
public interface CtUserService {
	
	CtUserEntity queryObject(Long userId);
	
	List<CtUserEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(CtUserEntity ctUser);

	void saveBatch(String userListStr);
	
	void update(CtUserEntity ctUser);
	
	void delete(Long userId);
	
	void deleteBatch(Long[] userIds);
}
