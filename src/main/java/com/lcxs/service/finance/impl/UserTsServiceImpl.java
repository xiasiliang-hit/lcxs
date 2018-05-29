package com.lcxs.service.finance.impl;

import java.util.List;

import javax.annotation.Resource;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lcxs.mapper.finance.UserTsBeanMapper;
import com.lcxs.model.finance.TsBean;
import com.lcxs.model.finance.UserTsBean;
import com.lcxs.service.finance.IUserTsService;
import com.lcxs.utils.BaseConditionVO;
import org.springframework.stereotype.Service;

@Service
public class UserTsServiceImpl implements IUserTsService {
	@Resource
	private UserTsBeanMapper utMapper;

	@Override
	public int deleteByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return utMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(UserTsBean record) {

		return utMapper.insert(record);
	}

	@Override
	public int insertSelective(UserTsBean record) {
		// TODO Auto-generated method stub
		return utMapper.insertSelective(record);
	}

	@Override
	public UserTsBean selectByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return utMapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKeySelective(UserTsBean record) {
		// TODO Auto-generated method stub
		return utMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(UserTsBean record) {
		// TODO Auto-generated method stub
		return utMapper.updateByPrimaryKey(record);
	}

	@Override
	public PageInfo<TsBean> queryTsData(BaseConditionVO vo) {
		PageHelper.startPage(vo.getPageNum(),vo.getPageSize());
		List<TsBean> list=utMapper.queryTsData(vo);
		PageInfo<TsBean> pageinfo=new PageInfo<TsBean>(list);
		return pageinfo;
	}
	
}
