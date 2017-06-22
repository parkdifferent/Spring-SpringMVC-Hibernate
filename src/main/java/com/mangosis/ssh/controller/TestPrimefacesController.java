package com.mangosis.ssh.controller;

import com.mangosis.ssh.entity.Test;
import com.mangosis.ssh.service.TestService;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import java.util.List;
import java.util.Map;

/**
 * Created by admin on 2017/5/17.
 */


@ManagedBean
@SessionScoped
public class TestPrimefacesController {


    @ManagedProperty("testService")
    TestService testService;

    @RequestMapping(value = "/find",method = RequestMethod.GET)
    @ResponseBody
    public List<Test> test() {
        //List<Test> list = testService.findByFirstName("tain");
        List<Test> list = testService.findAll();
        return list;
    }


    private LazyDataModel<Test> testModel = new LazyDataModel<Test>() {

        private static final long serialVersionUID = -2652209909551272151L;

        @Override
        public List<Test> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String, Object> filters) {
            List<Test> list = testService.findAll();
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
