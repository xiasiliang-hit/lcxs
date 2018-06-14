package com.lcxs.controller.news;

import com.github.pagehelper.PageInfo;
import com.lcxs.service.news.impl.messageServiceImpl;
import com.lcxs.utils.BaseConditionVO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import com.lcxs.model.news.messageBean;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;

@Controller
@RequestMapping("/message")
public class messageController {
	@Resource
	private messageServiceImpl messageService;
	
	@RequestMapping("/findAll")
	public String findAllNote(Model model,BaseConditionVO vo){
		PageInfo<messageBean> list = messageService.findAll(vo);
		model.addAttribute("pageModel",list);
		model.addAttribute("vo",vo);
		return "news/message";
	}
	@RequestMapping("/goToAdd")
	public String goToAdd(BaseConditionVO vo,Model model){
		return "news/addOrUpdateMessage";
	}
	@RequestMapping("/addOrUpdate")
	public String addOrUpdate(messageBean message){
		if(message.getId()==null||message.getId().equals("")){
			messageService.addMessage(message);
			return "forward:/message/findAll";
		}
		messageService.updateMessage(message);
		return "forward:/message/findAll";
	}
	@RequestMapping("/goToUpdate/{id}")
	public String goToUpdate(@PathVariable Long id,Model model){
		messageBean message=messageService.findMessageById(id);
		model.addAttribute("message",message);
		return "news/addOrUpdateMessage";
	}
	@RequestMapping("/deleteMessage/{id}")
	public String deleteMessage(Model model,@PathVariable Long id){
		messageService.deleteMessageById(id);
		return "forward:/message/findAll";
	}
	
	
}
