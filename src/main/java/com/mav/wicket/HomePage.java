package com.mav.wicket;

import com.mav.entity.User;
import com.mav.user.UserService;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.PasswordTextField;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.spring.injection.annot.SpringBean;

public class HomePage extends WebPage {
    private static final long serialVersionUID = 1L;

    @SpringBean
    private UserService userService;


    public HomePage(PageParameters parameters) {
        super(parameters);
        add(new LoginForm("loginForm"));
    }

    class LoginForm extends Form{
        private String username;
        private String password;
        private String loginStatus;

        public LoginForm(String id) {
            super(id);
            setDefaultModel(new CompoundPropertyModel(this));

            add(new TextField("username"));
            add(new PasswordTextField("password"));
            add(new Label("loginStatus"));
        }

        public final void onSubmit() {
            User user = userService.findByCredentials(username, password);

            if(username.equals("test") && password.equals("test"))
                loginStatus = "Congratulations!";
            else
                loginStatus = "Wrong username or password !";
        }
    }
}
