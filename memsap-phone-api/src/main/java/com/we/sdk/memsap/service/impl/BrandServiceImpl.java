package com.we.sdk.memsap.service.impl;

import com.we.sdk.memsap.dao.BrandDao;
import com.we.sdk.memsap.bean.Brand;
import com.we.sdk.memsap.service.BrandService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class BrandServiceImpl implements BrandService {

    private final BrandDao brandDao;

    @Override
    public Integer save(Brand brand) {
        return brandDao.save(brand);
    }

    @Override
    public Integer delete(Integer id) {
        return brandDao.delete(id);
    }

    @Override
    public Integer update(Brand brand) {
        return brandDao.update(brand);
    }

    @Override
    public Brand getBrandById(Integer id){
        return brandDao.getBrandById(id);
    }

    @Override
    public List<Brand> getBrands() {
        return brandDao.getBrands();
    }

}
