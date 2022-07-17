package id.purnama.spring.rest.tutorial.validator.constraint;

import id.purnama.spring.rest.tutorial.validator.ParticipantExistValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = ParticipantExistValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
public @interface ParticipantExist {
    String message() default "Participant not exist";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
