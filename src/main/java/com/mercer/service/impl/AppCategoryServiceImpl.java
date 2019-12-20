package com.mercer.service.impl;

import com.mercer.mapper.AppCategoryMapper;
import com.mercer.pojo.AppCategory;
import com.mercer.service.AppCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ Date:2019/4/16
 * Auther:Mercer
 * Auther:麻前程
 */
@Service("appCategoryService")
public class AppCategoryServiceImpl implements AppCategoryService {

    @Autowired
    private AppCategoryMapper appCategoryMapper;

    @Override
    public List<AppCategory> queryAppCategoriesLevelOne() {
        return appCategoryMapper.queryAppCategoriesLevelOne();
    }

    @Override
    public List<AppCategory> queryLevelByParentId(Long id) {
        return appCategoryMapper.queryLevelByParentId(id);
    }

}
