package com.mangosis.ssh.service;

import com.mangosis.ssh.entity.Test;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by admin on 2017/5/9.
 */

public interface TestService {

    List<Test> findByFirstName(String firstName);

    Test findById(Long id);

    Test updateById(Long id);

    void deleteById(Long id);

    List<Test> findAll();

    List<Test> findAll1();
}
