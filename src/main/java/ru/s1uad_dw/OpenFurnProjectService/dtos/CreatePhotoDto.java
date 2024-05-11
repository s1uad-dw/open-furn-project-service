package ru.s1uad_dw.OpenFurnProjectService.dtos;

import lombok.Data;

import java.util.UUID;

@Data
public class CreatePhotoDto {
    private UUID projectId;
    private int sequenceNumber;
    private String file;
}
