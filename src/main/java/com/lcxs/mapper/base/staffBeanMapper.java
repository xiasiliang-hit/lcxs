package com.lcxs.mapper.base;

import java.util.List;

import com.lcxs.model.base.staffBean;
import com.lcxs.model.base.userBean;
import com.lcxs.utils.BaseConditionVO;

public interface staffBeanMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table c_staff
     *
     * @mbggenerated Mon Mar 05 17:59:09 CST 2018
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table c_staff
     *
     * @mbggenerated Mon Mar 05 17:59:09 CST 2018
     */
    int insert(staffBean record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table c_staff
     *
     * @mbggenerated Mon Mar 05 17:59:09 CST 2018
     */
    int insertSelective(staffBean record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table c_staff
     *
     * @mbggenerated Mon Mar 05 17:59:09 CST 2018
     */
    staffBean selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table c_staff
     *
     * @mbggenerated Mon Mar 05 17:59:09 CST 2018
     */
    int updateByPrimaryKeySelective(staffBean record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table c_staff
     *
     * @mbggenerated Mon Mar 05 17:59:09 CST 2018
     */
    int updateByPrimaryKey(staffBean record);
    staffBean findStaffBySid(Long sid);//根据员工编号查询员工信息
    staffBean findStaffByPhone(staffBean staff);//员工登录
    List<staffBean> findAll(BaseConditionVO vo);//显示全体员工信息
    int deleteBySid(Long sid);//冻结员工账号
    List<userBean> findUserBySid(BaseConditionVO vo);//根据员工编号查找专属用户
    /**
     * 根据电话查找员工信息
     */
    staffBean queryByPhone(String phone);
    int changePwd(BaseConditionVO vo);//根据员工sid重置密码
    List<staffBean> findAllStaff();
}





