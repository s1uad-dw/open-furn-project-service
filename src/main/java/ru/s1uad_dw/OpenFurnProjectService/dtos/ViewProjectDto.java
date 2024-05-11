package ru.s1uad_dw.OpenFurnProjectService.dtos;

import jakarta.persistence.CascadeType;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import ru.s1uad_dw.OpenFurnProjectService.models.Photo;

import java.util.List;
import java.util.UUID;
@Data
@AllArgsConstructor
public class ViewProjectDto {
    private UUID id;
    private String title;
    private String description;
    private double price;
    private boolean isPrivate;
    private List<ViewPhotoDto> photos;
}
