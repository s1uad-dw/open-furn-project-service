package ru.s1uad_dw.OpenFurnProjectService.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="projects")
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String title;
    private String description;
    private double price;
    private UUID userId;
    private boolean isPrivate;
    @OneToMany(mappedBy = "project", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Photo> photos;

  public Project(String title, String description, double price, UUID userId, boolean isPrivate, List<Photo> photo){
        this.title = title;
        this.description = description;
        this.price = price;
        this.userId = userId;
        this.isPrivate = isPrivate;
        this.photos = photo;
    }
}
