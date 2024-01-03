package com.tekup.Project.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
//design patter builder pour créer une instance de tel façon setting ykoun ll properties li nst7a9ouhom for a particular instance
public class BienDto {
    private Long id;
    private String labelle;
    private String photourl;
    private String detail;
    private String prix;
    private String type;
    private int nbpiece;
    private String louv;//pour dire à louer ou à vendre 
}
