package com.tekup.Project.service;
import java.util.List;
import com.tekup.Project.dto.BienDto;
import com.tekup.Project.models.Bien;

import jakarta.validation.Valid;
public interface BienService {

    List<BienDto> findAllBiens();
    Bien saveBien(Bien Bien) ;
    BienDto findBienById(Long BienId);
    void updateBien(@Valid BienDto bien);
    void delete(Long bienId);
    
}
