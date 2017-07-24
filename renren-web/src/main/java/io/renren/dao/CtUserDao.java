package io.renren.dao;

import io.renren.entity.CtUserEntity;

import java.util.List;

/**
 * 
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2017-07-10 17:20:28
 */
public interface CtUserDao extends BaseDao<CtUserEntity> {
	public int addUsersBatch(List<CtUserEntity> users);
}
