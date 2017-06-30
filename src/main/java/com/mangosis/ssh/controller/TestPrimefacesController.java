package com.mangosis.ssh.controller;

import com.mangosis.ssh.entity.Test;
import com.mangosis.ssh.service.MyTestService;
import com.mangosis.ssh.service.TestService;
import com.mangosis.ssh.service.impl.TestServiceImpl;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * Created by admin on 2017/5/17.
 */


@ManagedBean(name = "testPrimefacesController")
@SessionScoped
public class TestPrimefacesController implements Serializable {


    private static final long serialVersionUID = 7124493743947779539L;

    @ManagedProperty(value = "#{myTestService}")
    MyTestService myTestService;                          //need  get/set method

    public MyTestService getMyTestService() {
        return myTestService;
    }

    public void setMyTestService(MyTestService myTestService) {
        this.myTestService = myTestService;
    }

    /*   @RequestMapping(value = "/find",method = RequestMethod.GET)
    @ResponseBody
    public List<Test> test() {
        //List<Test> list = testService.findByFirstName("tain");
        List<Test> list = testService.findAll();
        return list;
    }*/


    private LazyDataModel<Test> testModel = new LazyDataModel<Test>() {                       // need get/set method

        private static final long serialVersionUID = -2652209909551272151L;

        @Override
        public List<Test> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String, Object> filters) {
            List<Test> list = myTestService.findAll();
            setRowCount(list.size());
            return list;
        }
    };







    public LazyDataModel<Test> getTestModel() {
        return testModel;
    }

    public void setTestModel(LazyDataModel<Test> testModel) {
        this.testModel = testModel;
    }
}
