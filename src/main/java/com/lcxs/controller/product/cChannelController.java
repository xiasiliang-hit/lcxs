package com.lcxs.controller.product;

import javax.annotation.Resource;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.github.pagehelper.PageInfo;
import com.lcxs.model.product.channelBean;
import com.lcxs.service.product.IChannelService;
import com.lcxs.utils.BaseConditionVO;

@Controller
@RequestMapping("/cchannel")
public class cChannelController {
	@Resource
	private IChannelService chService;
	@RequestMapping("/queryAll")
	@RequiresPermissions("CHANNEL_ALL")
	public String queryAll(Model model,BaseConditionVO vo){
		PageInfo<channelBean> list = chService.queryAll(vo);
		model.addAttribute("pageModel",list);
		model.addAttribute("vo",vo);
		return "product/cChannelList";
		
	}
	@RequestMapping("/deleteById/{id}")
	public String deleteById(@PathVariable Long id){
	       chService.deleteById(id);
		return "redirect:/cchannel/queryAll";
	}
	@RequestMapping("/insert")
	public String insert(channelBean record){
		if(record.getId()==null || record.getId().equals("") || record.getId()==0){
			chService.insertSelective(record);
		}else{
			chService.updateByPrimaryKeySelective(record);
		}
		return "redirect:/cchannel/queryAll";
	}
	@RequestMapping("/goToAdd")
	public String goToAdd(BaseConditionVO vo,Model model){
		PageInfo<channelBean> list = chService.queryAll(vo);
		model.addAttribute("pageModel",list);
		return "product/insertChannel";
	}
	@RequestMapping("/goToUpdate/{cid}")
	public String goToUpdate(@PathVariable Long cid,Model model,BaseConditionVO vo){
		channelBean c = chService.selectByCid(cid);
		PageInfo<channelBean> list = chService.queryAll(vo);
		model.addAttribute("pageModel",list);
		model.addAttribute("channel",c);
		return "product/insertChannel";
		
	}
}
