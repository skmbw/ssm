package com.vteba.user.dao;

import com.vteba.common.dao.BaseDao;
import com.vteba.tm.jdbc.mybatis.annotation.DaoMapper;
import com.vteba.user.model.User;
import com.vteba.user.model.UserBean;

@DaoMapper
public interface UserDao extends BaseDao<User, UserBean, String> {
//    /**
//     * 根据params所携带条件进行count计数。
//     * @param params 查询条件
//     *
//     * @date 2014-09-18 09:48:10
//     */
//    int count(UserBean params);
//
//    /**
//     * 根据params所携带条件进行计数，条件是等于，且是and关系。
//     * @param params 查询条件
//     *
//     * @date 2014-09-18 09:48:10
//     */
//    int countBy(User params);
//
//    /**
//     * 根据params所携带条件删除记录，适用于复杂条件。
//     * @param params 查询条件
//     *
//     * @date 2014-09-18 09:48:10
//     */
//    int deleteBatch(UserBean params);
//
//    /**
//     * 根据params所携带条件删除数据，条件是等于，且是and关系。
//     * @param params 删除条件
//     *
//     * @date 2014-09-18 09:48:10
//     */
//    int deleteBulks(User params);
//
//    /**
//     * 根据主键删除记录。
//     * @param id 主键id
//     *
//     * @date 2014-09-18 09:48:10
//     */
//    int deleteById(String id);
//
//    /**
//     * 插入记录，只有非空字段才会插入到数据库。
//     * @param record 要被保存的数据
//     *
//     * @date 2014-09-18 09:48:10
//     */
//    int save(User record);
//
//    /**
//     * 根据params所携带条件查询数据，适用于复杂查询。
//     * @param params 查询条件
//     *
//     * @date 2014-09-18 09:48:10
//     */
//    List<User> queryForList(UserBean params);
//
//    /**
//     * 根据params所携带条件查询数据，条件是等于，且是and关系。
//     * @param params 查询条件
//     *
//     * @date 2014-09-18 09:48:10
//     */
//    List<User> queryList(User params);
//
//    /**
//     * 根据params所携带条件分页查询数据，适用于复杂查询。
//     * @param params 查询条件
//     *
//     * @date 2014-09-18 09:48:10
//     */
//    List<User> pagedForList(UserBean params);
//
//    /**
//     * 根据params所携带条件分页查询数据，条件是等于，且是and关系。
//     * @param params 查询条件
//     *
//     * @date 2014-09-18 09:48:10
//     */
//    List<User> pagedList(User params);
//
//    /**
//     * 根据主键查询数据。
//     * @param id 主键
//     *
//     * @date 2014-09-18 09:48:10
//     */
//    User get(String id);
//
//    /**
//     * 根据params所携带条件更新指定字段，适用于复杂条件。
//     * @param record 要更新的数据
//     * @param params update的where条件
//     *
//     * @date 2014-09-18 09:48:10
//     */
//    int updateBatch(@Param("record") User record, @Param("params") UserBean params);
//
//    /**
//     * 根据params所携带条件更新指定字段，条件是等于，且是and关系。
//     * @param record 要更新的数据
//     * @param params update的where条件
//     *
//     * @date 2014-09-18 09:48:10
//     */
//    int updateBulks(@Param("record") User record, @Param("params") User params);
//
//    /**
//     * 根据主键更新指定字段的数据。
//     * @param record 要更新的数据，含有Id
//     *
//     * @date 2014-09-18 09:48:10
//     */
//    int updateById(User record);
}