package io.renren.service;

import io.renren.entity.CtClassEntity;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2017-07-10 09:14:00
 */
public interface CtClassService {
	
	CtClassEntity queryObject(Integer classId);
	
	List<CtClassEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(CtClassEntity ctClass) throws IOException;
	
	void update(CtClassEntity ctClass);
	
	void delete(Integer classId);
	
	void deleteBatch(Integer[] classIds);
}
