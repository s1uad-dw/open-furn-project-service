package ru.s1uad_dw.OpenFurnProjectService.dtos;

import jakarta.persistence.CascadeType;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.s1uad_dw.OpenFurnProjectService.models.Photo;
import ru.s1uad_dw.OpenFurnProjectService.services.ProjectService;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CreateProjectDto {
    String title;
    String description;
    double price;
    UUID userId;
    Boolean isPrivate;
    @OneToMany(mappedBy = "project", cascade = CascadeType.ALL, orphanRemoval = true)
    List<Photo> photos;

    public CreateProjectDto(String title, String description, double price, boolean isPrivate, UUID userId){
        this.title = title;
        this.description = description;
        this.price = price;
        this.userId = userId;
        this.isPrivate = isPrivate;
        this.photos = new ArrayList<>();
    }

    public CreateProjectDto(String title, String description, double price, boolean isPrivate, UUID userId, List<Photo> photo){
        this.title = title;
        this.description = description;
        this.price = price;
        this.userId = userId;
        this.isPrivate = isPrivate;
        this.photos = photo;
    }
}
