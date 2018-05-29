package com.lcxs.service.product.impl;


import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lcxs.mapper.product.caseBeanMapper;
import com.lcxs.mapper.product.productBeanMapper;
import com.lcxs.mapper.product.shopBeanMapper;
import com.lcxs.mapper.product.upBeanMapper;
import com.lcxs.model.product.caseBean;
import com.lcxs.model.product.productBean;
import com.lcxs.model.product.shopBean;
import com.lcxs.model.product.upBean;
import com.lcxs.service.product.ICShopService;
import com.lcxs.utils.BaseConditionVO;
import com.lcxs.utils.Time;
@Service
public class cShopServiceImpl implements ICShopService{
	@Resource
	private shopBeanMapper shopMapper;
	@Resource 
	private productBeanMapper productMapper;
	@Resource
	private upBeanMapper upMapper;
	@Resource
	private caseBeanMapper caMapper;
	@Override
	public PageInfo<shopBean> findAll(BaseConditionVO vo) {
		PageHelper.startPage(vo.getPageNum(),vo.getPageSize());
		List<shopBean> list=shopMapper.findAll(vo);
		PageInfo<shopBean> pageinfo=new PageInfo<shopBean>(list);
		return pageinfo;
	}
	@Override
	public Long deleteByShopid(Long shopid) {
		BaseConditionVO vo =new BaseConditionVO();
		vo.setKeywordsauid(shopid);
		List<productBean> list = productMapper.findByShopid(vo);
		productBean bean=new productBean();
		for(int i=0;i<list.size();i++){
			bean=list.get(i);
			if(bean.getStatus()==1){
			productMapper.deleteBypid(bean.getPid());
			}
			Long p=bean.getPid();
			BaseConditionVO vo1 =new BaseConditionVO();
			vo1.setKeywordsauid(p);
			List<caseBean>list1=caMapper.findById(vo1);
			caseBean cbean=new caseBean();
			for(int j=0;j<list1.size();j++){
				cbean=list1.get(j);
				if(cbean.getStatus()==1){
				caMapper.deleteBypid(cbean.getProductid());
				}
			}
		}
		return shopMapper.deleteByShopid(shopid);
	}
	
	
	@Override
	public int inset(shopBean shop) {
		shop.setMtime(Time.getTime());
		shop.setShopid(Time.getId());
		shop.setStatus(1);
		return shopMapper.insertSelective(shop);
	}
	
	@Override
	public int updateShop(shopBean shop) {
		shopBean sp= shopMapper.selectByPrimaryKey(shop.getShopid());
		upBean shopup=new upBean();
		int a=0;
		if(shop.getChannel()==sp.getChannel() || shop.getChannel().equals(sp.getChannel())){
		}else{
			shopup.setShopid(shop.getShopid());
			shopup.setShopname(shop.getShopname());
			shopup.setOldchannel(sp.getChannel());
			shopup.setXchannel(shop.getChannel());
			shopup.setCtime(Time.getTime());
			a++;
		}
		if(shop.getPcurl()==sp.getPcurl() || shop.getPcurl().equals(sp.getPcurl())){
		}else{
			shopup.setShopid(shop.getShopid());
			shopup.setShopname(shop.getShopname());
			shopup.setOldshopurl(sp.getPcurl());
			shopup.setXshopurl(shop.getPcurl());
			shopup.setCtime(Time.getTime());
			a++;
		}
		if(shop.getAppurl()==sp.getAppurl() || shop.getAppurl().equals(sp.getAppurl())){
		}else{
			shopup.setShopid(shop.getShopid());
			shopup.setShopname(shop.getShopname());
			shopup.setOldappurl(sp.getAppurl());
			shopup.setXappurl(shop.getAppurl());
			shopup.setCtime(Time.getTime());
			a++;
		}
		if(a!=0){
			upMapper.insertSelective(shopup);
		}
		return shopMapper.updateByPrimaryKeySelective(shop);
	}
	@Override
	public shopBean findById(Long id) {
		
		return shopMapper.selectByPrimaryKey(id);
	}
	@Override
	public PageInfo<shopBean> findOld(BaseConditionVO vo) {
		
		PageHelper.startPage(vo.getPageNum(),vo.getPageSize());
		List<shopBean> list=shopMapper.findOld(vo);
		PageInfo<shopBean> pageinfo=new PageInfo<shopBean>(list);
		return pageinfo;
	
	}
	@Override
	public Long upByshopid(Long shopid) {
		BaseConditionVO vo =new BaseConditionVO();
		vo.setKeywordsauid(shopid);
		List<productBean> list = productMapper.findOldByShopid(vo);
		productBean bean=new productBean();
		for(int i=0;i<list.size();i++){
			bean=list.get(i);
			if(bean.getStatus()==2){
			productMapper.upBypid(bean.getPid());
			}
			Long p=bean.getPid();
			BaseConditionVO vo1 =new BaseConditionVO();
			vo1.setKeywordsauid(p);
			List<caseBean>list1=caMapper.findOldById(vo1);
			caseBean cbean=new caseBean();
			for(int j=0;j<list1.size();j++){
				cbean=list1.get(j);
				if(cbean.getStatus()==2){
				caMapper.upBypid(cbean.getProductid());
				}
			}
		}
		return  shopMapper.upByshopid(shopid);
	}
	@Override
	public shopBean selectByPrimaryKey(Long shopid) {
		// TODO Auto-generated method stub
		return shopMapper.selectByPrimaryKey(shopid);
	}
	
}
