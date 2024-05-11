package ru.s1uad_dw.OpenFurnProjectService.mappers;

import ru.s1uad_dw.OpenFurnProjectService.dtos.CreatePhotoDto;
import ru.s1uad_dw.OpenFurnProjectService.dtos.ViewPhotoDto;
import ru.s1uad_dw.OpenFurnProjectService.models.Photo;
import ru.s1uad_dw.OpenFurnProjectService.models.Project;

public class PhotoMappers {
    public static ViewPhotoDto daoToViewPhotoDto(Photo dao){
        return new ViewPhotoDto(
                dao.getId(), dao.getSequenceNumber(), dao.getFile()
        );
    }

    public static Photo createDtoToDao(CreatePhotoDto dto, Project project){
        return new Photo(project, dto.getSequenceNumber(), dto.getFile());
    }
}
