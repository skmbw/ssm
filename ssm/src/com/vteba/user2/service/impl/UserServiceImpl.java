package com.vteba.user2.service.impl;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import com.vteba.user2.dao.UserDao;
import com.vteba.user2.model.User;
import com.vteba.user2.model.UserBean;
import com.vteba.user2.service.spi.UserService;

/**
 * 系统用户相关的service业务实现。
 * @author yinlei
 * @date 2014-9-16 13:16:14
 */
@Named
public class UserServiceImpl implements UserService {
	
	@Inject
	private UserDao userDao;

	@Override
	public int count(UserBean params) {
		return userDao.count(params);
	}

	@Override
	public int deleteBatch(UserBean params) {
		return userDao.deleteBatch(params);
	}

	@Override
	public int deleteById(Long id) {
		return userDao.deleteById(id);
	}

	@Override
	public int save(User record) {
		return userDao.save(record);
	}

	@Override
	public List<User> queryForList(UserBean params) {
		return userDao.queryForList(params);
	}

	@Override
	public User get(Long id) {
		return userDao.get(id);
	}

	@Override
	public int updateBatch(User record, UserBean params) {
		return userDao.updateBatch(record, params);
	}

	@Override
	public int updateById(User record) {
		return userDao.updateById(record);
	}

    @Override
    public int countBy(User params) {
        return userDao.countBy(params);
    }

    @Override
    public int deleteBulks(User params) {
        return userDao.deleteBulks(params);
    }

    @Override
    public List<User> queryList(User params) {
        return userDao.queryList(params);
    }

    @Override
    public List<User> pagedForList(UserBean params) {
        return userDao.pagedForList(params);
    }

    @Override
    public List<User> pagedList(User params) {
        return userDao.pagedList(params);
    }

    @Override
    public int updateBulks(User record, User params) {
        return userDao.updateBulks(record, params);
    }

}
