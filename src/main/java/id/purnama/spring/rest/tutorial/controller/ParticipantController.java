package id.purnama.spring.rest.tutorial.controller;

import id.purnama.spring.rest.tutorial.dto.ParticipantDto;
import id.purnama.spring.rest.tutorial.entity.Participant;
import id.purnama.spring.rest.tutorial.service.ParticipantService;
import id.purnama.spring.rest.tutorial.validator.constraint.ParticipantExist;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController()
@RequestMapping("participants")
@AllArgsConstructor
@Validated
public class ParticipantController {

    private ParticipantService participantService;

    @GetMapping
    public ResponseEntity<List<ParticipantDto>> getUsers(){
        List<ParticipantDto> participantDtos = participantService.getAllUsers();
        participantDtos.stream().forEach(participantDto -> createLink(participantDto));
        return ResponseEntity.ok(participantDtos);
    }

    @PostMapping
    public ResponseEntity<ParticipantDto> createUser(@RequestBody ParticipantDto participantDto){
        return new ResponseEntity(createLink(participantService.create(participantDto)), HttpStatus.CREATED);
    }

    @GetMapping("{participantId}")
    public ResponseEntity<ParticipantDto> getById(@PathVariable Long participantId){
        return ResponseEntity.ok(createLink(participantService.getById(participantId)));
    }

    @PutMapping("{participantId}")
    public ResponseEntity<ParticipantDto> editUser(@RequestBody @Valid ParticipantDto participantDto, @PathVariable @ParticipantExist Long participantId){
        return ResponseEntity.ok(createLink(participantService.create(participantDto)));
    }

    private ParticipantDto createLink(ParticipantDto participantDto){
        participantDto.add(linkTo(methodOn(ParticipantController.class).getById(participantDto.getId())).withSelfRel());
        return participantDto;
    }
}
