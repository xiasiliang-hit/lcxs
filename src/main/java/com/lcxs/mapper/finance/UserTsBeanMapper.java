package com.lcxs.mapper.finance;

import java.util.List;

import com.lcxs.model.finance.TsBean;
import com.lcxs.model.finance.UserTsBean;
import com.lcxs.model.finance.receiptBean;
import com.lcxs.utils.BaseConditionVO;

public interface UserTsBeanMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table c_user_ts
     *
     * @mbggenerated Thu May 24 12:26:20 CST 2018
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table c_user_ts
     *
     * @mbggenerated Thu May 24 12:26:20 CST 2018
     */
    int insert(UserTsBean record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table c_user_ts
     *
     * @mbggenerated Thu May 24 12:26:20 CST 2018
     */
    int insertSelective(UserTsBean record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table c_user_ts
     *
     * @mbggenerated Thu May 24 12:26:20 CST 2018
     */
    UserTsBean selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table c_user_ts
     *
     * @mbggenerated Thu May 24 12:26:20 CST 2018
     */
    int updateByPrimaryKeySelective(UserTsBean record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table c_user_ts
     *
     * @mbggenerated Thu May 24 12:26:20 CST 2018
     */
    int updateByPrimaryKey(UserTsBean record);
    
    /**
     * 根据用户的owninvitation查找推手所有信息
     */
    List<TsBean> queryTsData(BaseConditionVO vo); 
}