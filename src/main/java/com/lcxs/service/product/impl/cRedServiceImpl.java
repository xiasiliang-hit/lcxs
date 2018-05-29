package com.lcxs.service.product.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lcxs.mapper.base.userBeanMapper;
import com.lcxs.mapper.base.userRedBeanMapper;
import com.lcxs.mapper.product.redBeanMapper;
import com.lcxs.model.base.userBean;
import com.lcxs.model.base.userRedBean;
import com.lcxs.model.product.redBean;
import com.lcxs.service.product.ICRedService;
import com.lcxs.utils.BaseConditionVO;
import com.lcxs.utils.Time;
@Service
public class cRedServiceImpl implements ICRedService{
	@Resource
	private redBeanMapper rMapper;
	@Resource
	private userBeanMapper userMapper;
	@Resource
	private userRedBeanMapper userRedBeanMapper;

	@Override
	public PageInfo<redBean> findAll(BaseConditionVO vo) {
		PageHelper.startPage(vo.getPageNum(),vo.getPageSize());
		List<redBean> list=rMapper.findAll(vo);
		PageInfo<redBean> pageinfo=new PageInfo<redBean>(list);
		return pageinfo;
	}
	@Override
	public Long deleteByRedid(Long redid) {
	
		return rMapper.deleteByRedid(redid);
	}
	@Override
	public int inset(redBean red){
				Long redid=Time.getId();
				red.setRedid(redid);
				red.setStatus(1);
				return	rMapper.insertSelective(red);
	}

	@Override
	public int updateRed(redBean red) {
		
		return rMapper.updateByPrimaryKeySelective(red);
	}
	@Override
	public redBean findById(Long id) {
		
		return rMapper.selectByPrimaryKey(id);
	}
	@Override
	public List<redBean> goToSend() {
		return rMapper.findRedName();
	}
	@Override
	public void bindingRed(redBean red) {
		String redname=red.getRedname();
		redBean r=rMapper.findRedByName(redname);
		List<Long> list=userMapper.findAllInfo();
		userRedBean ur=new userRedBean();
		ur.setCtime(Time.getTime());
		ur.setContext(r.getContext());
		ur.setDays(r.getDays());
		ur.setRedid(r.getRedid());
		ur.setRedmoney(r.getRedmoney());
		ur.setType("0");
		ur.setRedcondition(r.getRedcondition());
		ur.setRedname(redname);
		for(int i=0;i<list.size();i++){
			Long vid=list.get(i);
			ur.setVid(vid);
			userRedBeanMapper.insertSelective(ur);
		}	
	}
	@Override
	public Long upByRedid(Long redid) {
		// TODO Auto-generated method stub
		return rMapper.upByRedid(redid);
	}
	//所有用户红包列表
	@Override
	public PageInfo<userRedBean> findUserRedAll(BaseConditionVO vo) {
		PageHelper.startPage(vo.getPageNum(),vo.getPageSize());
		List<userRedBean> list=userRedBeanMapper.findUserRedAll(vo);
		PageInfo<userRedBean> pageinfo=new PageInfo<userRedBean>(list);
		return pageinfo;
	}

	//红包表插入数据
	@Override
	public int insetUserRed(userBean userBean,userRedBean userRed,Long sid) {
		String phone = userBean.getPhone();
		List<userBean> user = userMapper.findUserByPhone(phone);
		userRedBean userRedBean = new userRedBean();
		userRedBean.setVid(user.get(0).getVid());//设置vid
		userRedBean.setRedid(Long.valueOf(0));//设置红包编号
		userRedBean.setRedmoney(userRed.getRedmoney());//设置红包金额
		userRedBean.setRedcondition(userRed.getRedcondition());//设置红包使用条件
		userRedBean.setCtime(Time.getTime());//领取红包时间
		userRedBean.setRedname(userRed.getRedname());//设置红包名
		userRedBean.setDays(userRed.getDays());//有效天数
		userRedBean.setType("0");//类型：0=未使用 1=已使用 2=已过期
		userRedBean.setContext(userRed.getContext());//使用条件
		userRedBean.setSendersid(sid);//设置发送人sid
		return userRedBeanMapper.insertSelective(userRedBean);
	}

}
