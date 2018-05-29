package com.lcxs.mapper.product;

import java.util.List;

import com.lcxs.model.product.upBean;
import com.lcxs.utils.BaseConditionVO;

public interface upBeanMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table c_shop_update
     *
     * @mbggenerated Thu Apr 19 17:52:50 CST 2018
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table c_shop_update
     *
     * @mbggenerated Thu Apr 19 17:52:50 CST 2018
     */
    int insert(upBean record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table c_shop_update
     *
     * @mbggenerated Thu Apr 19 17:52:50 CST 2018
     */
    int insertSelective(upBean record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table c_shop_update
     *
     * @mbggenerated Thu Apr 19 17:52:50 CST 2018
     */
    upBean selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table c_shop_update
     *
     * @mbggenerated Thu Apr 19 17:52:50 CST 2018
     */
    int updateByPrimaryKeySelective(upBean record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table c_shop_update
     *
     * @mbggenerated Thu Apr 19 17:52:50 CST 2018
     */
    int updateByPrimaryKey(upBean record);
    /**
     * 查询商户全部信息
     * @param vo
     * @return
     */
    List<upBean> findAll(BaseConditionVO vo);
}