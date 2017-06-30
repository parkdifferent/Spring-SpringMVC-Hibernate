package com.mangosis.ssh.service;

import com.mangosis.ssh.dao.TestDao;
import com.mangosis.ssh.entity.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by phoenix on 2017/6/22.
 */

@Service
public class MyTestService {

    @Autowired
    TestDao testDao;

    public List<Test> findAll() {
        return (List<Test>) testDao.findAll();
    }
}
