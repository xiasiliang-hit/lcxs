package com.lcxs.service.product.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lcxs.mapper.product.channelBeanMapper;
import com.lcxs.model.product.channelBean;
import com.lcxs.model.product.productBean;
import com.lcxs.service.product.IChannelService;
import com.lcxs.utils.BaseConditionVO;
import com.lcxs.utils.Time;
@Service
public class channelServiceImpl implements IChannelService{

	@Resource
	private channelBeanMapper channelMapper;
	@Override
	public int deleteByPrimaryKey(Long id) {
		// TODO Auto-generated method stub
		return channelMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(channelBean record) {
		
		return channelMapper.insert(record);
	}

	@Override
	public int insertSelective(channelBean record) {
		record.setCtime(Time.getTime());
		record.setCid(Time.getId());
		record.setStatus(1);
		return channelMapper.insertSelective(record);
	}

	@Override
	public channelBean selectByCid(Long cid) {
		// TODO Auto-generated method stub
		return channelMapper.selectByCid(cid);
	}

	@Override
	public int updateByPrimaryKeySelective(channelBean record) {
		// TODO Auto-generated method stub
		return channelMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(channelBean record) {
		// TODO Auto-generated method stub
		return channelMapper.updateByPrimaryKey(record);
	}

	@Override
	public PageInfo<channelBean> queryAll(BaseConditionVO vo) {
		PageHelper.startPage(vo.getPageNum(),vo.getPageSize());
		List<channelBean> list=channelMapper.queryAll(vo);
		PageInfo<channelBean> pageinfo=new PageInfo<channelBean>(list);
		return pageinfo;
	}

	@Override
	public Long deleteById(Long id) {
		
		return channelMapper.deleteById(id);
	}

}
