package com.ecovision.controller;

import com.ecovision.model.WasteBin;
import com.ecovision.service.WasteAnalyticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class DashboardController {

    @Autowired
    private WasteAnalyticsService analyticsService;

    @GetMapping("/")
    public String viewDashboard(Model model) {
        if (analyticsService.getAllBins().isEmpty()) {
            analyticsService.saveBin(new WasteBin("Sector 14 - North Gate", 92.5, "Plastic/Dry", "CRITICAL"));
            analyticsService.saveBin(new WasteBin("Tech Park Block B", 45.0, "Organic", "NORMAL"));
            analyticsService.saveBin(new WasteBin("Central Market Hub", 78.0, "E-Waste", "WARNING"));
            analyticsService.saveBin(new WasteBin("University Square", 88.0, "Paper/Cardboard", "CRITICAL"));
        }

        model.addAttribute("bins", analyticsService.getAllBins());
        model.addAttribute("criticalCount", analyticsService.getCriticalBinCount());
        model.addAttribute("totalBins", analyticsService.getAllBins().size());
        model.addAttribute("newBin", new WasteBin());
        return "dashboard";
    }

    @PostMapping("/add-bin")
    public String addBin(@ModelAttribute("newBin") WasteBin bin) {
        analyticsService.saveBin(bin);
        return "redirect:/";
    }
}