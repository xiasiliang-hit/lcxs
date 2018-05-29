package com.lcxs.service.product.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lcxs.mapper.product.bannerBeanMapper;
import com.lcxs.model.product.bannerBean;
import com.lcxs.service.product.ICBannerService;
import com.lcxs.utils.BaseConditionVO;
import com.lcxs.utils.Time;
import com.lcxs.utils.banner;
@Service
public class cBannerServiceImpl implements ICBannerService{
	@Resource
	private  bannerBeanMapper bannerMapper;
	
	@Override
	public PageInfo<bannerBean> findAll(BaseConditionVO vo) {
		PageHelper.startPage(vo.getPageNum(),vo.getPageSize());
		List<bannerBean> list=bannerMapper.findAll(vo);
		PageInfo<bannerBean> pageinfo=new PageInfo<bannerBean>(list);
		return pageinfo;
	}

	@Override
	public int deleteByid(int id) {
		return bannerMapper.deleteByid(id);
	}

	@Override
	public int inset(bannerBean banner) {
		banner.setStatus(1);
		return bannerMapper.insertSelective(banner);
	}

	@Override
	public bannerBean findByid(int id) {
		return bannerMapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateBanner(bannerBean banner) {
		
			return bannerMapper.updateByPrimaryKeySelective(banner);
		
	}


}
