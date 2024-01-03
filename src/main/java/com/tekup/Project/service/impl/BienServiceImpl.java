package com.tekup.Project.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tekup.Project.dto.BienDto;
import com.tekup.Project.models.Bien;
import com.tekup.Project.repository.BienRepository;
import com.tekup.Project.service.BienService;


@Service
public class BienServiceImpl implements BienService{

    private BienRepository bienRepository;


    @Autowired
    public BienServiceImpl(BienRepository bienRepository){
        this.bienRepository = bienRepository;
    }

    @Override
    public List<BienDto> findAllBiens() {
        List<Bien> biens = bienRepository.findAll();
        return biens.stream().map((bien) -> mapToBienDto(bien)).collect(Collectors.toList());
    }

    private BienDto mapToBienDto(Bien bien){
        BienDto bienDto = BienDto.builder()
            .id(bien.getId())
            .lebelle(bien.getLebelle())
            .louv(bien.getLouv())
            .nbpiece(bien.getNbpiece())
            .detail(bien.getDetail())
            .prix(bien.getPrix())
            .photourl(bien.getPhotourl())
            .build();
        return bienDto;

    }

     @Override
    public Bien saveBien(Bien Bien) {    
        return BienRepository.save(Bien);
    }

   
}
