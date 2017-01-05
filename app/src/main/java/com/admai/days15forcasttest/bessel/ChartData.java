
package com.admai.days15forcasttest.bessel;


import java.util.ArrayList;
import java.util.List;

/**
 * 曲线图的数据以及相关配置信息
 * 
 * @author tomkeyzhang（qitongzhang@anjuke.com）
 * @date :2014年4月17日
 */
public class ChartData {
    private List<Series> seriesList;

    /** 使用哪一个series的横坐标来显示横坐标文本 */
    private int xLabelUsageSeries;

    public ChartData() {
        seriesList = new ArrayList<Series>();
        xLabelUsageSeries = 0;// 默认横轴使用第一个序列来显示文本
    }

    /** 设置数据序列 */
    public void setSeriesList(List<Series> seriesList) {
        this.seriesList.clear();
        if (seriesList != null && seriesList.size() > 0) {
            this.seriesList.addAll(seriesList);
            if (this.seriesList.size() <= xLabelUsageSeries)
                throw new IllegalArgumentException("xLabelUsageSeries should greater than seriesList.size()");

        }
    }

    public List<Series> getSeriesList() {
        return seriesList;
    }
    
  
}
