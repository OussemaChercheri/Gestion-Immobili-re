package com.tekup.Project.service;
import java.util.List;
import com.tekup.Project.dto.BienDto;
import com.tekup.Project.models.Bien;
public interface BienService {

    List<BienDto> findAllBiens();
    Bien saveBien(Bien Bien) ;
    
}
