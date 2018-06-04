package com.lcxs.controller.finance;

import javax.annotation.Resource;

import com.lcxs.model.base.friendMessage;
import com.lcxs.model.base.invitationBean;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.github.pagehelper.PageInfo;
import com.lcxs.model.finance.TsBean;
import com.lcxs.service.base.IUserService;
import com.lcxs.service.finance.ITsService;
import com.lcxs.service.finance.IUserTsService;
import com.lcxs.utils.BaseConditionVO;
@Controller
@RequestMapping("/ts")
public class TsController {
	@Resource
	private ITsService tsService;
	@Resource
	private IUserService userService;
	@Resource
	private IUserTsService utService;
	//显示Ts信息
		@RequestMapping("/getTsInfo")
		public String queryTs(Model model,BaseConditionVO vo){
			PageInfo<friendMessage> list = tsService.queryTs(vo);
			model.addAttribute("pageModel",list);
			model.addAttribute("vo",vo);
			return "finance/tsInfoList";
		}
		@RequestMapping("/getTsInfo/{vid}")
		public String queryAll(Model model,BaseConditionVO vo,@PathVariable Long vid){
			vo.setVid(vid);
			PageInfo<TsBean> list =tsService.queryAll(vo);
			model.addAttribute("pageModel",list);
			model.addAttribute("vo",vo);
			return "finance/tsInfoList";
		}
		@RequestMapping("/passMoney/{tsid}")
	    public void updatePassMoney(@PathVariable String tsid){
		   tsService.updatePassMoney(tsid);
		}

	
}
