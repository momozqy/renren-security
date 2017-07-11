package io.renren.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import io.renren.dao.CtGradeDao;
import io.renren.entity.CtGradeEntity;
import io.renren.service.CtGradeService;



@Service("ctGradeService")
public class CtGradeServiceImpl implements CtGradeService {
	@Autowired
	private CtGradeDao ctGradeDao;
	
	@Override
	public CtGradeEntity queryObject(Integer id){
		return ctGradeDao.queryObject(id);
	}
	
	@Override
	public List<CtGradeEntity> queryList(Map<String, Object> map){
		return ctGradeDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return ctGradeDao.queryTotal(map);
	}
	
	@Override
	public void save(CtGradeEntity ctGrade){
		ctGradeDao.save(ctGrade);
	}
	
	@Override
	public void update(CtGradeEntity ctGrade){
		ctGradeDao.update(ctGrade);
	}
	
	@Override
	public void delete(Integer id){
		ctGradeDao.delete(id);
	}
	
	@Override
	public void deleteBatch(Integer[] ids){
		ctGradeDao.deleteBatch(ids);
	}
	
}
