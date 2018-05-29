package com.lcxs.service.product.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lcxs.mapper.product.caseBeanMapper;
import com.lcxs.mapper.product.productBeanMapper;
import com.lcxs.mapper.product.shopBeanMapper;
import com.lcxs.model.product.caseBean;
import com.lcxs.model.product.productBean;
import com.lcxs.model.product.shopBean;
import com.lcxs.service.product.ICProductService;
import com.lcxs.utils.BaseConditionVO;
import com.lcxs.utils.Time;
import com.lcxs.utils.product;

@Service
public class cProductServiceImpl implements ICProductService {
	@Resource
	private productBeanMapper pMapper;
	@Resource
	private shopBeanMapper sMapper;
	@Resource
	private caseBeanMapper cMapper;
	@Override
	public PageInfo<productBean> findByShopid(BaseConditionVO vo) {
		PageHelper.startPage(vo.getPageNum(),vo.getPageSize());
		List<productBean> list=pMapper.findByShopid(vo);
		PageInfo<productBean> pageinfo=new PageInfo<productBean>(list);
		return pageinfo;
	}
	@Override
	public Long deleteBypid(Long pid) {
		BaseConditionVO vo =new BaseConditionVO();
		vo.setKeywordsauid(pid);
		List<caseBean> list = cMapper.findOldById(vo);
		for(int i=0;i<list.size();i++){
			caseBean bean=list.get(i);
			if(bean.getStatus()==1){
				cMapper.deleteBypid(bean.getProductid());
			}
		}
		return  pMapper.deleteBypid(pid);
	}
	@Override
	public int inset(productBean product,Long key) {
	
		product.setCtime(Time.getTime());
		product.setPid(Time.getId());
		shopBean shop=sMapper.selectByPrimaryKey(key);
		product.setShopname(shop.getShopname());
		product.setChannel(shop.getChannel());
		product.setShopid(key);
		product.setStatus(1);
		product.setChannel(shop.getChannel());
		return pMapper.insertSelective(product);
	}
	@Override
	public int updateProduct(productBean product,Long key) {
		product.setDtime(Time.getTime());
		shopBean shop=sMapper.selectByPrimaryKey(key);
		product.setShopname(shop.getShopname());
		product.setChannel(shop.getChannel());
		return pMapper.updateByPrimaryKeySelective(product);
	}
	@Override
	public productBean  selectByPrimaryKey(Long id) {
		return pMapper.selectByPrimaryKey(id);
	}
	@Override
	public PageInfo<productBean> findOldByShopid(BaseConditionVO vo) {
		PageHelper.startPage(vo.getPageNum(),vo.getPageSize());
		List<productBean> list=pMapper.findOldByShopid(vo);
		PageInfo<productBean> pageinfo=new PageInfo<productBean>(list);
		return pageinfo;
	}
	@Override
	public boolean batchImport(String name, MultipartFile file) {
		int label=1;
		boolean b = false;		
	    //创建处理EXCEL
	    product pro=new product();
	    //解析excel，获取客户信息集合。
	    List<productBean> list = pro.getExcelInfo(name,file,label);
	    if(list != null){
	        b = true;
	    }
	    for (int i = 0; i < list.size(); i++) {
			list.get(i).setCtime(Time.getTime());
			list.get(i).setDtime(Time.getTime());
			pMapper.insert((list.get(i)));
		}
		return b;
	}
	@Override
	public PageInfo<productBean> findAll(BaseConditionVO vo) {
		PageHelper.startPage(vo.getPageNum(),vo.getPageSize());
		List<productBean> list=pMapper.findAll(vo);
		PageInfo<productBean> pageinfo=new PageInfo<productBean>(list);
		return pageinfo;
	}
	@Override
	public Long upBypid(Long pid) {
		BaseConditionVO vo =new BaseConditionVO();
		vo.setKeywordsauid(pid);
		List<caseBean> list = cMapper.findById(vo);
		for(int i=0;i<list.size();i++){
			caseBean bean=list.get(i);
			if(bean.getStatus()==2){
				bean.setStatus(1);
			}
		}
		return  pMapper.upBypid(pid);
	}
	@Override
	public PageInfo<productBean> findOld(BaseConditionVO vo) {
		PageHelper.startPage(vo.getPageNum(),vo.getPageSize());
		List<productBean> list=pMapper.findOld(vo);
		PageInfo<productBean> pageinfo=new PageInfo<productBean>(list);
		return pageinfo;
	}
	
}
