package com.lcxs.service.product.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lcxs.mapper.product.caseBeanMapper;
import com.lcxs.mapper.product.productBeanMapper;
import com.lcxs.mapper.product.redBeanMapper;
import com.lcxs.model.product.caseBean;
import com.lcxs.model.product.productBean;
import com.lcxs.model.product.shopBean;
import com.lcxs.service.product.ICCaseService;
import com.lcxs.utils.BaseConditionVO;
import com.lcxs.utils.ReadExcel;
import com.lcxs.utils.Time;

@Service
public class cCaseServiceImpl implements ICCaseService{
	@Resource
	private caseBeanMapper caseMapper;
	@Resource
	private productBeanMapper pMapper;
	@Override
	public PageInfo<caseBean> findById( BaseConditionVO vo) {
		PageHelper.startPage(vo.getPageNum(),vo.getPageSize());
		List<caseBean> list=caseMapper.findById(vo);
		PageInfo<caseBean> pageinfo=new PageInfo<caseBean>(list);
		return pageinfo;
	}
	@Override
	public int deleteByid(Long id) {
		
		return caseMapper.deleteByid(id);
	}
	@Override
	public int inset(caseBean c,Long key) {
		c.setCtime(Time.getTime());
		c.setStatus(1);
		c.setProductid(key);
		c.setRed(c.getRed());
		productBean pr = pMapper.selectByPrimaryKey(key);
		c.setProject(pr.getPname());
		return caseMapper.insertSelective(c);
	}
	@Override
	public int updateCase(caseBean c) {
		return caseMapper.updateByPrimaryKeySelective(c);
	}
	@Override
	public caseBean selectByPrimaryKey(Long id) {
		// TODO Auto-generated method stub
		return caseMapper.selectByPrimaryKey(id);
	}
	@Override
	public caseBean selectCaseByProjectAndCid(BaseConditionVO vo) {
		// TODO Auto-generated method stub
		return caseMapper.selectCaseByProjectAndCid(vo);
	}
	@Override
	public PageInfo<caseBean> findOldById(BaseConditionVO vo) {
		PageHelper.startPage(vo.getPageNum(),vo.getPageSize());
		List<caseBean> list=caseMapper.findOldById(vo);
		PageInfo<caseBean> pageinfo=new PageInfo<caseBean>(list);
		return pageinfo;
	}
	@Override
	public int upByid(Long id) {
		
		return caseMapper.upByid(id);
	}
	@Override
	public int deleteBypid(Long productid) {
		
		return caseMapper.deleteBypid(productid);
	}
	@Override
	public int upBypid(Long productid) {
		
		return caseMapper.upBypid(productid);
	}

}
