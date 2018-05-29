package com.lcxs.service.finance.impl;

import java.util.List;

import javax.annotation.Resource;

import com.lcxs.model.base.userBean;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lcxs.mapper.finance.UserReceiptBeanMapper;
import com.lcxs.model.finance.UserReceiptBean;

import com.lcxs.model.finance.receiptBean;
import com.lcxs.model.homepage.homeBean;


import com.lcxs.model.homepage.homeBean;

import com.lcxs.service.finance.IUserReceiptService;
import com.lcxs.utils.BaseConditionVO;
@Service
public class UserReceiptServiceImpl implements IUserReceiptService{

	@Resource
	private UserReceiptBeanMapper urMapper;

	@Override
	public int deleteByPrimaryKey(Long id) {
		// TODO Auto-generated method stub
		return urMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(UserReceiptBean record) {
		// TODO Auto-generated method stub
		return urMapper.insert(record);
	}

	@Override
	public int insertSelective(UserReceiptBean record) {
		// TODO Auto-generated method stub
		return urMapper.insertSelective(record);
	}

	@Override
	public UserReceiptBean selectByRid(Long rid) {
		// TODO Auto-generated method stub
		return urMapper.selectByRid(rid);
	}

	@Override
	public int updateByPrimaryKeySelective(UserReceiptBean record) {
		// TODO Auto-generated method stub
		return urMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(UserReceiptBean record) {
		// TODO Auto-generated method stub
		return urMapper.updateByPrimaryKey(record);
	}


	@Override
	public PageInfo<homeBean> queryActivityData(BaseConditionVO vo) {
		PageHelper.startPage(vo.getPageNum(),vo.getPageSize());
		List<homeBean> list=urMapper.queryActivityData(vo);
		PageInfo<homeBean> pageinfo=new PageInfo<homeBean>(list);
		return pageinfo;
	}



	@Override
	public PageInfo<homeBean> queryShopData(BaseConditionVO vo) {
		PageHelper.startPage(vo.getPageNum(),vo.getPageSize());
		List<homeBean> list=urMapper.queryShopData(vo);
		PageInfo<homeBean> pageinfo=new PageInfo<homeBean>(list);
		return pageinfo;
	}

	@Override
	public PageInfo<receiptBean> queryReceiptData(BaseConditionVO vo) {
		PageHelper.startPage(vo.getPageNum(),vo.getPageSize());
		List<receiptBean> list=urMapper.queryReceiptData(vo);
//		UserReceiptBean r=new UserReceiptBean();
//		for(int i=0;i<list.size();i++){
//			Long vid=Long.parseLong(list.get(i).getVid());
//			r.setVid(vid);
//			urMapper.insertSelective(r);
//		}

		PageInfo<receiptBean> pageinfo=new PageInfo<receiptBean>(list);
		return pageinfo;
	}


}
