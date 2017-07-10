package io.renren.service;

import io.renren.entity.CtClassLevelEntity;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2017-07-10 17:20:48
 */
public interface CtClassLevelService {
	
	CtClassLevelEntity queryObject(Integer id);
	
	List<CtClassLevelEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(CtClassLevelEntity ctClassLevel);
	
	void update(CtClassLevelEntity ctClassLevel);
	
	void delete(Integer id);
	
	void deleteBatch(Integer[] ids);
}
