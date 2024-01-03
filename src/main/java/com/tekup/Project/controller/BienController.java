package com.tekup.Project.controller;

import java.util.List;

//import org.apache.catalina.security.SecurityUtil;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
//import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.tekup.Project.dto.BienDto;
import com.tekup.Project.models.Bien;
import com.tekup.Project.service.BienService;

import jakarta.validation.Valid;

@Controller
//this is where the BienService is provided to the controller when it is created
public class BienController {
    private BienService bienService;

   // @Autowired
    public BienController(BienService bienService) {
        this.bienService = bienService;
    }
    
    @GetMapping("/biens")
    //to retrieves the list of BienDto objects from the bienService and adds it to the model
    public String listBiens(Model model) {
        List<BienDto> biens = bienService.findAllBiens();
        model.addAttribute("biens", biens);
        return "bien-list";//the view name
    }
///////retrieve bien
    @GetMapping("/biens/new")
    public String createbienForm(Model model) {
        Bien bien = new Bien();
        model.addAttribute("bien", bien);
        return "bien-create";////the view name
    }



////////////////////creation
@PostMapping("/biens/new")
    public String saveBien(@ModelAttribute("Bien") Bien Bien) {
        bienService.saveBien(Bien);
        return "redirect:/biens";
    }

    //////////////////update
    @GetMapping("/Biens/{BienId}/edit")
    public String editBienForm(@PathVariable("BienId") Long BienId, Model model) {
        BienDto Bien = bienService.findBienById(BienId);
        model.addAttribute("Bien", Bien);
        return "Biens-edit";
    }

    @PostMapping("/Biens/{BienId}/edit")
    public String updateBien(@PathVariable("BienId") Long BienId,@Valid @ModelAttribute("Bien") BienDto Bien) {
        
        Bien.setId(BienId);
        bienService.updateBien(Bien);
        return "redirect:/Biens";
    }
      


}
