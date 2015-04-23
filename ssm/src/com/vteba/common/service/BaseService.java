package com.vteba.common.service;

import java.io.Serializable;
import java.util.List;

/**
 * MyBatis的通用泛型Service。可以简化service的编写。有代码生成工具，其实也可以不要。
 * 
 * @author yinlei
 * @see
 * @since 2015年4月23日 下午3:32:04
 * @param <T> 泛型实体类
 * @param <Q> 复杂查询类
 * @param <ID> 主键类型
 */
public interface BaseService<T, Q, ID extends Serializable> {
	/**
     * 根据params所携带条件进行count计数。
     * @param params 查询条件
     * 
     * @return 返回统计总数
     */
    int count(Q params);

    /**
     * 根据params所携带条件进行计数，条件是等于，且是and关系。
     * @param params 查询条件
     * 
     * @return 返回统计总数
     */
    int countBy(T params);

    /**
     * 根据params所携带条件删除记录，适用于复杂条件。
     * @param params 查询条件
     * 
     * @return 被删除的记录数
     */
    int deleteBatch(Q params);

    /**
     * 根据params所携带条件删除数据，条件是等于，且是and关系。
     * @param params 删除条件
     * 
     * @return 被删除的记录数
     */
    int deleteBulks(T params);

    /**
     * 根据主键删除记录。
     * @param id 主键id
     * @return 被删除的记录数，应该是1或者0
     */
    int deleteById(ID id);

    /**
     * 插入记录，只有非空字段才会插入到数据库。
     * @param record 要被保存的数据
     * 
     * @return 保存的记录数，成功时1，失败时0
     */
    int save(T record);

    /**
     * 根据params所携带条件查询数据，适用于复杂查询。
     * @param params 查询条件
     * 
     * @return 查询到实体list
     */
    List<T> queryForList(Q params);

    /**
     * 根据params所携带条件查询数据，条件是等于，且是and关系。
     * @param params 查询条件
     * 
     * @return 查询到实体list
     */
    List<T> queryList(T params);

    /**
     * 根据params所携带条件分页查询数据，适用于复杂查询。
     * @param params 查询条件
     * 
     * @return 查询到实体list
     */
    List<T> pagedForList(Q params);

    /**
     * 根据params所携带条件分页查询数据，条件是等于，且是and关系。
     * @param params 查询条件
     * 
     * @return 查询到实体list
     */
    List<T> pagedList(T params);

    /**
     * 根据主键查询数据。
     * @param id 主键
     * 
     * @return 单个实体
     */
    T get(ID id);

    /**
     * 根据params所携带条件更新指定字段，适用于复杂条件。
     * @param record 要更新的数据
     * @param params update的where条件
     * 
     * @return 被更新的记录数
     */
    int updateBatch(T record, Q params);

    /**
     * 根据params所携带条件更新指定字段，条件是等于，且是and关系。
     * @param record 要更新的数据
     * @param params update的where条件
     * 
     * @return 被更新的记录数
     */
    int updateBulks(T record, T params);

    /**
     * 根据主键更新指定字段的数据。
     * @param record 要更新的数据，含有Id
     * 
     * @return 被更新的记录数，应该是1或者0
     */
    int updateById(T record);
}
