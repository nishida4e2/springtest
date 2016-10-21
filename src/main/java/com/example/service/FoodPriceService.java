package com.example.service;

import com.example.domain.FoodPrice;
import com.example.repository.FoodPriceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodPriceService {
	
    @Autowired
    FoodPriceRepository fpRepo;

    public List<FoodPrice> findAll() {
        return fpRepo.findAll();
    }

    public FoodPrice findOne(Integer id) {
        return fpRepo.findOne(id);
    }

    public FoodPrice create(FoodPrice fp) {
        return fpRepo.save(fp);
    }

    public void delete(Integer id) {
    	fpRepo.delete(id);
    }

}
