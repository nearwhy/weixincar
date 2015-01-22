package com.palm360.airport.service;

import java.util.List;

import com.palm360.airport.model.Usercomment;
import com.palm360.airport.util.AirportQueryP;

/**
 * 用户回复
 * 
 * @author xzl
 * 
 */
public interface UserCommentService extends BaseService {

	/**
	 * 添加用户回复
	 * 
	 * @param comment
	 * @return
	 */
	Usercomment addUserComment(Usercomment comment);

	/**
	 * 获取用户回复
	 * 
	 * @param comment
	 * @return
	 */
	Usercomment getUserComment(Usercomment comment);

	/**
	 * 查询回复，可分页
	 * 
	 * @param qp
	 *            TODO
	 * 
	 * @return
	 */
	List<Usercomment> queryUserComments(AirportQueryP qp);
}
