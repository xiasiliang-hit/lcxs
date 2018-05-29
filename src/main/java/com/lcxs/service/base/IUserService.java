package com.lcxs.service.base;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.multipart.MultipartFile;

import com.github.pagehelper.PageInfo;
import com.lcxs.model.base.bankBean;
import com.lcxs.model.base.friendMessage;
import com.lcxs.model.base.invitationBean;
import com.lcxs.model.base.userBean;
import com.lcxs.model.finance.receiptBean;
import com.lcxs.utils.BaseConditionVO;

public interface IUserService {
	PageInfo<userBean> findAll(BaseConditionVO vo);//显示全体用户信息
	userBean findUserByVid(Long vid);//根据vid查找用户
	boolean deleteByVid(Long vid);//根据vid冻结用户
	boolean updateUserByVid(userBean user);//根据vid修改用户信息
	PageInfo<receiptBean> findInvestment(BaseConditionVO vo);//查找用户投资清单
	PageInfo<bankBean> findBankByVid(BaseConditionVO vo);//查找用户绑定的银行卡
	PageInfo<userBean> findFriendInfo(BaseConditionVO vo);//根据vid查找好友信息
	
	boolean deleteBank(Long id);//根据银行账号删除银行信息
	PageInfo<userBean> findATodayR(BaseConditionVO vo);//查询今日注册用户
	boolean updatePwd(String pwd,Long vid);//重置用户密码
	/**
     * 查询所有邀请人信息
     */
	PageInfo<friendMessage> queryFriendMessage(BaseConditionVO vo);
	/**
	 * 给用户打款
	 */
	void payMoneyForUser(HttpServletResponse response,invitationBean invi);
	boolean batchImport(String name,MultipartFile file);
	/**
     * 根据用户vid查询银行卡信息
     */
    bankBean  queryBankByVid(Long vid);
    public void excelDownloadUser(HttpServletResponse response,BaseConditionVO vo) throws Exception;
	/**
	 * 根据vid修改邀请码
	 */
	boolean  updateOwnByVid(long vid);
	
}
