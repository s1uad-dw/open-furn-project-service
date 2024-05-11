package ru.s1uad_dw.OpenFurnProjectService.dtos;

import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import ru.s1uad_dw.OpenFurnProjectService.models.Project;

import java.util.UUID;
@Data
@AllArgsConstructor
public class ViewPhotoDto {
    private UUID id;
    private int sequenceNumber;
    private String file;
}
