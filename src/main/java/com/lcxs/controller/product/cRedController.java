package com.lcxs.controller.product;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import com.lcxs.model.base.userBean;
import com.lcxs.model.base.userRedBean;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.github.pagehelper.PageInfo;
import com.lcxs.model.product.productBean;
import com.lcxs.model.product.redBean;
import com.lcxs.service.product.ICRedService;
import com.lcxs.utils.BaseConditionVO;

@Controller
@RequestMapping("/cred")
public class cRedController {
	@Resource
	private ICRedService rService;
	@RequestMapping("/findAll")
	@RequiresPermissions("RED_LOOK")
	public String findAll(Model model,BaseConditionVO vo){
		PageInfo<redBean> list = rService.findAll(vo);
		model.addAttribute("pageModel",list);
		model.addAttribute("vo",vo);
		return "product/cRedList";
	} 
	@RequestMapping("/deleteByRedid/{redid}")
	public String deleteByRedid(@PathVariable Long redid){
		
		 rService.deleteByRedid(redid);
		return "redirect:/cred/findAll";
	}
	@RequestMapping("/insertRed")
	public String insert(redBean red){
		if(red.getId()==null || red.getId().equals("") || red.getId()==0){
			rService.inset(red);
		}else{
			rService.updateRed(red);
		}
		return "redirect:/cred/findAll";
	}



	@RequestMapping("/goToAdd")
	public String goToAdd(){
		return "product/insertRed";
	}
	@RequestMapping("/goToUpdate/{id}")
	public String goToUpdate(@PathVariable Long id,Model model){
		redBean red = rService.findById(id);
		model.addAttribute("red",red);
		return "product/insertRed";	
	}
	
	@RequestMapping("/goToSend")
	public String goToSend(Model model){
		model.addAttribute("list",rService.goToSend());
		return "product/sendred";
		
	}

	@RequestMapping("/bindingRed")
	public String bindingRed(redBean red){
		rService.bindingRed(red);
		return "redirect:/cred/findAll";
		
	}
	@RequestMapping("/upByRedid/{redid}")
	public String upByRedid(@PathVariable Long redid){
		
		rService.upByRedid(redid);
		return "redirect:/cred/findAll";
	}
	//发送 用户红包页面
	@RequestMapping("/goToSendUser")
	public String goToSendUser(Model model){
		model.addAttribute("list",rService.goToSend());
		return "product/insertRedToUser";

	}

	//用户红包新增
	@RequestMapping("/insertRedToUser/{sid}")
	public String insetUserRed(userBean userBean,userRedBean userRed,@PathVariable Long sid){

		rService.insetUserRed(userBean,userRed,sid);
		return "redirect:/cred/findAll";
	}


	//查看用户红包列表
	@RequestMapping("/findUserAll")
	@RequiresPermissions("RED_LOOK")
	public String findUserAll(Model model,BaseConditionVO vo){
		PageInfo<userRedBean> list = rService.findUserRedAll(vo);
		model.addAttribute("pageModel",list);
		model.addAttribute("vo",vo);
		return "product/cUserRedList";
	}

}
