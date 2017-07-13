package io.renren.controller;

import io.renren.entity.CtClassEntity;
import io.renren.service.CtClassService;
import io.renren.utils.PageUtils;
import io.renren.utils.Query;
import io.renren.utils.R;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
@RestController
@RequestMapping("ctclass")
public class CtClassController {
	@Autowired
	private CtClassService ctClassService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("ctclass:list")
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<CtClassEntity> ctClassList = ctClassService.queryList(query);
		int total = ctClassService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(ctClassList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{classId}")
	@RequiresPermissions("ctclass:info")
	public R info(@PathVariable("classId") Integer classId){
		CtClassEntity ctClass = ctClassService.queryObject(classId);
		
		return R.ok().put("ctClass", ctClass);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	@RequiresPermissions("ctclass:save")
	public R save(CtClassEntity ctClass) throws IOException{
		//文件处理
		ctClassService.save(ctClass);
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@RequiresPermissions("ctclass:update")
	public R update(CtClassEntity ctClass){
		ctClassService.update(ctClass);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	@RequiresPermissions("ctclass:delete")
	public R delete(@RequestBody Integer[] classIds){
		ctClassService.deleteBatch(classIds);
		
		return R.ok();
	}
	
}
