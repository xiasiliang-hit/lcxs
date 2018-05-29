package com.lcxs.service.base.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lcxs.mapper.base.staffBeanMapper;
import com.lcxs.mapper.base.userBeanMapper;
import com.lcxs.mapper.product.noteBeanMapper;
import com.lcxs.model.base.staffBean;
import com.lcxs.model.base.userBean;
import com.lcxs.model.product.noteBean;
import com.lcxs.service.base.IStaffService;
import com.lcxs.utils.BaseConditionVO;
import com.lcxs.utils.GetInvitation;
import com.lcxs.utils.Time;
@Service("staffService")
public class staffServiceImpl implements IStaffService{
	@Resource
	//员工登录功能
	private staffBeanMapper staffDao;
	@Resource
	private userBeanMapper dao;
	@Override
	//显示全体员工信息
	public PageInfo<staffBean> findAll(BaseConditionVO vo) {
			PageHelper.startPage(vo.getPageNum(),vo.getPageSize());
			List<staffBean> list=staffDao.findAll(vo);
			PageInfo<staffBean> pageinfo=new PageInfo<staffBean>(list);
			return pageinfo;
	}
	//删除员工
	public int deleteBySid(Long sid) {
		return staffDao.deleteBySid(sid);
	}
	//根据员工编号查找员工
	public staffBean findStaffBySid(Long sid) {
		return staffDao.findStaffBySid(sid);
	}
	//修改员工信息
	public int updateByPrimaryKeySelective(staffBean staff) {
		return staffDao.updateByPrimaryKeySelective(staff);
	}
	//添加员工
	public int addStaff(staffBean staff) {
		String ctime=Time.getTime();
		Long sid=Time.getId();
		Md5Hash md5=new Md5Hash(staff.getPassword(),"jkfl",1);
		String pwd=md5.toString();
		staff.setStatus(1);
		staff.setPassword(pwd);
		staff.setCtime(ctime);
		staff.setSid(sid);
		staff.setStatus(1);
		return staffDao.insertSelective(staff);
	}
	@Override
	public staffBean queryByPhone(String phone) {
		// TODO Auto-generated method stub
		return staffDao.queryByPhone(phone);
	}
	@Override
	public PageInfo<userBean> findUserBySid(BaseConditionVO vo) {
		PageHelper.startPage(vo.getPageNum(),vo.getPageSize());
		List<userBean> list=staffDao.findUserBySid(vo);
		for (int i = 0; i < list.size(); i++) {
			Long vid=list.get(i).getVid();
			Object totaltmoney = dao.findTotalMoney(vid);
			Object totalJMoney=dao.findTotalReturnAmount(vid);
			Object totalRMoney=dao.findReadyAmount(vid);
			Object totalRedMoney=dao.findTotalRedAmount(vid);
			if(totalJMoney==null||totalJMoney=="")totalJMoney=0.0;
			if(totalRedMoney==null||totalRedMoney=="")totalRedMoney=0.0;
			list.get(i).setTotalJMoney((Double)totalJMoney);
			list.get(i).setTotalRedMoney((Double)totalRedMoney);
			int bankCount=dao.findBankCount(vid);
			list.get(i).setBankCount(bankCount);
			int friendCount=dao.findFriendAll(vid);
			list.get(i).setFriendCount(friendCount);
			if(totalRMoney==null || totalRMoney.equals("")){
				list.get(i).setTotalRMoney(0.0);
			}else{
				list.get(i).setTotalRMoney((Double) totalRMoney);
			}
			if(totaltmoney==null || totaltmoney.equals("")){
				list.get(i).setTotalMoney(0.0);
			}else{
				list.get(i).setTotalMoney((Double) totaltmoney);
			}
		}
		PageInfo<userBean> pageinfo=new PageInfo<userBean>(list);
		return pageinfo;
	}
	@Override
	public boolean updatePwd(String pwd, Long sid) {
		BaseConditionVO vo=new BaseConditionVO();
		Md5Hash md5=new Md5Hash(pwd,"jkfl",1);
		String password=md5.toString();
		vo.setKeywords(password);
		vo.setKeywordsauid(sid);
		int row=staffDao.changePwd(vo);
		if(row<1){
			return false;
		}
		return true;
	}
	@Override
	public List<staffBean> findAllStaff() {
		return staffDao.findAllStaff();
	}
	@Override
	public boolean binding(userBean user) {
		String phone=user.getPhone();
		if(user.getKf()=="请选择客服" || "请选择客服".equals(user.getKf())){
			user.setKf("");
		}
		List<userBean> list=dao.findUserByPhone(phone);
		if(list.size()<1){
			return false;
		}
		int row=dao.updateByPhone(user);
		if(row<1){
			return false;
		}
		return true;
	}
	
	
}
