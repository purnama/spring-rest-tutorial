package id.purnama.spring.rest.tutorial.validator;

import id.purnama.spring.rest.tutorial.entity.Participant;
import id.purnama.spring.rest.tutorial.repository.ParticipantRepository;
import id.purnama.spring.rest.tutorial.service.ParticipantService;
import id.purnama.spring.rest.tutorial.validator.constraint.ParticipantExist;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ParticipantExistValidator implements ConstraintValidator<ParticipantExist, Long> {

    @Autowired
    private ParticipantRepository participantRepository;

    @Override
    public boolean isValid(Long id, ConstraintValidatorContext constraintValidatorContext) {
        return participantRepository.existsById(id);
    }
}
