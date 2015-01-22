package com.palm360.airport.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.stereotype.Repository;

import com.palm360.airport.dao.UsercommentDao;
import com.palm360.airport.model.Usercomment;
import com.palm360.airport.util.AirportQueryP;
import com.palm360.airport.util.stereotype.EntityKeyName;

@Repository("userCommentDao")
@EntityKeyName(entity = Usercomment.class, keyName = "Usercomment")
public class UsercommentDaoImpl extends BaseDaoImpl implements UsercommentDao {
	
	private SqlMapClientTemplate sqlMapClient;

	public UsercommentDaoImpl() {
		super();
		this.sqlMapClient = this.getSqlMapClientTemplate();
	}

	public Usercomment insert(Usercomment record) throws SQLException {
		Object id = sqlMapClient.insert("UserComment.insert", record);
		record.setCommentid(Integer.parseInt(id.toString()));
		return record;
	}

	public int updateByPrimaryKey(Usercomment record) throws SQLException {
		int rows = sqlMapClient.update(
				"UserComment.updateByPrimaryKey", record);
		return rows;
	}

	public int updateByPrimaryKeySelective(Usercomment record)
			throws SQLException {
		int rows = sqlMapClient.update(
				"UserComment.updateByPrimaryKeySelective",
				record);
		return rows;
	}

	public Usercomment selectByPrimaryKey(Usercomment record)
			throws SQLException {
		return (Usercomment) sqlMapClient.queryForObject(
				"UserComment.selectByPrimaryKey", record);
	}

	public int deleteByPrimaryKey(Integer commentid) throws SQLException {
		Usercomment key = new Usercomment();
		key.setCommentid(commentid);
		int rows = sqlMapClient.delete(
				"UserComment.deleteByPrimaryKey", key);
		return rows;
	}

	public List queryAll(int size, int page) {
		return super.queryAll("UserComment.queryAll", new AirportQueryP(page,
				size));
	}

	public int queryAllCount() {
		return super.queryAllCount("UserComment.queryAllCount");
	}

	public List<Usercomment> queryUserComments(AirportQueryP qp) throws SQLException {
		return super.queryAll("UserComment.queryUserComments", qp);
	}

}
