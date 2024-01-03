package com.tekup.Project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.tekup.Project.dto.BienDto;
import com.tekup.Project.service.BienService;

@Controller
public class BienController {
    private BienService bienService;

    @Autowired
    public BienController(BienService bienService) {
        this.bienService = bienService;
    }
    
    @GetMapping("/biens")
    public String listBiens(Model model) {
        List<BienDto> biens = bienService.findAllBiens();
        model.addAttribute("biens", biens);
        return "bien-list";
    }
}
