package com.lcxs.service.finance;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.lcxs.model.base.friendMessage;
import com.lcxs.model.base.invitationBean;
import com.lcxs.model.finance.TsBean;
import com.lcxs.utils.BaseConditionVO;

public interface ITsService {
	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table c_ts
	 * @mbggenerated  Thu May 24 11:25:32 CST 2018
	 */
	int deleteByPrimaryKey(Integer id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table c_ts
	 * @mbggenerated  Thu May 24 11:25:32 CST 2018
	 */
	int insert(TsBean record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table c_ts
	 * @mbggenerated  Thu May 24 11:25:32 CST 2018
	 */
	int insertSelective(TsBean record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table c_ts
	 * @mbggenerated  Thu May 24 11:25:32 CST 2018
	 */
	TsBean selectByPrimaryKey(Long vid);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table c_ts
	 * @mbggenerated  Thu May 24 11:25:32 CST 2018
	 */
	int updateByPrimaryKeySelective(TsBean record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table c_ts
	 * @mbggenerated  Thu May 24 11:25:32 CST 2018
	 */
	int updateByPrimaryKey(TsBean record);
	 /**
     * 查询所有ts
     */
	 PageInfo<TsBean> queryAll(BaseConditionVO vo);

	/**
	 * 修改打款信息
	 * @param ts
	 * @return
	 */
	int updatePassMoney(String tsid);
	/*
	*查询所有推手
	*/
	PageInfo<friendMessage> queryTs(BaseConditionVO vo);

}
