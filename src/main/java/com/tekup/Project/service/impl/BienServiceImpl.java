package com.tekup.Project.service.impl;

import java.util.List;
import java.util.stream.Collectors;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tekup.Project.dto.BienDto;
import com.tekup.Project.models.Bien;
import com.tekup.Project.repository.BienRepository;
import com.tekup.Project.service.BienService;

import jakarta.validation.Valid;
import lombok.Builder;

@Builder
@Service
public class BienServiceImpl implements BienService{

    private BienRepository bienRepository;


    //@Autowired
    public BienServiceImpl(BienRepository bienRepository){
        this.bienRepository = bienRepository;
    }

    @Override
    public List<BienDto> findAllBiens() {
        List<Bien> biens = bienRepository.findAll();
        return biens.stream().map((bien) -> mapToBienDto(bien)).collect(Collectors.toList());
    }
/////////to display the list of properties on the frontend, without exposing unnecessary details
    private BienDto mapToBienDto(Bien bien){
        BienDto bienDto = BienDto.builder()
            .id(bien.getId())
            .labelle(bien.getLabelle())
            .louv(bien.getLouv())
            .nbpiece(bien.getNbpiece())
            .detail(bien.getDetail())
            .prix(bien.getPrix())
            .photourl(bien.getPhotourl())
            .build();
        return bienDto;

    }
<<<<<<< HEAD
    
=======

     @Override
    public Bien saveBien(Bien Bien) {    
        return bienRepository.save(Bien);
    }

    @Override
    public BienDto findBienById(Long BienId) {
        Bien Bien=bienRepository.findById(BienId).get();
        return mapToBienDto(Bien);
    }

    @Override
    public void updateBien(@Valid BienDto bientDto) {
      Bien bien =mapToBien(bientDto);
      bienRepository.save(bien);
    }

    private Bien mapToBien(BienDto bien){
        Bien bienDto=Bien.builder()
            .id(bien.getId())
            .labelle(bien.getLabelle())
            .louv(bien.getLouv())
            .nbpiece(bien.getNbpiece())
            .detail(bien.getDetail())
            .prix(bien.getPrix())
            .photourl(bien.getPhotourl())
            .build();
        return bienDto;
    }

    

   
>>>>>>> 0082773f35dfa17c3ff12fad6ec5ec8a82f9baff
}
