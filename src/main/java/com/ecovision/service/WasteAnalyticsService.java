package com.ecovision.service;

import com.ecovision.model.WasteBin;
import com.ecovision.repository.WasteBinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WasteAnalyticsService {

    @Autowired
    private WasteBinRepository repository;

    public List<WasteBin> getAllBins() {
        return repository.findAll();
    }

    public WasteBin saveBin(WasteBin bin) {
        if (bin.getFillLevel() >= 85.0) {
            bin.setStatus("CRITICAL");
        } else if (bin.getFillLevel() >= 60.0) {
            bin.setStatus("WARNING");
        } else {
            bin.setStatus("NORMAL");
        }
        return repository.save(bin);
    }

    public long getCriticalBinCount() {
        return repository.findByStatus("CRITICAL").size();
    }
}