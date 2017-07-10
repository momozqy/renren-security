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

import io.renren.entity.CtUserEntity;
import io.renren.service.CtUserService;
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
@RequestMapping("ctuser")
public class CtUserController {
	@Autowired
	private CtUserService ctUserService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("ctuser:list")
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<CtUserEntity> ctUserList = ctUserService.queryList(query);
		int total = ctUserService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(ctUserList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{userId}")
	@RequiresPermissions("ctuser:info")
	public R info(@PathVariable("userId") Long userId){
		CtUserEntity ctUser = ctUserService.queryObject(userId);
		
		return R.ok().put("ctUser", ctUser);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	@RequiresPermissions("ctuser:save")
	public R save(@RequestBody CtUserEntity ctUser){
		ctUserService.save(ctUser);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@RequiresPermissions("ctuser:update")
	public R update(@RequestBody CtUserEntity ctUser){
		ctUserService.update(ctUser);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	@RequiresPermissions("ctuser:delete")
	public R delete(@RequestBody Long[] userIds){
		ctUserService.deleteBatch(userIds);
		
		return R.ok();
	}
	
}
