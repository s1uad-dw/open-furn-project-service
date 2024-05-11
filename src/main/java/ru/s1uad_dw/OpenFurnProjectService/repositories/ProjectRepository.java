package ru.s1uad_dw.OpenFurnProjectService.repositories;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.s1uad_dw.OpenFurnProjectService.dtos.ViewProjectDto;
import ru.s1uad_dw.OpenFurnProjectService.models.Photo;
import ru.s1uad_dw.OpenFurnProjectService.models.Project;

import java.util.List;
import java.util.UUID;

public interface ProjectRepository extends JpaRepository<Project, UUID> {
    @Transactional
    List<Project> findByUserId(UUID id);
}
