package com.traffic;

import com.google.api.ads.adwords.axis.v201609.cm.Money;
import com.google.api.ads.adwords.axis.v201609.o.StringAttribute;

/**
 * Created by lenovo on 6/2/2017.
 */
public class GetDTO {
    String keyword;
    Long averagemonthlysearch;
    Money cost;

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public Long getAveragemonthlysearch() {
        return averagemonthlysearch;
    }

    public void setAveragemonthlysearch(Long averagemonthlysearch) {
        this.averagemonthlysearch = averagemonthlysearch;
    }

    public Money getCost() {
        return cost;
    }

    public void setCost(Money cost) {
        this.cost = cost;
    }
}
