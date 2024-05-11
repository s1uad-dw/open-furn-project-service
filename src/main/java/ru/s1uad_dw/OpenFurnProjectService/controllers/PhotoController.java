package ru.s1uad_dw.OpenFurnProjectService.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.s1uad_dw.OpenFurnProjectService.dtos.CreatePhotoDto;
import ru.s1uad_dw.OpenFurnProjectService.dtos.ViewPhotoDto;
import ru.s1uad_dw.OpenFurnProjectService.services.PhotoService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/projects/photos")
public class PhotoController {
    @Autowired
    private PhotoService service;

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Add photo to project")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "201",
                    description = "New photo : UUID",
                    content = {
                            @Content(
                                    mediaType = "application/json")
                    }),
            @ApiResponse(
                    responseCode = "400",
                    description = "Invalid photo",
                    content = {
                            @Content(
                                    mediaType = "application/json")
                    }),
            @ApiResponse(
                    responseCode = "401",
                    description = "Token expired",
                    content = {
                            @Content(
                                    mediaType = "application/json")
                    })
    })
    public UUID create(@RequestHeader("Authorization") String token, @RequestBody CreatePhotoDto dto){
        return service.create(token, dto);
    }

    @GetMapping("find_by_project_id")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Find photos by projectId")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "201",
                    description = "Required photos",
                    content = {
                            @Content(
                                    mediaType = "application/json")
                    }),
            @ApiResponse(
                    responseCode = "400",
                    description = "Invalid token",
                    content = {
                            @Content(
                                    mediaType = "application/json")
                    }),
            @ApiResponse(
                    responseCode = "401",
                    description = "Token expired",
                    content = {
                            @Content(
                                    mediaType = "application/json")
                    })
    })
    public List<ViewPhotoDto> findByProjectId(@RequestHeader("Authorization") String token, @RequestParam UUID projectId){
        return service.findByProjectId(token, projectId);
    }
}
