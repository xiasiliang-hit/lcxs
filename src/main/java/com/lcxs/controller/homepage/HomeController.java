package com.lcxs.controller.homepage;

import javax.annotation.Resource;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.github.pagehelper.PageInfo;
import com.lcxs.model.base.userBean;
import com.lcxs.model.finance.receiptBean;
import com.lcxs.model.homepage.homeBean;
import com.lcxs.service.base.IUserService;
import com.lcxs.service.finance.IReceiptService;
import com.lcxs.service.finance.IUserReceiptService;
import com.lcxs.utils.BaseConditionVO;

@Controller
@RequestMapping("/homepage")
public class HomeController {
	@Resource
	private IReceiptService receiptService;
	@Resource
	private IUserService userService;

	@Resource
	private IUserReceiptService iuService;
	@RequestMapping("/query")
	@RequiresPermissions("HOME_LOOK")
	public String query(BaseConditionVO vo,Model model){
		PageInfo<userBean> list = userService.findAll(vo);
		PageInfo<receiptBean> ll = receiptService.queryToDayMoneyPerson(vo);
		Double money = receiptService.queryToDayMoney();
		PageInfo<userBean> ss = userService.findATodayR(vo);
		model.addAttribute("person",ss.getTotal());
		model.addAttribute("AllPerson",list.getTotal());
		model.addAttribute("moneyPerson",ll.getTotal());
		model.addAttribute("money",money);
		return "homepage/exhibition";
	}

	@RequestMapping("/findCaseInfo")
	public String findCaseInfo(BaseConditionVO vo,Model model){
		PageInfo<homeBean>list =iuService.queryActivityData(vo);
		model.addAttribute("pageModel",list);
		model.addAttribute("vo",vo);
		return "homepage/caseInfo";
		
	}
	@RequestMapping("/shopDateList")
	public String queryShopData(BaseConditionVO vo,Model model){
		PageInfo<homeBean> list= iuService.queryShopData(vo);
		model.addAttribute("pageModel",list);
		model.addAttribute("vo",vo);
		return "homepage/shopInfoList";
	}

}
