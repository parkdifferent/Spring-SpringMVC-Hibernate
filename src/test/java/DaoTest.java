import com.mangosis.ssh.dao.TestDao;
import com.mangosis.ssh.dao.TestDaoCustom;
import com.mangosis.ssh.entity.Test;
import com.mangosis.ssh.service.TestService;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Iterator;
import java.util.List;

/**
 * Created by admin on 2017/5/8.
 */

@RunWith(SpringJUnit4ClassRunner.class)     //表示继承了SpringJUnit4ClassRunner类
@ContextConfiguration(locations = {"classpath:application.xml"})
public class DaoTest {

    @Autowired
    TestDao testDao;

    @Autowired
    TestService testService;

    @Qualifier("testDaoImpl")
    @Autowired
    TestDaoCustom testDaoCustom;



    @org.junit.Test
    public void test() {
        Iterable<Test> iterable =  testDao.findAll();
        Iterator<Test> iterator = iterable.iterator();
        while(iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    @org.junit.Test
    public void test2() {
        Test test = testDao.findOne((long) 1);
        System.out.println(test.toString());
    }

    @org.junit.Test
    public void test3() {
        List<Test> list = testDao.findByFirstName("tain");
        for (Test test : list) {
            System.out.println(test.toString());
        }
    }


    @org.junit.Test
    public void test4() {
        Sort.Order order = new Sort.Order(Sort.Direction.DESC,"id");
        Sort sort = new Sort(order);

        //Pageable pageable= new PageRequest(1,3,sort);
        List<Test> list = testDao.findByFirstNameLike("%%",null);
        for (Test test : list) {
            System.out.println(test.toString());
        }
    }

    @org.junit.Test
    public void test5() {
        List<Test> list = testService.findByFirstName("tain");
        for(Test test : list) {
            System.out.println(test);
        }
    }

    //test memcache spring
    @org.junit.Test
    public void test6() {
        Test test = testService.findById((long) 1);
        System.out.println(test.toString());
    }

    //test memcache spring update
    @org.junit.Test
    public void test7() {
        Test test = testService.updateById((long) 1);
        System.out.println(test.toString());
    }

    //test memcache spring delete
    @org.junit.Test
    public void test8() {
        testService.deleteById((long) 1);
    }


    @org.junit.Test
    public void test9() {
        List<Test> list = testDaoCustom.selectByFirstNameLike("t1",null);
        for(Test test : list) {

            System.out.println(test.toString());
        }
    }


    @org.junit.Test
    public void test10() {
        List<Test> list = testDao.findBySec11NameLike("rq");
        for (Test test : list) {
            System.out.println(test);
        }
    }




}
