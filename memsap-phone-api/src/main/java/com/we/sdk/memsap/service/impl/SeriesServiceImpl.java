package com.we.sdk.memsap.service.impl;

import com.we.sdk.memsap.dao.SeriesDao;
import com.we.sdk.memsap.bean.Series;
import com.we.sdk.memsap.service.SeriesService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class SeriesServiceImpl implements SeriesService {

    private final SeriesDao seriesDao;

    @Override
    public Integer save(Series series) {
        return seriesDao.save(series);
    }

    @Override
    public Integer delete(Integer id) {
        return seriesDao.delete(id);
    }

    @Override
    public Integer update(Series series) {
        return seriesDao.update(series);
    }

    @Override
    public Series getSeriesById(Integer id){
        return seriesDao.getSeriesById(id);
    }

    @Override
    public List<Series> getSeriesList() {
        return seriesDao.getSeriesList();
    }

}
