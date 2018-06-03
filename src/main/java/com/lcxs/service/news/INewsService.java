package com.lcxs.service.news;

import com.github.pagehelper.PageInfo;
import com.lcxs.model.news.newsBean;
import com.lcxs.utils.BaseConditionVO;


public interface INewsService {
    /*
    查找所有新闻信息
     */
    PageInfo<newsBean> queryAll(BaseConditionVO vo);
}
