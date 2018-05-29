package com.lcxs.service.product;



import com.github.pagehelper.PageInfo;
import com.lcxs.model.product.productBean;
import com.lcxs.model.product.shopBean;
import com.lcxs.utils.BaseConditionVO;

public interface ICShopService {
	PageInfo<shopBean> findAll(BaseConditionVO vo);
	
	Long deleteByShopid(Long shopid);
	
	int inset(shopBean shop);
	
	int updateShop(shopBean shop);
	
	shopBean findById(Long id);
	PageInfo<shopBean> findOld(BaseConditionVO vo);
	/**
	 * 上架产品信息
	 * @param pid
	 * @return
	 */
	Long upByshopid(Long shopid);
	/**
	 * 根据id查找产品信息
	 * @param id
	 * @return
	 */
	shopBean  selectByPrimaryKey(Long shopid);
}
