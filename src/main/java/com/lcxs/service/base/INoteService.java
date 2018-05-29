package com.lcxs.service.base;

import org.springframework.web.multipart.MultipartFile;

import com.github.pagehelper.PageInfo;
import com.lcxs.model.product.noteBean;
import com.lcxs.utils.BaseConditionVO;

public interface INoteService {
	 	PageInfo<noteBean> findAllNote(BaseConditionVO vo);//查找所有公告
	    int deleteNoteById(Integer id);//根据id冻结公告
	    int addNote(noteBean note);//添加公告 
	    int updateNote(noteBean note);//更新公告
	    noteBean findNoteById(Integer id);//根据id查找公告
	    boolean batchImport(String name,MultipartFile file);
}
