package com.vteba.common.service.impl;

import java.io.Serializable;
import java.util.List;

import com.vteba.common.dao.BaseDao;
import com.vteba.common.service.BaseService;

/**
 * MyBatis通用泛型Service实现，简化service的实现。其实有了代码生成工具，可以不需要的。
 * 
 * @author yinlei
 * @see
 * @since 2015年4月23日 下午3:45:54
 * @param <T> 泛型实体类
 * @param <Q> 复杂查询类
 * @param <ID> 主键类型
 */
public abstract class BaseServiceImpl<T, Q, ID extends Serializable> implements BaseService<T, Q, ID> {

	protected BaseDao<T, Q, ID> baseDao;
	
	/**
	 * 设置具体的Dao实例。
	 * @param baseDao 具体的Dao实例
	 */
	public abstract void setBaseDao(BaseDao<T, Q, ID> baseDao);

	@Override
	public int count(Q params) {
		return baseDao.count(params);
	}

	@Override
	public int countBy(T params) {
		return baseDao.countBy(params);
	}

	@Override
	public int deleteBatch(Q params) {
		return baseDao.deleteBatch(params);
	}

	@Override
	public int deleteBulks(T params) {
		return baseDao.deleteBulks(params);
	}

	@Override
	public int deleteById(ID id) {
		return baseDao.deleteById(id);
	}

	@Override
	public int save(T record) {
		return baseDao.save(record);
	}

	@Override
	public List<T> queryForList(Q params) {
		return baseDao.queryForList(params);
	}

	@Override
	public List<T> queryList(T params) {
		return baseDao.queryList(params);
	}

	@Override
	public List<T> pagedForList(Q params) {
		return baseDao.pagedForList(params);
	}

	@Override
	public List<T> pagedList(T params) {
		return baseDao.pagedList(params);
	}

	@Override
	public T get(ID id) {
		return baseDao.get(id);
	}

	@Override
	public int updateBatch(T record, Q params) {
		return baseDao.updateBatch(record, params);
	}

	@Override
	public int updateBulks(T record, T params) {
		return baseDao.updateBulks(record, params);
	}

	@Override
	public int updateById(T record) {
		return baseDao.updateById(record);
	}

}
