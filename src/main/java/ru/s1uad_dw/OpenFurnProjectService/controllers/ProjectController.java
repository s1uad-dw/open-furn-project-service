package ru.s1uad_dw.OpenFurnProjectService.controllers;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.s1uad_dw.OpenFurnProjectService.dtos.CreateProjectDto;
import ru.s1uad_dw.OpenFurnProjectService.dtos.ViewProjectDto;
import ru.s1uad_dw.OpenFurnProjectService.services.ProjectService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/projects")
public class ProjectController {
    @Autowired
    private ProjectService service;

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Create project")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "201",
                    description = "New project:\nUUID",
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
    public UUID create(@RequestHeader("Authorization") String token, @RequestBody CreateProjectDto dto){
        return service.create(token, dto);
    }

    @GetMapping("find_by_user_id")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Find projects by token")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "201",
                    description = "Required feedback answers",
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
    public List<ViewProjectDto> findByUserId(@RequestHeader("Authorization") String token, @RequestParam UUID userId){
        return service.findByUserId(token, userId);
    }
}
