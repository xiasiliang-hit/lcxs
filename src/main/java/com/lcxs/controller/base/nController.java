package com.lcxs.controller.base;

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
import com.lcxs.model.product.noteBean;
import com.lcxs.service.base.impl.noteServiceImpl;
import com.lcxs.utils.BaseConditionVO;
@Controller
@RequestMapping("/note")
public class nController {
	@Resource
	private noteServiceImpl noteService;
	
	@RequestMapping("/findAllNote")
	public String findAllNote(Model model,BaseConditionVO vo){
		PageInfo<noteBean> list = noteService.findAllNote(vo);
		model.addAttribute("pageModel",list);
		model.addAttribute("vo",vo);
		return "base/note";	
	}
	
	@RequestMapping("/deleteNote/{id}")
	public String deleteNote(Model model,@PathVariable Integer id){
		noteService.deleteNoteById(id);
		return "forward:/note/findAllNote";	
	}
	
	@RequestMapping("/goToAdd")
	public String goToAdd(BaseConditionVO vo,Model model){
		return "base/addOrUpdateNote";
	}
	@RequestMapping("/goToUpdate/{id}")
	public String goToUpdateStaff(@PathVariable Integer id,Model model){
		noteBean note=noteService.findNoteById(id);
		model.addAttribute("note",note);
		return "base/addOrUpdateNote";
	}
	
	@RequestMapping("/addOrUpdate")
	public String addOrUpdate(noteBean note){
		if(note.getId()==null||note.getId().equals("")){
			noteService.addNote(note);
			return "forward:/note/findAllNote";
		}
		noteService.updateNote(note);
		return "forward:/note/findAllNote";	
	}
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
       boolean b = noteService.batchImport(name,file);
       if(b){
            String Msg ="批量导入EXCEL成功！";
            return "redirect:/note/findAllNote";
       }else{
            String Msg ="批量导入EXCEL失败！";
            return "";
       } 
	}
	
	
}
