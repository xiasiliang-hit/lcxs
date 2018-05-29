package com.lcxs.service.finance;




import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.github.pagehelper.PageInfo;
import com.lcxs.model.finance.receiptBean;
import com.lcxs.utils.BaseConditionVO;

public interface IReceiptService {
	/**
     * 查找全部回单
     */
    PageInfo<receiptBean> queryAll(BaseConditionVO vo);
    

    int insert(receiptBean record);

    int insertSelective(receiptBean record);

    receiptBean selectByRid(Long id);
    int updateByPrimaryKeySelective(receiptBean record);
    int updateByPrimaryKey(receiptBean record);
    /**
     * 未审核回单变成已通过
     */
    void updateToPass(receiptBean receipt,HttpServletResponse response);
    /**
     * 回单返回未审核
     */
    void updateToReceipt(receiptBean receipt,HttpServletResponse response);
    /**
     * 未审核回单变成已驳回
     */
    void updateToReject(receiptBean receipt,HttpServletResponse response);
    /**
     * 未审核回单变成已打款
     */
    void updateToMoney(receiptBean receipt,HttpServletResponse response);
    /**
     * 未审核回单变成已删除
     */
    void updateTodelete(receiptBean receipt,HttpServletResponse response);
    /**
     * 根据传入的时候查询这个时段的回单
     * @param vo keywrodsname=开始时间  keywordsnumber=结束时间 keywordsstaus=状态
     * @return
     */
    PageInfo<receiptBean> queryAnyDayOfReceipt(BaseConditionVO vo);
    /**
     * 查询今日打款人
     * @param vo
     * @return
     */
    PageInfo<receiptBean> queryToDayMoneyPerson(BaseConditionVO vo);
    /**
     * 查询今日打款金额
     * @param vo
     * @return
     */
    Double queryToDayMoney();
    /**
     * 根据日期导出回单excel
     */
    void excelDowloadReceipt(int status,String start,String end,BaseConditionVO vo,HttpServletResponse response) throws Exception;
    /**
     * 批量通过回单
     */
    void listUpdateToReceipt(Object rid[],HttpServletResponse response);
 
}
