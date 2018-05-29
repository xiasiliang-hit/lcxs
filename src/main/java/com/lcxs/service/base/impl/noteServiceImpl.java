package com.lcxs.service.base.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lcxs.mapper.product.noteBeanMapper;
import com.lcxs.model.product.noteBean;
import com.lcxs.model.product.shopBean;
import com.lcxs.service.base.INoteService;
import com.lcxs.utils.BaseConditionVO;
import com.lcxs.utils.NoteExcel;
import com.lcxs.utils.ReadExcel;
import com.lcxs.utils.Time;
@Service
public class noteServiceImpl implements INoteService{
	@Resource
	private noteBeanMapper noteDao;
	@Override
	public PageInfo<noteBean> findAllNote(BaseConditionVO vo) {
		PageHelper.startPage(vo.getPageNum(),vo.getPageSize());
		List<noteBean> list=noteDao.findAllNote(vo);
		PageInfo<noteBean> pageinfo=new PageInfo<noteBean>(list);
		return pageinfo;
	}

	@Override
	public int deleteNoteById(Integer id) {
		return noteDao.deleteById(id);
	}
	@Override
	public int addNote(noteBean note) {	
		String ctime=Time.getTime();
		note.setCtime(ctime);
		note.setStatus(1);
		return noteDao.insertSelective(note);
	}

	@Override
	public int updateNote(noteBean note) {
		return noteDao.updateByPrimaryKeySelective(note);
	}

	@Override
	public noteBean findNoteById(Integer id) {
		return noteDao.selectByPrimaryKey(id);
	}

	@Override
	public boolean batchImport(String name, MultipartFile file) {
		int label=1;
		boolean b = false;		
	    //创建处理EXCEL
	    NoteExcel readExcel=new NoteExcel();
	    //解析excel，获取客户信息集合。
	    List<noteBean> list = readExcel.getExcelInfo(name,file,label);
	    if(list != null){
	        b = true;
	    }
	    for (int i = 0; i < list.size(); i++) {
			list.get(i).setCtime(Time.getTime());
			noteDao.insert((list.get(i)));
		}
		return b;
	}

}
