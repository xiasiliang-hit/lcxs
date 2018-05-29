package com.lcxs.controller.product;





import javax.annotation.Resource;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.github.pagehelper.PageInfo;
import com.lcxs.model.product.upBean;
import com.lcxs.service.product.ICShopService;
import com.lcxs.service.product.ICShopUpdateService;
import com.lcxs.service.product.IChannelService;
import com.lcxs.utils.BaseConditionVO;

@Controller
@RequestMapping("/cshopUpdate")
public class cShopUpdateController {
	@Resource
	private ICShopUpdateService upService;
	@Resource
	private IChannelService channelService;
	@Resource
	private ICShopService cService;
	@RequestMapping("/findAll")
	@RequiresPermissions("SHOP_ALL")
	public String findAll(Model model,BaseConditionVO vo){
		PageInfo<upBean> list = upService.findAll(vo);
		model.addAttribute("pageModel",list);
		model.addAttribute("vo",vo);
		return "product/cShopUpList";
	}
	
}
