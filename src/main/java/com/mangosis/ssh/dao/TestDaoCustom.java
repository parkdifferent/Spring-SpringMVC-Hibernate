package com.mangosis.ssh.dao;

import com.mangosis.ssh.entity.Test;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

/**
 * Created by admin on 2017/5/11.
 */
public interface TestDaoCustom {

    public List<Test> selectByFirstNameLike(String firstName, Pageable pageable);

}
