package com.mangosis.ssh.service.impl;

import com.google.code.ssm.api.*;
import com.mangosis.ssh.dao.TestDao;
import com.mangosis.ssh.entity.Test;
import com.mangosis.ssh.service.TestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by admin on 2017/5/9.
 */

@Service("testService")
public class TestServiceImpl implements TestService {

    private  static Logger logger = LoggerFactory.getLogger("TestServiceImpl");

    private static final String TEST_INFO_SSM  = "test_info_ssm";

    @Autowired
    TestDao testDao;



    public List<Test> findByFirstName(String firstName) {

        logger.info("findByFirstName, firstName = {}",firstName);
        logger.debug("新增宠物， pet = {}", firstName);
        return testDao.findByFirstName(firstName);
    }

    @ReadThroughSingleCache(namespace = TEST_INFO_SSM, expiration = 3600)    //s
    public Test findById(@ParameterValueKeyProvider Long id) {
        System.out.println("没有缓存命中");
        return testDao.findOne(id);
    }

    @UpdateSingleCache(namespace = TEST_INFO_SSM, expiration = 3600)
    @ReturnDataUpdateContent
    public Test updateById(@ParameterValueKeyProvider Long id) {             //Caused by: java.security.InvalidParameterException: No ReturnDataUpdateContent or ParameterDataUpdateContent annotation found on method [updateById]
        System.out.println("更新缓存");                                       //@ParameterValueKeyProvider: 标记将方法的参数做为计算缓存key.如果被其注解的对象有标记@CacheKeyMethod的getCacheKey()方法，
                                                                            // 这根据getCacheKey()方法生成缓存key。否则调用toString()生成
        Test test = testDao.findOne(id);
        test.setFirstName("firstName2");
        test.setSecondName("secondName3");
        Test test1= testDao.save(test);
        return test1;
    }

    //   ReturnDataUpdateContent   使用返回结果更新缓存
    //   ParameterDataUpdateContent 使用参数更新缓存

    //@ParameterDataUpdateContent：参数中的数据，作为更新缓存的数据
    //@ReturnDataUpdateContent：方法调用后返回的数据，作为更新缓存的数据，这上


    @InvalidateSingleCache(namespace = TEST_INFO_SSM)
    public void deleteById(@ParameterValueKeyProvider Long id) {
         testDao.delete(id);
    }


    //MultiCache 类
    //操作 List 型的 Cache 数据（看做是 SingleCache 的批处理），由 ParameterValueKeyProvider 和 CacheKeyMethod 来标识组装 key


    @Override
    public List<Test> findAll() {
        return (List<Test>) testDao.findAll();
    }
}
