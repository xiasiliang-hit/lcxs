package com.lcxs.service.news;

import com.github.pagehelper.PageInfo;
import com.lcxs.model.news.newsBean;
import com.lcxs.utils.BaseConditionVO;


public interface INewsService {
    /*
    查找所有新闻信息
     */
    PageInfo<newsBean> queryAll(BaseConditionVO vo);

    //根据编号删除新闻
    Long deleteByNewsid(Long id);
    //增加新闻
    int insert(newsBean news);
    //根据编号查找新闻
    newsBean findByid(Long id);
    //修改新闻
    int update(newsBean news);
}
