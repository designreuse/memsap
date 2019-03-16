package com.we.sdk.memsap.service;

import com.we.sdk.memsap.bean.Series;

import java.util.List;

public interface SeriesService {

    Integer save(Series series);

    Integer delete(Integer id);

    Integer update(Series series);

    Series getSeriesById(Integer id);

    List<Series> getSeriesList();


}

