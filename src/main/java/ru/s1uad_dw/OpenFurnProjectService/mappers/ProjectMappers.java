package ru.s1uad_dw.OpenFurnProjectService.mappers;

import ru.s1uad_dw.OpenFurnProjectService.dtos.CreateProjectDto;
import ru.s1uad_dw.OpenFurnProjectService.dtos.ViewProjectDto;
import ru.s1uad_dw.OpenFurnProjectService.models.Project;

public class ProjectMappers {
    public static Project CreateProjectDtoToDao(CreateProjectDto dto){
        return new Project(
             dto.getTitle(), dto.getDescription(), dto.getPrice(), dto.getUserId(), dto.getIsPrivate(), dto.getPhotos()
        );
    }

    public static ViewProjectDto daoToViewProjectDto(Project dao){
        return new ViewProjectDto(
                dao.getId(),
                dao.getTitle(),
                dao.getDescription(),
                dao.getPrice(),
                dao.isPrivate(),
                dao.getPhotos().stream().map(PhotoMappers::daoToViewPhotoDto).toList()
        );
    }
}
