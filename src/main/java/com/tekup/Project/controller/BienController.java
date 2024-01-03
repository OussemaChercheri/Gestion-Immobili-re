package com.tekup.Project.controller;

import java.util.List;

//import org.apache.catalina.security.SecurityUtil;
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
    
    @GetMapping("/Biens")
    //to retrieves the list of BienDto objects from the bienService and adds it to the model
    public String listBiens(Model model) {
        List<BienDto> biens = bienService.findAllBiens();
        model.addAttribute("Biens", biens);
        
        return "Bien-list";//the view name
    }

///////retrieve bien
    @GetMapping("/Biens/new")
    public String createBienForm(Model model) {
        Bien bien = new Bien();
        model.addAttribute("bien", bien);
        return "Bien-create";////the view name
    }

    @GetMapping("/Biens/{BienId}")
    public String BienDetail(@PathVariable("BienId") long BienId, Model model) {
        BienDto BienDto = bienService.findBienById(BienId);
        model.addAttribute("Bien", BienDto);
        return "Biens-detail";
    }



////////////////////creation
@PostMapping("/Biens/new")
    public String saveBien(@ModelAttribute("Bien") Bien bien) {
        bienService.saveBien(bien);
        return "redirect:/Biens";
    }

    //////////////////update
    @GetMapping("/Biens/{BienId}/edit")
    public String editBienForm(@PathVariable("BienId") Long BienId, Model model) {
        BienDto bien = bienService.findBienById(BienId);
        model.addAttribute("Bien", bien);
        return "Biens-edit";
    }

    @PostMapping("/Biens/{BienId}/edit")
    public String updateBien(@PathVariable("BienId") Long BienId,@Valid @ModelAttribute("bien") BienDto Bien) {
        
        Bien.setId(BienId);
        bienService.updateBien(Bien);
        return "redirect:/Biens";
    }
      
//////////////////////delete
@GetMapping("/Biens/{BienId}/delete")
    public String deleteBien(@PathVariable("BienId")Long BienId) {
        bienService.delete(BienId);
        return "redirect:/Biens";
    }

}
