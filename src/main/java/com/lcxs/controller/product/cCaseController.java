package com.lcxs.controller.product;


import javax.annotation.Resource;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.github.pagehelper.PageInfo;
import com.lcxs.model.product.caseBean;
import com.lcxs.service.product.ICCaseService;
import com.lcxs.utils.BaseConditionVO;

@Controller
@RequestMapping("/ccase")
public class cCaseController {
	@Resource
	private ICCaseService cService;
	
	@RequestMapping("/findById/{pid}")
	@RequiresPermissions("CASE_ALL")
	public String findById(Model model,BaseConditionVO vo,@PathVariable Long pid){
		vo.setKeywordsauid(pid);
		PageInfo<caseBean> list = cService.findById(vo);
		model.addAttribute("pageModel",list);
		model.addAttribute("vo",vo);
		return "product/cCaseList";
	}
	@RequestMapping("/findOldById/{pid}")
	public String findOldById(Model model,BaseConditionVO vo,@PathVariable Long pid){
		vo.setKeywordsauid(pid);
		PageInfo<caseBean> list = cService.findOldById(vo);
		model.addAttribute("pageModel",list);
		model.addAttribute("vo",vo);
		return "product/cCaseOldList";
	}
	@RequestMapping("/deleteByid/{id}/{key}")
	public String deleteByCid(@PathVariable Long id,@PathVariable Long key){
		cService.deleteByid(id);
		return "redirect:/ccase/findById/"+key;
	}
	@RequestMapping("/upByid/{id}/{key}")
	public String upByCid(@PathVariable Long id,@PathVariable Long key){
		cService.upByid(id);
		return "redirect:/ccase/findById/"+key;
	}
	@RequestMapping("/insertCase/{key}")
	public String insert(caseBean c,@PathVariable Long key){
		if(c.getId()==null || c.getId().equals("") || c.getId()==0){
			cService.inset(c,key);
		}else{
			cService.updateCase(c);
		}
		return "redirect:/ccase/findById/"+key;
	}
	@RequestMapping("/goToAdd/{key}")
	public String goToAdd(Model model,@PathVariable Long key,BaseConditionVO vo){
		vo.setKeywordsauid(key);
		model.addAttribute("vo",vo);
		return "product/insertCase";
	}
	@RequestMapping("/goToUpdate/{id}")
	public String goToUpdate(BaseConditionVO vo,Model model,@PathVariable Long id){
		caseBean c = cService.selectByPrimaryKey(id);
		vo.setKeywordsauid(c.getProductid());
		model.addAttribute("pcase",c);
		model.addAttribute("vo",vo);
		return "product/insertCase";
	}
}
