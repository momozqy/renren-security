package io.renren.controller;

import io.renren.entity.CtPressEntity;
import io.renren.service.CtPressService;
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
 * @date 2017-07-10 17:20:28
 */
@RestController
@RequestMapping("ctpress")
public class CtPressController {
	@Autowired
	private CtPressService ctPressService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("ctpress:list")
	public R list(@RequestParam Map<String, Object> params){
		List<CtPressEntity> ctPressList;
		//查询列表数据
        if(params==null||params.size()==1){
        	Query nothing = new Query();
			ctPressList = ctPressService.queryList(nothing);
			return R.ok().put("pressList", ctPressList);
		}
		Query query = new Query(params);

		ctPressList = ctPressService.queryList(query);
		int total = ctPressService.queryTotal(query);

		PageUtils pageUtil = new PageUtils(ctPressList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	@RequiresPermissions("ctpress:info")
	public R info(@PathVariable("id") Integer id){
		CtPressEntity ctPress = ctPressService.queryObject(id);
		
		return R.ok().put("ctPress", ctPress);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	@RequiresPermissions("ctpress:save")
	public R save(@RequestBody CtPressEntity ctPress){
		ctPressService.save(ctPress);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@RequiresPermissions("ctpress:update")
	public R update(@RequestBody CtPressEntity ctPress){
		ctPressService.update(ctPress);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	@RequiresPermissions("ctpress:delete")
	public R delete(@RequestBody Integer[] ids){
		ctPressService.deleteBatch(ids);
		
		return R.ok();
	}
	
}
