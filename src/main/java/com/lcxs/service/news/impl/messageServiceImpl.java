package com.lcxs.service.news.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lcxs.model.news.messageBean;
import com.lcxs.service.news.IMessageService;
import com.lcxs.utils.BaseConditionVO;
import com.lcxs.mapper.news.messageBeanMapper;
import com.lcxs.utils.Time;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class messageServiceImpl implements IMessageService {
	@Resource
	private messageBeanMapper meMapper;

	@Override
	public PageInfo<messageBean> findAll(BaseConditionVO vo) {
		PageHelper.startPage(vo.getPageNum(),vo.getPageSize());
		List<messageBean> list=meMapper.findAllMessage(vo);
		PageInfo<messageBean> pageinfo=new PageInfo<messageBean>(list);
		return pageinfo;
	}

	@Override
	public int addMessage(messageBean message) {
		String ctime= Time.getTime();
		message.setCtime(ctime);
		return meMapper.insert(message);
	}

	@Override
	public int updateMessage(messageBean message) {
		return meMapper.updateByPrimaryKeySelective(message);
	}
	@Override
	public messageBean findMessageById(Long id) {
		return meMapper.selectByPrimaryKey(id);
	}
	public int deleteMessageById(Long id){
		return meMapper.deleteById(id);
	}
}
