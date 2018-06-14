package com.lcxs.mapper.news;

import com.lcxs.model.news.messageBean;
import com.lcxs.utils.BaseConditionVO;

import java.util.List;

public interface messageBeanMapper {
    //查询所有消息
    List<messageBean> findAllMessage(BaseConditionVO vo);
    //插入新闻
    int insert(messageBean message);
    //更新新闻
    int updateByPrimaryKeySelective(messageBean message);
    //根据id查找消息
    messageBean selectByPrimaryKey(Long id);
    //根据id删除新闻
    int deleteById(Long id);
}
