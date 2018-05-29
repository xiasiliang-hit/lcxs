package com.lcxs.service.base;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.lcxs.model.base.staffBean;
import com.lcxs.model.base.userBean;
import com.lcxs.model.product.noteBean;
import com.lcxs.utils.BaseConditionVO;



public interface IStaffService {
	PageInfo<staffBean> findAll(BaseConditionVO vo);//显示全体员工信息
	int deleteBySid(Long sid);//冻结员工账号
	staffBean findStaffBySid(Long sid);//根据sid显示员工信息
	int updateByPrimaryKeySelective(staffBean staff);//修改员工信息
	int addStaff(staffBean staff);//添加员工
	PageInfo<userBean>findUserBySid(BaseConditionVO vo);//查找专属客户
	/**
     * 根据电话查找员工信息
     */
    staffBean queryByPhone(String phone);
    boolean updatePwd(String pwd,Long sid);//重置密码
    List<staffBean> findAllStaff();
    boolean binding (userBean user);//绑定客户
}
	
	
