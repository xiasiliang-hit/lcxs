package com.lcxs.mapper.base;

import java.util.List;

import com.lcxs.model.base.bankBean;
import com.lcxs.model.base.friendMessage;
import com.lcxs.model.base.invitationBean;
import com.lcxs.utils.BaseConditionVO;

public interface invitationBeanMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table c_invitation
     *
     * @mbggenerated Thu Mar 29 14:05:30 CST 2018
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table c_invitation
     *
     * @mbggenerated Thu Mar 29 14:05:30 CST 2018
     */
    int insert(invitationBean record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table c_invitation
     *
     * @mbggenerated Thu Mar 29 14:05:30 CST 2018
     */
    int insertSelective(invitationBean record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table c_invitation
     *
     * @mbggenerated Thu Mar 29 14:05:30 CST 2018
     */
    invitationBean selectByUserid(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table c_invitation
     *
     * @mbggenerated Thu Mar 29 14:05:30 CST 2018
     */
    int updateByPrimaryKeySelective(invitationBean record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table c_invitation
     *
     * @mbggenerated Thu Mar 29 14:05:30 CST 2018
     */
    int updateByPrimaryKey(invitationBean record);
    /**
     * 查询邀请信息
     */
    List<friendMessage> queryFriendMessage(BaseConditionVO vo);
    /*
    查询推手信息
     */
    List<friendMessage> queryTs(BaseConditionVO vo);
    /*
    插入打款流水
     */
    int insertMoney(invitationBean record);
}
