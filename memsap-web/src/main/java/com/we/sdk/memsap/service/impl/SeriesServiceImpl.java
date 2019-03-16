package com.we.sdk.memsap.service.impl;

import com.we.sdk.memsap.bean.Series;
import com.we.sdk.memsap.feign.SeriesFeignClient;
import com.we.sdk.memsap.service.SeriesService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SeriesServiceImpl implements SeriesService {

    private final SeriesFeignClient seriesFeignClient;

    @Override
    public Integer save(Series series) {
        return seriesFeignClient.save(series).getData();
    }

    @Override
    public Integer delete(Integer id) {
        return seriesFeignClient.delete(id).getData();
    }

    @Override
    public Integer update(Series series) {
        return seriesFeignClient.update(series).getData();
    }

    @Override
    public Series getSeriesById(Integer id){
        return seriesFeignClient.getSeriesById(id).getData();
    }

    @Override
    public List<Series> getSeriesList() {
        return seriesFeignClient.getSeriesList().getData();
    }

}
