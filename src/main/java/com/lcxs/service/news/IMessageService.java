package com.lcxs.service.news;
import com.github.pagehelper.PageInfo;
import com.lcxs.model.news.messageBean;
import com.lcxs.utils.BaseConditionVO;
public interface IMessageService {
    PageInfo<messageBean> findAll(BaseConditionVO vo);//获取消息列表
    int addMessage(messageBean message);//添加消息
    int updateMessage(messageBean message);//更新消息
    messageBean findMessageById(Long id);//根据id查找消息
    int deleteMessageById(Long id);//根据id 删除消息
}
