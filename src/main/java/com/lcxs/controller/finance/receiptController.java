package com.lcxs.controller.finance;


import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.github.pagehelper.PageInfo;
import com.lcxs.model.base.bankBean;
import com.lcxs.model.base.userBean;
import com.lcxs.model.finance.UserReceiptBean;
import com.lcxs.model.finance.receiptBean;
import com.lcxs.service.base.IUserService;
import com.lcxs.service.finance.IReceiptService;
import com.lcxs.service.finance.IUserReceiptService;
import com.lcxs.utils.BaseConditionVO;

@Controller
@RequestMapping("/receipt")
public class receiptController {

	@Resource
	private IReceiptService receiptService;
	@Resource
	private IUserService userService;
	@Resource
	private IUserReceiptService urService;
	
	@RequestMapping("/queryAll/{status}")
	@RequiresPermissions("RECEIPT_LOOK")
	public String queryAll(Model model,BaseConditionVO vo,@PathVariable int status){
		vo.setKeywordsstatus(status);
		PageInfo<receiptBean> list = receiptService.queryAll(vo);
		model.addAttribute("pageModel",list);
		model.addAttribute("vo",vo);
		switch (status) {
		case 1:
			return "finance/passReceiptList";
		case 2:
			return "finance/rejectReceiptList";
		case 3:
			return "finance/receiptList";
		case 4:
			return "finance/moneyReceiptList";
		case 5:
			return "finance/deleteReceiptList";
		default:
			break;
		}
		return "";
	}
	
	@RequestMapping("/deleteReceipt")
	public void deleteReceipt(@RequestBody receiptBean receipt,HttpServletResponse response){
		receiptService.updateTodelete(receipt, response);
	}
	
	@RequestMapping("/rejectReceipt")
	public void rejectReceipt(@RequestBody receiptBean receipt,HttpServletResponse response){
		receiptService.updateToReject(receipt, response);
	}
	@RequestMapping("/passReceipt")
	public void passReceipt(@RequestBody receiptBean receipt,HttpServletResponse response){
		receiptService.updateToPass(receipt, response);	
	}
	@RequestMapping("/moneyReceipt")
	public void moneyReceipt(receiptBean receipt,HttpServletResponse response){
		receiptService.updateToMoney(receipt,response);
	}
	
	@RequestMapping("/queryByRid/{rid}")
	public String queryByRid(@PathVariable Long rid,Model model){
		UserReceiptBean ur = urService.selectByRid(rid);
		userBean user = userService.findUserByVid(ur.getVid());
		model.addAttribute("user",user);
		bankBean bank = userService.queryBankByVid(ur.getVid());
		model.addAttribute("bank",bank);
		receiptBean receipt = receiptService.selectByRid(rid);
		model.addAttribute("receipt",receipt);
		return "finance/receiptdetail";
	}

	@RequestMapping("/queryReceiptData")
	public String queryReceiptData(BaseConditionVO vo,Model model){
		PageInfo<receiptBean> list=urService.queryReceiptData(vo);

		model.addAttribute("pageModel",list);
		model.addAttribute("vo",vo);
		return "finance/streceiptList";
	}
	
	@RequestMapping("/queryAnyDayOfReceipt/{start}/{end}/{status}")
	public String queryAnyDayOfReceipt(@PathVariable int status,@PathVariable String start,@PathVariable String end,Model model,BaseConditionVO vo){
		vo.setKeywordsname(start);
		vo.setKeywordsnumber(end);
		vo.setKeywordsstatus(status);
		PageInfo<receiptBean> list = receiptService.queryAnyDayOfReceipt(vo);
		model.addAttribute("pageModel",list);
		model.addAttribute("vo",vo);
		switch (status) {
		case 1:
			return "finance/passReceiptList";
		case 2:
			return "finance/rejectReceiptList";
		case 3:
			return "finance/receiptList";
		case 4:
			return "finance/moneyReceiptList";
		case 5:
			return "finance/deleteReceiptList";
		default:
			break;
		}
		return "";
	}
	
	@RequestMapping("/excelDowloadreceipt/{status}/{start}/{end}")
	public void excelDowloadreceipt(HttpServletResponse response,BaseConditionVO vo,@PathVariable int status,@PathVariable String start,@PathVariable String end)throws Exception{
		receiptService.excelDowloadReceipt(status,start,end,vo,response);
	}
	
	@RequestMapping("/rejectToReceipt")
	public void rejectToReceipt(@RequestBody receiptBean receipt,HttpServletResponse response){
		receiptService.updateToReceipt(receipt, response);
	}
	
	@RequestMapping("/listUpdateToReceipt")
	public void listUpdateToReceipt(@RequestBody Object rid[],HttpServletResponse response){
		receiptService.listUpdateToReceipt(rid, response);
	}
	
	
	
	
	
}
