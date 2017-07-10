package io.renren.service;

import io.renren.entity.CtPressEntity;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2017-07-10 17:20:28
 */
public interface CtPressService {
	
	CtPressEntity queryObject(Integer id);
	
	List<CtPressEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(CtPressEntity ctPress);
	
	void update(CtPressEntity ctPress);
	
	void delete(Integer id);
	
	void deleteBatch(Integer[] ids);
}
