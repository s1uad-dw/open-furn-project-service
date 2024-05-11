package ru.s1uad_dw.OpenFurnProjectService.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.s1uad_dw.OpenFurnProjectService.dtos.CreatePhotoDto;
import ru.s1uad_dw.OpenFurnProjectService.dtos.ViewPhotoDto;
import ru.s1uad_dw.OpenFurnProjectService.exceptions.AccessDeniedException;
import ru.s1uad_dw.OpenFurnProjectService.mappers.PhotoMappers;
import ru.s1uad_dw.OpenFurnProjectService.models.Project;
import ru.s1uad_dw.OpenFurnProjectService.repositories.PhotoRepository;
import ru.s1uad_dw.OpenFurnProjectService.utils.TokenUtility;

import java.util.List;
import java.util.UUID;

@Service
public class PhotoService {
    @Autowired
    TokenUtility tokenUtility;

    @Autowired
    private PhotoRepository photoRepository;

    @Autowired
    private ProjectService projectService;

    public UUID create(String token, CreatePhotoDto dto) {
        Project project = projectService.findById(dto.getProjectId());
        if(tokenUtility.getId(token).equals(project.getUserId())){
            return photoRepository.save(PhotoMappers.createDtoToDao(dto, project)).getId();
        }
        throw new AccessDeniedException("Not your project");
    }

    public List<ViewPhotoDto> findByProjectId(String token, UUID projectId) {
        Project project = projectService.findById(projectId);
        if (project.isPrivate() && !project.getUserId().equals(tokenUtility.getId(token)))
            throw new AccessDeniedException("Not your project");
        return photoRepository.findByProject(project);
    }
}
