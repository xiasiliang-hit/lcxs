package com.lcxs.controller.product;





import javax.annotation.Resource;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.github.pagehelper.PageInfo;
import com.lcxs.model.product.channelBean;
import com.lcxs.model.product.productBean;
import com.lcxs.model.product.shopBean;
import com.lcxs.service.product.ICShopService;
import com.lcxs.service.product.IChannelService;
import com.lcxs.utils.BaseConditionVO;

@Controller
@RequestMapping("/cshop")
public class cShopController {
	@Resource
	private ICShopService cService;
	@Resource
	private IChannelService channelService;
	@RequestMapping("/findAll")
	@RequiresPermissions("SHOP_ALL")
	public String findAll(Model model,BaseConditionVO vo){
		PageInfo<shopBean> list = cService.findAll(vo);
		model.addAttribute("pageModel",list);
		model.addAttribute("vo",vo);
		return "product/cShopList";
	}
	@RequestMapping("/findOld")
	public String findOld(Model model,BaseConditionVO vo){
		PageInfo<shopBean> list = cService.findOld(vo);
		model.addAttribute("pageModel",list);
		model.addAttribute("vo",vo);
		return "product/cShopListOld";
	}
	
	@RequestMapping("/deleteByShopid/{shopid}")
	public String deleteByShopid(@PathVariable Long shopid){
		cService.deleteByShopid(shopid);
		return "redirect:/cshop/findAll";
	}
	@RequestMapping("/insert")
	public String insert(shopBean shop){
		if(shop.getId()==null || shop.getId().equals("") || shop.getId()==0){
			cService.inset(shop);
		}else{
			cService.updateShop(shop);
		}
		return "redirect:/cshop/findAll";
	}

	@RequestMapping("/goToAdd")
	public String goToAdd(BaseConditionVO vo,Model model){
		PageInfo<channelBean> list = channelService.queryAll(vo);
		model.addAttribute("pageModel",list);
		return "product/insert";
	}
	@RequestMapping("/goToUpdate/{id}")
	public String goToUpdate(@PathVariable Long id,Model model,BaseConditionVO vo){
		shopBean shop = cService.findById(id);
		PageInfo<channelBean> list = channelService.queryAll(vo);
		model.addAttribute("pageModel",list);
		model.addAttribute("shop",shop);
		return "product/insert";
	}
	@RequestMapping("/upByshopid/{shopid}")
	public String upByshopid(@PathVariable Long shopid){
		shopBean shop = cService.selectByPrimaryKey(shopid);
		cService.upByshopid(shopid);
		return "redirect:/cproduct/findByShopid/"+shop.getShopid();
	}

}
