package com.lcxs.mapper.news;

import com.lcxs.model.news.newsBean;
import com.lcxs.utils.BaseConditionVO;

import java.util.List;

public interface newsBeanMapper {

//查询所有新闻信息
    List<newsBean> queryAll(BaseConditionVO vo);
//根据编号删除新闻
    Long deleteByNewsid(Long id);
//新建新闻
    int insert(newsBean news);
 //根据编号查找新闻
    newsBean findByid(Long id);
 //修改新闻
    int update(newsBean news);
}