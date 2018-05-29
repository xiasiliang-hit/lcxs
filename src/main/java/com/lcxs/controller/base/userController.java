package com.lcxs.controller.base;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.github.pagehelper.PageInfo;
import com.lcxs.model.base.bankBean;
import com.lcxs.model.base.friendMessage;
import com.lcxs.model.base.invitationBean;
import com.lcxs.model.base.userBean;
import com.lcxs.model.finance.receiptBean;
import com.lcxs.service.base.IUserService;
import com.lcxs.utils.BaseConditionVO;
import com.lcxs.utils.JsonResult;

@Controller
public class userController {
	@Resource
	private IUserService userService;
	//查找所有用户
	@RequestMapping("/user/findAll")
	@RequiresPermissions("USER_LOOK")
	public String findAll(Model model,BaseConditionVO vo){
		PageInfo<userBean> list = userService.findAll(vo);
		model.addAttribute("pageModel",list);
		model.addAttribute("vo",vo);
		return "base/jkUserList";
	}
	//根据vid冻结用户
	@RequestMapping("/user/deleteUser/{vid}")
	public String deleteUserByVid(@PathVariable Long vid){
		if(userService.deleteByVid(vid)){
			return "forward:/user/findAll";
		}
		return "forward:/user/findAll";
	}
	
	@RequestMapping("/admin")
	public String admin(){
		return "index";
	}
	//获取表单数据
	@RequestMapping("/user/getInvestmentTable/{vid}")
	public String getTable(Model model,BaseConditionVO vo,@PathVariable Long vid){
		vo.setKeywordsauid(vid);
		PageInfo<receiptBean> list = userService.findInvestment(vo);
		model.addAttribute("pageModel",list);
		model.addAttribute("vo",vo);
		return "base/investmentList";
	}
	@RequestMapping("/user/getBankInfo/{vid}")
	public String getBankInfo(Model model,BaseConditionVO vo,@PathVariable Long vid){
		vo.setKeywordsauid(vid);
		PageInfo<bankBean> list = userService.findBankByVid(vo);
		model.addAttribute("pageModel",list);
		model.addAttribute("vo",vo);
		return "base/bankList";
	}
	//邀请管理
	@RequestMapping("/user/invite")
	@RequiresPermissions("FRIENDS_LOOK")
	public String inviteTable(Model model,BaseConditionVO vo){
		PageInfo<friendMessage> list = userService.queryFriendMessage(vo);
		model.addAttribute("pageModel",list);
		model.addAttribute("vo",vo);
		return "base/inviteTable";	
	}
	//显示好友信息
	@RequestMapping("/user/getFriendInfo/{vid}")
	public String getFriendInfo(Model model,BaseConditionVO vo,@PathVariable Long vid){
		vo.setVid(vid);
		PageInfo<userBean> list =userService.findFriendInfo(vo);
		model.addAttribute("pageModel",list);
		model.addAttribute("vo",vo);
		return "base/friendInfo";
	}
	//显示用户绑卡信息
	@RequestMapping("/user/userBank")
	@RequiresPermissions("USER_BANK")
	public String getBankInfo(Model model,BaseConditionVO vo){
		PageInfo<userBean> list = userService.findAll(vo);
		model.addAttribute("pageModel",list);
		model.addAttribute("vo",vo);
		return "base/userBank";
	}
	//删除银行卡
	@RequestMapping("/user/deleteBank/{id}/{vid}")
	public String deleteBank(@PathVariable Long id,@PathVariable Long vid){
		String url="forward:/user/getBankInfo/"+vid;
		userService.deleteBank(id);
		return url;	
	}
	//重置密码
	@RequestMapping("/user/changePwd")
	@ResponseBody
	public JsonResult changePwd(HttpServletRequest request){
		JsonResult json=new JsonResult();
		String password=request.getParameter("pass");
		Long vid=Long.parseLong(request.getParameter("vid"));
		if(userService.updatePwd(password, vid)){
			return json;
		}
		json.setResult(2);
		json.setMessage("服务器繁忙");
		return json;
	}
	@RequestMapping("/user/payMoneyForUser")
	public void payMoneyForUser(HttpServletResponse response,@RequestBody invitationBean invi){
		userService.payMoneyForUser(response,invi);
	}
	
	@RequestMapping("/user/excelDownloadUser")
	public void excelDownloadUser(HttpServletResponse response,BaseConditionVO vo) throws Exception{
		userService.excelDownloadUser(response,vo);
	}
}
