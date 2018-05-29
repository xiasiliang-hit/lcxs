package com.lcxs.service.product;



import com.github.pagehelper.PageInfo;
import com.lcxs.model.product.upBean;
import com.lcxs.utils.BaseConditionVO;

public interface ICShopUpdateService {
	PageInfo<upBean> findAll(BaseConditionVO vo);
	
}
