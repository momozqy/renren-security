package io.renren.service;

import io.renren.entity.CtGradeEntity;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2017-07-11 16:22:58
 */
public interface CtGradeService {
	
	CtGradeEntity queryObject(Integer id);
	
	List<CtGradeEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(CtGradeEntity ctGrade);
	
	void update(CtGradeEntity ctGrade);
	
	void delete(Integer id);
	
	void deleteBatch(Integer[] ids);
}
