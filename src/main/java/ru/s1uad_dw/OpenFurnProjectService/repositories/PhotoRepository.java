package ru.s1uad_dw.OpenFurnProjectService.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.s1uad_dw.OpenFurnProjectService.dtos.ViewPhotoDto;
import ru.s1uad_dw.OpenFurnProjectService.models.Photo;
import ru.s1uad_dw.OpenFurnProjectService.models.Project;

import java.util.List;
import java.util.UUID;

public interface PhotoRepository extends JpaRepository<Photo, UUID> {

    List<ViewPhotoDto> findByProject(Project project);
}
