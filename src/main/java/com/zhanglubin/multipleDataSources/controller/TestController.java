package com.zhanglubin.multipleDataSources.controller;

import com.zhanglubin.multipleDataSources.mapper.datasourceMyself.DataSourcesMyselfMapper;
import com.zhanglubin.multipleDataSources.mapper.datasourceWork.DataSourcesWorkMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author zhanglubin
 * @date 2021/2/19
 */
@RequestMapping("test")
@Controller
public class TestController {

    @Autowired
    private DataSourcesWorkMapper dataSourcesWorkMapper;

    @Autowired
    private DataSourcesMyselfMapper dataSourcesMyselfMapper;

    @RequestMapping("/1")
    public void testDataSources1() {
        String clientName = dataSourcesWorkMapper.getClientName();
        System.out.println(clientName);
    }

    @RequestMapping("/2")
    public void testDataSources2() {
        String username = dataSourcesMyselfMapper.getUsername();
        System.out.println(username);
    }
}

