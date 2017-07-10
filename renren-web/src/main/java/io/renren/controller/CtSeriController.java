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

import io.renren.entity.CtSeriEntity;
import io.renren.service.CtSeriService;
import io.renren.utils.PageUtils;
import io.renren.utils.Query;
import io.renren.utils.R;


/**
 * 
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2017-07-10 17:20:28
 */
@RestController
@RequestMapping("ctseri")
public class CtSeriController {
	@Autowired
	private CtSeriService ctSeriService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("ctseri:list")
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<CtSeriEntity> ctSeriList = ctSeriService.queryList(query);
		int total = ctSeriService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(ctSeriList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{seriId}")
	@RequiresPermissions("ctseri:info")
	public R info(@PathVariable("seriId") Integer seriId){
		CtSeriEntity ctSeri = ctSeriService.queryObject(seriId);
		
		return R.ok().put("ctSeri", ctSeri);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	@RequiresPermissions("ctseri:save")
	public R save(@RequestBody CtSeriEntity ctSeri){
		ctSeriService.save(ctSeri);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@RequiresPermissions("ctseri:update")
	public R update(@RequestBody CtSeriEntity ctSeri){
		ctSeriService.update(ctSeri);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	@RequiresPermissions("ctseri:delete")
	public R delete(@RequestBody Integer[] seriIds){
		ctSeriService.deleteBatch(seriIds);
		
		return R.ok();
	}
	
}
