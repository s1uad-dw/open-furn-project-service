package ru.s1uad_dw.OpenFurnProjectService.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="photos")
public class Photo {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @ManyToOne
    private Project project;
    private int sequenceNumber;
    @Lob
    @Basic(fetch = FetchType.EAGER)
    private String file;

    public Photo(Project project, int sequenceNumber, String file){
        this.project = project;
        this.sequenceNumber = sequenceNumber;
        this.file = file;
    }
}