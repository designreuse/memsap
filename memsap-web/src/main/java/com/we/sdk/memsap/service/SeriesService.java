package com.we.sdk.memsap.service;

import com.we.sdk.memsap.bean.Series;

import java.util.List;

public interface SeriesService {

    Integer saveSeries(Series series);

    Integer deleteSeries(Integer id);

    Integer updateSeries(Series series);

    Series getSeriesById(Integer id);

    List<Series> getSeriesList();


}

