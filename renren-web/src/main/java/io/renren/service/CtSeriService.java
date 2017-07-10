package io.renren.service;

import io.renren.entity.CtSeriEntity;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2017-07-10 17:20:28
 */
public interface CtSeriService {
	
	CtSeriEntity queryObject(Integer seriId);
	
	List<CtSeriEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(CtSeriEntity ctSeri);
	
	void update(CtSeriEntity ctSeri);
	
	void delete(Integer seriId);
	
	void deleteBatch(Integer[] seriIds);
}
