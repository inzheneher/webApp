package com.mav.wicket;


import com.mav.user.EmployeeService;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.spring.injection.annot.SpringBean;

public class EmployeeListPage extends WebPage {

    @SpringBean
    private EmployeeService employeeService;

    public EmployeeListPage(final PageParameters parameters) {

        add(new Label("msg", employeeService.getAllEmployees().toString()));

    }

}
