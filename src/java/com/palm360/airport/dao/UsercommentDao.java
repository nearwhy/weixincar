package com.palm360.airport.dao;

import java.sql.SQLException;
import java.util.List;

import com.palm360.airport.model.Usercomment;
import com.palm360.airport.util.AirportQueryP;

/**
 * 回复.dao
 * @author xzl
 *
 */
public interface UsercommentDao extends BaseDao<Usercomment> {

	/**
	 * 添加用户回复
	 * 
	 * @param record
	 * @return
	 * @throws SQLException
	 */
	Usercomment insert(Usercomment record) throws SQLException;

	/**
	 * 根据主键更新回复
	 * 
	 * @param record
	 * @return
	 * @throws SQLException
	 */
	int updateByPrimaryKey(Usercomment record) throws SQLException;

	/**
	 * 根据条件更新回复
	 * 
	 * @param record
	 * @return
	 * @throws SQLException
	 */
	int updateByPrimaryKeySelective(Usercomment record) throws SQLException;

	/**
	 * 根据主键查询回复
	 * 
	 * @param commentid
	 * @return
	 * @throws SQLException
	 */
	Usercomment selectByPrimaryKey(Usercomment record) throws SQLException;

	/**
	 * 根据主键删除回复
	 * 
	 * @param commentid
	 * @return
	 * @throws SQLException
	 */
	int deleteByPrimaryKey(Integer commentid) throws SQLException;

	/**
	 * 根据条件查询回复，可分页
	 * 
	 * @param qp
	 * @return
	 * @throws SQLException
	 */
	List<Usercomment> queryUserComments(AirportQueryP qp) throws SQLException;

}
