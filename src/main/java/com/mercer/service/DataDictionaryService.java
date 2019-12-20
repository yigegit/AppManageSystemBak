package com.mercer.service;

import com.mercer.pojo.DataDictionary;

import java.util.List;

/**
 * @ Date:2019/4/16
 * Auther:Mercer
 * Auther:麻前程
 */
public interface DataDictionaryService {
    List<DataDictionary> queryAllStatus();

    List<DataDictionary> queryAllFlatforms();
}
