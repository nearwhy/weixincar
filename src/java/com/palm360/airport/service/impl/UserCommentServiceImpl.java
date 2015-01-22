package com.palm360.airport.service.impl;

import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Service;

import com.palm360.airport.model.Usercomment;
import com.palm360.airport.service.UserCommentService;
import com.palm360.airport.util.AirportQueryP;
import com.palm360.airport.util.exception.AirportRuntimeException;

@Service("userCommentService")
public class UserCommentServiceImpl extends BaseServiceImpl implements UserCommentService {

	public Usercomment addUserComment(Usercomment comment) {
		try {
			return userCommentDao.insert(comment);
		} catch (SQLException e) {
			throw new AirportRuntimeException("system.err.unkown", e);
		}
	}

	public List<Usercomment> queryUserComments(AirportQueryP qp) {
		try {
			return userCommentDao.queryUserComments(qp);
		} catch (SQLException e) {
			throw new AirportRuntimeException("system.err.unkown", e);
		}
	}

	public Usercomment getUserComment(Usercomment record) {
		try {
			return userCommentDao.selectByPrimaryKey(record);
		} catch (SQLException e) {
			throw new AirportRuntimeException("system.err.unkown", e);
		}
	}

}
