package com.lcxs.service.product;

import org.springframework.web.multipart.MultipartFile;

import com.github.pagehelper.PageInfo;
import com.lcxs.model.product.caseBean;
import com.lcxs.utils.BaseConditionVO;

public interface ICCaseService {
	PageInfo<caseBean> findById(BaseConditionVO vo);
	int deleteByid(Long id);
	int inset(caseBean c,Long key);
	int  updateCase(caseBean c);
	caseBean selectByPrimaryKey(Long id);
	 /**
     * 根据产品名称和方案id查找方案
     */
    caseBean selectCaseByProjectAndCid(BaseConditionVO vo);
    PageInfo<caseBean> findOldById(BaseConditionVO vo);
    int upByid(Long id);
    int deleteBypid(Long productid);
    int upBypid(Long productid);
}
