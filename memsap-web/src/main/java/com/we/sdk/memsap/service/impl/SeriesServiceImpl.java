package com.we.sdk.memsap.service.impl;

import com.we.sdk.memsap.bean.Series;
import com.we.sdk.memsap.feign.PhoneFeignClient;
import com.we.sdk.memsap.service.SeriesService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SeriesServiceImpl implements SeriesService {

    private final PhoneFeignClient phoneFeignClient;

    @Override
    public Integer saveSeries(Series series) {
        return phoneFeignClient.saveSeries(series).getData();
    }

    @Override
    public Integer deleteSeries(Integer id) {
        return phoneFeignClient.delete(id).getData();
    }

    @Override
    public Integer updateSeries(Series series) {
        return phoneFeignClient.updateSeries(series).getData();
    }

    @Override
    public Series getSeriesById(Integer id){
        return phoneFeignClient.getSeriesById(id).getData();
    }

    @Override
    public List<Series> getSeriesList() {
        return phoneFeignClient.getSeriesList().getData();
    }

}
