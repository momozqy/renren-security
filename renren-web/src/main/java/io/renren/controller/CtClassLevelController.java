package io.renren.controller;

import io.renren.entity.CtClassLevelEntity;
import io.renren.service.CtClassLevelService;
import io.renren.utils.PageUtils;
import io.renren.utils.Query;
import io.renren.utils.R;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


/**
 * 
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2017-07-10 17:20:48
 */
@RestController
@RequestMapping("ctclasslevel")
public class CtClassLevelController {
	@Autowired
	private CtClassLevelService ctClassLevelService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("ctclasslevel:list")
	public R list(@RequestParam Map<String, Object> params){
		if(params==null||params.size()==1){
			Query nothing = new Query();
			List<CtClassLevelEntity> list = ctClassLevelService.queryList(nothing);
			return R.ok().put("classLevelList",list);
		}
		//查询列表数据
        Query query = new Query(params);

		List<CtClassLevelEntity> ctClassLevelList = ctClassLevelService.queryList(query);
		int total = ctClassLevelService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(ctClassLevelList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	@RequiresPermissions("ctclasslevel:info")
	public R info(@PathVariable("id") Integer id){
		CtClassLevelEntity ctClassLevel = ctClassLevelService.queryObject(id);
		
		return R.ok().put("ctClassLevel", ctClassLevel);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	@RequiresPermissions("ctclasslevel:save")
	public R save(@RequestBody CtClassLevelEntity ctClassLevel){
		ctClassLevelService.save(ctClassLevel);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@RequiresPermissions("ctclasslevel:update")
	public R update(@RequestBody CtClassLevelEntity ctClassLevel){
		ctClassLevelService.update(ctClassLevel);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	@RequiresPermissions("ctclasslevel:delete")
	public R delete(@RequestBody Integer[] ids){
		ctClassLevelService.deleteBatch(ids);
		
		return R.ok();
	}
	
}
