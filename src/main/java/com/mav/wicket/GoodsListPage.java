package com.mav.wicket;

import com.mav.entity.Goods;
import com.mav.user.GoodsService;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.navigation.paging.PagingNavigator;
import org.apache.wicket.markup.repeater.Item;
import org.apache.wicket.markup.repeater.RepeatingView;
import org.apache.wicket.markup.repeater.data.DataView;
import org.apache.wicket.markup.repeater.data.ListDataProvider;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.spring.injection.annot.SpringBean;

import java.util.ArrayList;
import java.util.List;

public class GoodsListPage extends WebPage {

    @SpringBean
    private GoodsService goodsService;

    public GoodsListPage(PageParameters parameters) {



        List<String[]> countries = new ArrayList<>();

        List<Goods> goodses = new ArrayList<>(goodsService.getAllGoods());

            for (Goods goods: goodses) {
                countries.add(goods.convertToStringArray(goods));
            }

        ListDataProvider<String[]> listDataProvider =
                new ListDataProvider<>(countries);

        DataView<String[]> dataView =
                new DataView<String[]>("rows", listDataProvider) {

                    @Override
                    protected void populateItem(Item<String[]> item) {
                        String[] countriesArr = item.getModelObject();
                        RepeatingView repeatingView = new RepeatingView("dataRow");

                        for (int i = 0; i < countriesArr.length; i++){
                            repeatingView.add(
                                    new Label(repeatingView.newChildId(), countriesArr[i]));
                        }
                        item.add(repeatingView);
                    }
                };

        add(dataView);
        add(new PagingNavigator("pagingNavigator", dataView));
        add(new Label("msg", goodsService.getAllGoods().toString()));
    }
}
