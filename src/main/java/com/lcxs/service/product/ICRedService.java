package com.lcxs.service.product;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.lcxs.model.base.userBean;
import com.lcxs.model.base.userRedBean;
import com.lcxs.model.product.redBean;
import com.lcxs.utils.BaseConditionVO;

public interface ICRedService {

	PageInfo<redBean> findAll(BaseConditionVO vo);

	Long deleteByRedid(Long redid);

	int inset(redBean red);

	int insetUserRed(userBean userBean, userRedBean red,Long sid);

	int updateRed(redBean red);

	redBean findById(Long id);

	List<redBean> goToSend();

	void bindingRed(redBean red);

	Long upByRedid(Long redid);

	PageInfo<userRedBean> findUserRedAll(BaseConditionVO vo);
}
