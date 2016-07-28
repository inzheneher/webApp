package com.mav.wicket;

import com.mav.user.GoodsService;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.spring.injection.annot.SpringBean;

public class GoodsListPage extends WebPage {

    @SpringBean
    private GoodsService goodsService;

    public GoodsListPage(final PageParameters parameters) {

        add(new Label("msg", goodsService.getAllGoods().toString()));

    }
}
