package com.lcxs.service.product;


import org.springframework.web.multipart.MultipartFile;

import com.github.pagehelper.PageInfo;
import com.lcxs.model.product.bannerBean;
import com.lcxs.utils.BaseConditionVO;

public interface ICBannerService {
	
    /**
     * 查询横幅全部信息
     * @param vo
     * @return
     */
    
	PageInfo<bannerBean> findAll(BaseConditionVO vo);
	/**
	 * 根据id删除信息
	 * @param shopid
	 * @return
	 */
	int deleteByid(int id);
	/**
	 * 增加横幅信息
	 * @param banner
	 * @return
	 */
	int inset(bannerBean banner);
	/**
	 * 根据id查信息
	 * @param id
	 * @return
	 */
	bannerBean findByid(int id);
	/**
	 * 修改信息
	 */
	int updateBanner(bannerBean banner);
}
