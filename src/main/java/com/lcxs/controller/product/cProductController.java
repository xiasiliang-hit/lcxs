package com.lcxs.controller.product;

import java.io.IOException;

import javax.annotation.Resource;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.github.pagehelper.PageInfo;
import com.lcxs.model.product.productBean;
import com.lcxs.model.product.shopBean;
import com.lcxs.service.product.ICProductService;
import com.lcxs.service.product.ICShopService;
import com.lcxs.utils.BaseConditionVO;

@Controller
@RequestMapping("/cproduct")
public class cProductController {
	@Resource
	private ICProductService pService;
	@Resource
	private ICShopService shopService;
	
	@RequestMapping("/findByShopid/{shopid}")
	@RequiresPermissions("PRODUCT_ALL")
	public String findByShopid(Model model,BaseConditionVO vo,@PathVariable Long shopid){
		vo.setKeywordsauid(shopid);
		shopBean shop = shopService.findById(shopid);
		PageInfo<productBean> list = pService.findByShopid(vo);
		model.addAttribute("pageModel",list);
		model.addAttribute("vo",vo);
		model.addAttribute("shop",shop);
		return "product/spxq";
	}
	@RequestMapping("/findAll")
	public String findAll(Model model,BaseConditionVO vo){
		PageInfo<productBean> list = pService.findAll(vo);
		model.addAttribute("pageModel",list);
		model.addAttribute("vo",vo);
		return "product/cProductList";
	}
	
	@RequestMapping("/findOldByShopid/{shopid}")
	public String findOldByShopid(Model model,BaseConditionVO vo,@PathVariable Long shopid){
		vo.setKeywordsauid(shopid);
		PageInfo<productBean> list = pService.findOldByShopid(vo);
		model.addAttribute("pageModel",list);
		model.addAttribute("vo",vo);
		return "product/cProductListOld";
	}
	
	@RequestMapping("/findOld")
	public String findOld(Model model,BaseConditionVO vo){
		PageInfo<productBean> list = pService.findOld(vo);
		model.addAttribute("pageModel",list);
		model.addAttribute("vo",vo);
		return "product/cProductListOld";
	}
	@RequestMapping("/deleteBypid/{pid}")
	public String deleteBypid(@PathVariable Long pid){
		productBean product = pService.selectByPrimaryKey(pid);
		pService.deleteBypid(pid);
		return "redirect:/cproduct/findByShopid/"+product.getShopid();
	}
	@RequestMapping("/upBypid/{pid}")
	public String upBypid(@PathVariable Long pid){
		productBean product = pService.selectByPrimaryKey(pid);
		pService.upBypid(pid);
		return "redirect:/cproduct/findByShopid/"+product.getShopid();
	}
	
	@RequestMapping("/insertProduct/{key}")
	public String insert(productBean product,@PathVariable Long key){
		if(product.getShopid()==null || product.getShopid().equals("") || product.getShopid()==0){
			pService.inset(product,key);
		}else{
			pService.updateProduct(product,key);
		}
		return "redirect:/cproduct/findByShopid/"+key;
	}
	@RequestMapping("/goToAdd/{key}")
	public String goToAdd(Model model,@PathVariable Long key,BaseConditionVO vo){
		vo.setKeywordsauid(key);
		model.addAttribute("vo",vo);
		return "product/insertProduct";
	}
	@RequestMapping("/goToUpdate/{pid}")
	public String goToUpdate(BaseConditionVO vo,Model model,@PathVariable Long pid){
		productBean product = pService.selectByPrimaryKey(pid);
		vo.setKeywordsauid(product.getShopid());
		model.addAttribute("product",product);
		model.addAttribute("vo",vo);
		return "product/insertProduct";
		
	}
	/**
	 * 将上传的excel文件获取并将内容更新到到数据库中
	 * @param upload 上传的文件数组，request页面的请求信息
	 * @return
	 * @throws IOException 
	 */
	@RequestMapping(value = "/inputExcel", method = RequestMethod.POST)
	 public String inputExcel(@RequestParam(value="filename") MultipartFile file) throws IOException{
        //判断文件是否为空
        if(file==null){
        	return null;
        }
        //获取文件名
        String name=file.getOriginalFilename();
    	
        //进一步判断文件是否为空（即判断其大小是否为0或其名称是否为null）
        long size=file.getSize();
        if(name==null || ("").equals(name) && size==0) {
        	return null;
        	}       
        //批量导入。参数：文件名，文件。
        boolean b = pService.batchImport(name,file);
        if(b){
             String Msg ="批量导入EXCEL成功！";
             return "redirect:/product/cShopList";
        }else{
             String Msg ="批量导入EXCEL失败！";
             return "";
        } 
	}
}
