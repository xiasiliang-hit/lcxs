package com.lcxs.service.product;

import org.springframework.web.multipart.MultipartFile;

import com.github.pagehelper.PageInfo;
import com.lcxs.model.product.productBean;
import com.lcxs.utils.BaseConditionVO;

public interface ICProductService {
	/**
	 * 根据商户id查找产品全部信息
	 * @param vo
	 * @return
	 */
	PageInfo<productBean> findByShopid(BaseConditionVO vo);
	/**
	 * 根据产品id删除信息
	 * @param pid
	 * @return
	 */
	Long deleteBypid(Long pid);
	/**
	 * 添加产品信息
	 * @param product
	 * @param key
	 * @return
	 */
	int inset(productBean product,Long key);
	/**
	 * 修改产品信息
	 * @param product
	 * @return
	 */
	int updateProduct(productBean product,Long key);
	/**
	 * 根据id查找产品信息
	 * @param id
	 * @return
	 */
	productBean  selectByPrimaryKey(Long id);
	/**
	 * 根据商户id查找产品历史信息
	 * @param vo
	 * @return
	 */
	PageInfo<productBean> findOldByShopid(BaseConditionVO vo);
	boolean batchImport(String name,MultipartFile file);
	/**
	 * 查找产品全部信息
	 * @param vo
	 * @return
	 */
	PageInfo<productBean> findAll(BaseConditionVO vo);
	/**
	 * 上架产品信息
	 * @param pid
	 * @return
	 */
	Long upBypid(Long pid);
	PageInfo<productBean> findOld(BaseConditionVO vo);
}
