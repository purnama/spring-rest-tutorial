package id.purnama.spring.rest.tutorial.repository;

import id.purnama.spring.rest.tutorial.entity.Participant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParticipantRepository extends JpaRepository<Participant, Long> {
}
