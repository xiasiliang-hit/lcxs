package com.lcxs.controller.product;

import java.io.IOException;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.github.pagehelper.PageInfo;
import com.lcxs.model.product.bannerBean;
import com.lcxs.service.product.ICBannerService;
import com.lcxs.utils.BaseConditionVO;

@Controller
@RequestMapping("/cbanner")
public class cBannerController {
	@Resource
	private ICBannerService bService;
	@RequestMapping("/findAll")
	public String findAll(Model model,BaseConditionVO vo){
		PageInfo<bannerBean> list = bService.findAll(vo);
		model.addAttribute("pageModel",list);
		model.addAttribute("vo",vo);
		return "product/cBannerList";
	}
	@RequestMapping("/deleteByid/{id}")
	public String deleteByid(@PathVariable int id){
		 bService.deleteByid(id);
		return "redirect:/cbanner/findAll";
	}
	@RequestMapping("/insertBanner")
	public String insert(bannerBean banner){
		if(banner.getId()==null || banner.getId().equals("") || banner.getId()==0){
			bService.inset(banner);
		}else{
			bService.updateBanner(banner);
		}
		return "redirect:/cbanner/findAll";
	}
	@RequestMapping("/goToAdd")
	public String goToAdd(BaseConditionVO vo,Model model){
		return "product/insertBanner";
	}
	@RequestMapping("/goToUpdate/{id}")
	public String goToUpdate(@PathVariable int id,Model model,BaseConditionVO vo){
		bannerBean banner = bService.findByid(id);
		model.addAttribute("banner",banner);
		return "product/insertBanner";
		
	}
}
