package com.lcxs.controller.news;
import javax.annotation.Resource;

import com.lcxs.service.news.INewsService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.github.pagehelper.PageInfo;
import com.lcxs.model.news.newsBean;
import com.lcxs.service.news.INewsService;
import com.lcxs.utils.BaseConditionVO;
@Controller
@RequestMapping("/news")
public class newsController {
    @Resource
    private INewsService nService;

    @RequestMapping("/findAll")
    @RequiresPermissions("NEWS_ALL")
    public String findAll(Model model,BaseConditionVO vo){
        PageInfo<newsBean> list = nService.queryAll(vo);
        model.addAttribute("pageModel",list);
        model.addAttribute("vo",vo);
        return "news/newsList";
    }

    @RequestMapping("/deleteByNewsid/{id}")
    public String deleteByNewsid(@PathVariable Long id){
        nService.deleteByNewsid(id);
        return "redirect:/news/findAll";
    }
    @RequestMapping("/goToAdd")
    public String goToAdd(BaseConditionVO vo,Model model){
        return "news/insert";
    }
    @RequestMapping("/insert")
    public String insert(newsBean news){
        if(news.getId()==null||news.getId().equals("")) {
            nService.insert(news);
            return "redirect:/news/findAll";
        }else{
            nService.update(news);
            return "redirect:/news/findAll";
        }
    }
    @RequestMapping("/goToUpdate/{id}")
    public String goToUpdate(@PathVariable long id,Model model){
        newsBean news = nService.findByid(id);
        model.addAttribute("news",news);
        return "news/insert";
    }
    @RequestMapping("/findByid/{id}")
    public String findByid(@PathVariable long id,Model model){
        newsBean news = nService.findByid(id);
        model.addAttribute("news",news);
        return "news/newsDetails";
    }
}
