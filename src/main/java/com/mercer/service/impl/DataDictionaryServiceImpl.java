package com.mercer.service.impl;

import com.mercer.mapper.DataDictionaryMapper;
import com.mercer.pojo.DataDictionary;
import com.mercer.service.DataDictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ Date:2019/4/16
 * Auther:Mercer
 * Auther:麻前程
 */
@Service("dataDictionaryService")
public class DataDictionaryServiceImpl implements DataDictionaryService {

    @Autowired
    DataDictionaryMapper dataDictionaryMapper;
    @Override
    public List<DataDictionary> queryAllStatus() {
        return dataDictionaryMapper.queryAllStatus();
    }

    @Override
    public List<DataDictionary> queryAllFlatforms() {
        return dataDictionaryMapper.queryAllFlatforms();
    }
}
