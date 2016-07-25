package com.mav;

import com.mav.user.SimplePage;
import org.apache.wicket.protocol.http.WebApplication;
import org.apache.wicket.spring.injection.annot.SpringComponentInjector;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class WicketApplication extends WebApplication {

    @Override
    public Class<SimplePage> getHomePage() {

        return SimplePage.class; // return default page
    }

    @Override
    protected void init() {
        super.init();
        ClassPathXmlApplicationContext ctx =
                new ClassPathXmlApplicationContext("conf/mainContext.xml");
        getComponentInstantiationListeners().add(new SpringComponentInjector(this, ctx));
    }
}
