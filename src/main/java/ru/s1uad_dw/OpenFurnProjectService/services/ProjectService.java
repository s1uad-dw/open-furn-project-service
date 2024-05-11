package ru.s1uad_dw.OpenFurnProjectService.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.s1uad_dw.OpenFurnProjectService.dtos.CreateProjectDto;
import ru.s1uad_dw.OpenFurnProjectService.dtos.ViewProjectDto;
import ru.s1uad_dw.OpenFurnProjectService.exceptions.AccessDeniedException;
import ru.s1uad_dw.OpenFurnProjectService.exceptions.InvalidDataException;
import ru.s1uad_dw.OpenFurnProjectService.exceptions.ResourceNotFoundException;
import ru.s1uad_dw.OpenFurnProjectService.mappers.ProjectMappers;
import ru.s1uad_dw.OpenFurnProjectService.models.Project;
import ru.s1uad_dw.OpenFurnProjectService.repositories.ProjectRepository;
import ru.s1uad_dw.OpenFurnProjectService.utils.TokenUtility;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ProjectService {
    @Autowired
    TokenUtility tokenUtility;
    @Autowired
    ProjectRepository repository;

    public UUID create(String token, CreateProjectDto dto) {
        tokenUtility.checkTokenExpiration(token);
        if (tokenUtility.getId(token).equals(dto.getUserId()))
            return repository.save(ProjectMappers.CreateProjectDtoToDao(dto)).getId();
        throw new AccessDeniedException("not your project");
    }

    public List<ViewProjectDto> findByUserId(String token, UUID userId) {
        tokenUtility.checkTokenExpiration(token);
        if (tokenUtility.getId(token).equals(userId)){
            return repository.findByUserId(userId)
                    .stream().map(ProjectMappers::daoToViewProjectDto).toList();
        }
        return repository.findByUserId(userId)
                .stream()
                .filter(project -> !project.isPrivate())
                .map(ProjectMappers::daoToViewProjectDto).toList();
    }

    public Project findById(UUID id){
        Optional<Project> project = repository.findById(id);
        if(project.isPresent())
            return project.get();
        throw new InvalidDataException("invalid projectId");
    }
}
