package com.tekup.Project.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BienDto {
    private Long id;
    private String lebelle;
    private String photourl;
    private String detail;
    private String prix;
    private String type;
    private int nbpiece;
    private String louv;
}
