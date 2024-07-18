package sc.senai.topcare.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sc.senai.topcare.entity.Pet;

@Repository
public interface PetRepository extends JpaRepository<Pet, Long> {
}
