package com.lcxs.service.product.impl;




import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lcxs.mapper.product.upBeanMapper;
import com.lcxs.model.product.upBean;
import com.lcxs.service.product.ICShopUpdateService;
import com.lcxs.utils.BaseConditionVO;
@Service
public class cShopUpdateServiceImpl implements ICShopUpdateService{
	@Resource
	private upBeanMapper upMapper;
	@Override
	public PageInfo<upBean> findAll(BaseConditionVO vo) {
		PageHelper.startPage(vo.getPageNum(),vo.getPageSize());
		List<upBean> list=upMapper.findAll(vo);
		PageInfo<upBean> pageinfo=new PageInfo<upBean>(list);
		return pageinfo;
	}
	
	

}
