package com.mangosis.ssh.dao.impl;

import com.mangosis.ssh.dao.TestDao;
import com.mangosis.ssh.dao.TestDaoCustom;
import com.mangosis.ssh.entity.Test;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * Created by admin on 2017/5/11.
 */

@Service
@Qualifier("testDaoImpl")
public class TestDaoImpl  implements TestDaoCustom {

    @PersistenceContext
    private EntityManager em;


    @Override
    public List<Test> selectByFirstNameLike(String firstName, Pageable pageable) {

        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery<Test> criteriaQuery = criteriaBuilder.createQuery(Test.class);
        Root<Test> p = criteriaQuery.from(Test.class);

        Test test = new Test();

        Predicate predicate = criteriaBuilder.like(p.get("firstName"),"%"+firstName+"%");   //condition
        criteriaQuery.where(predicate);
        Sort.Order order = new Sort.Order(Sort.Direction.DESC,"id");
        TypedQuery<Test> q = em.createQuery(criteriaQuery);
        List<Test> resultList =  q.getResultList();
        return resultList;

    }
}
