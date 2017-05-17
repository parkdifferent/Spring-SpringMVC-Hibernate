package com.mangosis.ssh.dao;

import com.mangosis.ssh.entity.Test;
import org.omg.PortableInterceptor.USER_EXCEPTION;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by admin on 2017/5/8.
 */

@Repository
public interface TestDao extends CrudRepository<Test,Long>, TestDaoCustom  {

        List<Test> findByFirstName(String firstName);


        List<Test> findByFirstNameLike(String firstName, Pageable pageable);

        @Query("select t from com.mangosis.ssh.entity.Test t where second_name = ?1")
        List<Test> findBySec11NameLike(String second);

}
