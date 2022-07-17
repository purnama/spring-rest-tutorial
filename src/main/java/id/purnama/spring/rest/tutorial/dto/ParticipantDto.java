package id.purnama.spring.rest.tutorial.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import id.purnama.spring.rest.tutorial.validator.constraint.ParticipantExist;
import lombok.*;
import org.springframework.hateoas.RepresentationModel;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class ParticipantDto extends RepresentationModel<ParticipantDto> {

    @ParticipantExist
    private Long id;
    private String name;
    private LocalDate birthDate;
    private String address;
}
