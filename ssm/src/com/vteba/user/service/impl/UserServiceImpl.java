package com.vteba.user.service.impl;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vteba.common.dao.BaseDao;
import com.vteba.common.service.impl.BaseServiceImpl;
import com.vteba.sequence.SequenceGenerator;
import com.vteba.user.dao.UserDao;
import com.vteba.user.model.User;
import com.vteba.user.model.UserBean;
import com.vteba.user.service.UserService;

/**
 * 用户service业务实现。
 * @author yinlei
 * 2014-2-25 上午11:26:29
 */
@Service
public class UserServiceImpl extends BaseServiceImpl<User, UserBean, String> implements UserService {
	
//	@Autowired//将UserDao的实现注入进来，也可以使用setter方法注入
	private UserDao userDao;
	
	@Override
	@Autowired
	public void setBaseDao(BaseDao<User, UserBean, String> userDao) {
		this.baseDao = userDao;
		this.userDao = (UserDao) userDao;
	}
	
	@Inject
	private SequenceGenerator sequenceGenerator;

//	@Override
//	public int count(UserBean userBean) {
//		return userDao.count(userBean);
//	}
//
//	@Override
//	public int deleteBatch(UserBean userBean) {
//		return userDao.deleteBatch(userBean);
//	}
//
//	@Override
//	public int deleteById(String id) {
//		return userDao.deleteById(id);
//	}

	@Override
	public int save(User record) {
		record.setId(sequenceGenerator.nextGUID());
		return userDao.save(record);
	}

//	@Override
//	public List<User> queryForList(UserBean userBean) {
////	    User user = new User();
////	    user.setUserName("尹雷");
////	    user.setUserAccount("tong@126.com");
////	    userDao.queryList(user);
////	    
////	    userDao.countBy(user);
////	    
////	    userDao.get("33");
////	    
////	    User params = new User();
////	    params.setUserName("好好2");
////	    params.setStart(0);
////	    userDao.pagedList(params);
////	    
////	    userBean = new UserBean();
////	    userBean.createCriteria().andUserAccountEqualTo("tongku@126.com");
////	    
////	    userDao.count(userBean);
////	    userDao.pagedForList(userBean);
//	    
//		return userDao.queryForList(userBean);
//	}
//
//	@Override
//	public User get(String id) {
//		return userDao.get(id);
//	}
//
//	@Override
//	public int updateBatch(User record, UserBean userBean) {
//		return userDao.updateBatch(record, userBean);
//	}
//
//	@Override
//	public int updateById(User record) {
//		return userDao.updateById(record);
//	}
//
//    @Override
//    public int countBy(User params) {
//        return userDao.countBy(params);
//    }
//
//    @Override
//    public int deleteBulks(User params) {
//        return userDao.deleteBulks(params);
//    }
//
//    @Override
//    public List<User> queryList(User params) {
//        return userDao.queryList(params);
//    }
//
//    @Override
//    public List<User> pagedForList(UserBean params) {
//        return userDao.pagedForList(params);
//    }
//
//    @Override
//    public List<User> pagedList(User params) {
//        return userDao.pagedList(params);
//    }
//
//    @Override
//    public int updateBulks(User record, User params) {
//        return userDao.updateBulks(record, params);
//    }

}
