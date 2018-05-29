package com.lcxs.controller.base;

import java.io.UnsupportedEncodingException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.lcxs.model.base.staffBean;
import com.lcxs.model.base.userBean;
import com.lcxs.service.base.impl.staffServiceImpl;
import com.lcxs.service.base.impl.userServiceImpl;
import com.lcxs.utils.BaseConditionVO;
import com.lcxs.utils.JsonResult;

@Controller
@RequestMapping("/staff")
public class staffController {
	@Resource
	private staffServiceImpl staffService;
	@Resource
	private userServiceImpl userService;
	@RequestMapping("/login")
	public String login(HttpServletRequest request, HttpServletResponse response,Model model) throws UnsupportedEncodingException{
		// 设置编码		
				String exceptionClassName = (String) request
						.getAttribute("shiroLoginFailure");
				System.err.println("异常==="+exceptionClassName);
				if(exceptionClassName!=null){
					if (UnknownAccountException.class.getName().equals(exceptionClassName)) {
						//throw new Exception("账号不存在");
						model.addAttribute("masg", "账号不存在");
					} else if (IncorrectCredentialsException.class.getName().equals(
							exceptionClassName)) {
						//throw new Exception("用户名/密码错误");
						model.addAttribute("masg", "用户名/验证码错误");
					} else {
						//throw new Exception();//最终在异常处理器生成未知错误
						model.addAttribute("masg", "未知错误");
					}
				}
							
		return "forward:/login.jsp";
		
	}
	//查找员工信息
	@RequestMapping("/findAll")
	@RequiresPermissions("STAFF_LOOK")
	public String findAll(Model model,BaseConditionVO vo){
		PageInfo<staffBean> list = staffService.findAll(vo);
		model.addAttribute("pageModel",list);
		model.addAttribute("vo",vo);
		return "base/staffList";
	}
	//冻结员工信息
	@RequestMapping("/deleteStaff/{sid}")
	public String deleteStaff(Model model, @PathVariable Long sid){
		staffService.deleteBySid(sid);
		return "forward:/staff/findAll";
	}
	@RequestMapping("/goToUpdateStaff/{sid}")
	public String goToUpdateStaff(@PathVariable Long sid,Model model){
		staffBean employee = staffService.findStaffBySid(sid);
		model.addAttribute("employee",employee);
		return "base/addOrUpdateStaff";
	}
	@RequestMapping("/goToAddStaff")
	public String goToAddStaff(){
		return "base/addOrUpdateStaff";
	}
	@RequestMapping("/addOrUpdateStaff")
	public String addOrUpdateStaff(staffBean staff){
		if(staff.getSid()==null || staff.getSid().equals("") || staff.getSid()==0){
			staffService.addStaff(staff);
		}else{
			staffService.updateByPrimaryKeySelective(staff);
		}
		return "forward:/staff/findAll";
	}
	
	//查找专属客户
	@RequestMapping("/findUserByStaffSid/{stype}/{sid}")
	@RequiresPermissions("OWN_ALL")
	public String findUserBySid(Model model,BaseConditionVO vo,@PathVariable int stype,@PathVariable Long sid){
		vo.setKeywordsstatus(stype);
		vo.setKeywordsauid(sid);
		staffBean staff=staffService.findStaffBySid(sid);
		String realname=staff.getRealname();
		if(stype==2){
			vo.setRealname(realname);
			PageInfo<userBean> list = staffService.findUserBySid(vo);
			model.addAttribute("pageModel",list);
			model.addAttribute("vo",vo);
			return "base/ExclusiveUser";
		}
		PageInfo<userBean> list = userService.findAll(vo);
		model.addAttribute("pageModel",list);
		model.addAttribute("vo",vo);
		return "base/ExclusiveUser";
	}
	//跳到添加客服页面
	@RequestMapping("inserEx")
	public String inserExclusive(Model model){
		model.addAttribute("list",staffService.findAllStaff());
		return "base/insertExclusive";
	}
	//绑定客服
	@RequestMapping("binding/{stype}/{sid}")
	public String binding(userBean user,@PathVariable int stype,@PathVariable Long sid){
		staffService.binding(user);
		return "redirect:/staff/findUserByStaffSid/"+stype+"/"+sid;
	}
	
	@RequestMapping("/change")
	@ResponseBody
	public JsonResult changePwd(HttpServletRequest request){
		JsonResult json=new JsonResult();
		String password=request.getParameter("pass");
		Long sid=Long.parseLong(request.getParameter("sid"));
		if(staffService.updatePwd(password, sid)){
			return json;
		}
		json.setResult(2);
		json.setMessage("服务器繁忙");
		return json;
	}
}
