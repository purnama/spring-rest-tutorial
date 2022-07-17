package id.purnama.spring.rest.tutorial.service;

import id.purnama.spring.rest.tutorial.dto.ParticipantDto;
import id.purnama.spring.rest.tutorial.entity.Participant;
import id.purnama.spring.rest.tutorial.repository.ParticipantRepository;
import lombok.AllArgsConstructor;
import ma.glasnost.orika.MapperFacade;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ParticipantService {

    private ParticipantRepository participantRepository;

    private MapperFacade mapperFacade;

    public List<ParticipantDto> getAllUsers(){
        return mapperFacade.mapAsList(participantRepository.findAll(), ParticipantDto.class);
    }

    public ParticipantDto getById(Long id){
        return mapperFacade.map(participantRepository.findById(id).get(), ParticipantDto.class);
    }

    public ParticipantDto create(ParticipantDto participantDto){
        return mapperFacade.map(participantRepository.save(mapperFacade.map(participantDto, Participant.class)), ParticipantDto.class);
    }

    public void delete(Participant participant){
        participantRepository.delete(participant);
    }
}
