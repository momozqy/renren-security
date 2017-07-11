package io.renren.controller;

import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.renren.entity.CtGradeEntity;
import io.renren.service.CtGradeService;
import io.renren.utils.PageUtils;
import io.renren.utils.Query;
import io.renren.utils.R;


/**
 * 
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2017-07-11 16:22:58
 */
@RestController
@RequestMapping("ctgrade")
public class CtGradeController {
	@Autowired
	private CtGradeService ctGradeService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("ctgrade:list")
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<CtGradeEntity> ctGradeList = ctGradeService.queryList(query);
		int total = ctGradeService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(ctGradeList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	@RequiresPermissions("ctgrade:info")
	public R info(@PathVariable("id") Integer id){
		CtGradeEntity ctGrade = ctGradeService.queryObject(id);
		
		return R.ok().put("ctGrade", ctGrade);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	@RequiresPermissions("ctgrade:save")
	public R save(@RequestBody CtGradeEntity ctGrade){
		ctGradeService.save(ctGrade);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@RequiresPermissions("ctgrade:update")
	public R update(@RequestBody CtGradeEntity ctGrade){
		ctGradeService.update(ctGrade);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	@RequiresPermissions("ctgrade:delete")
	public R delete(@RequestBody Integer[] ids){
		ctGradeService.deleteBatch(ids);
		
		return R.ok();
	}
	
}
