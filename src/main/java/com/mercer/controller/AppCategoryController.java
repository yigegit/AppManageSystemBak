package com.mercer.controller;

import com.mercer.pojo.AppCategory;
import com.mercer.service.AppCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @ Date:2019/4/16
 * Auther:Mercer
 * Auther:麻前程
 */
@Controller
@RequestMapping("/category")
public class AppCategoryController {

    @Autowired
    private AppCategoryService appCategoryService;

    @RequestMapping("/queryLevelTwoByLevelOne/{levelOneId}")
    @ResponseBody
    public List<AppCategory> queryLevelTwoByLevelOne(@PathVariable("levelOneId")Long id){
        List<AppCategory> levelTwo = appCategoryService.queryLevelByParentId(id);
        return levelTwo;
    }

    @RequestMapping("/queryLevelThreeByLevelTwo/{levelTwoId}")
    @ResponseBody
    public List<AppCategory> queryLevelThreeByLevelTwo(@PathVariable("levelTwoId")Long id){
        List<AppCategory> levelThree = appCategoryService.queryLevelByParentId(id);
        return levelThree;
    }

}
