package sc.senai.topcare.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sc.senai.topcare.entity.File;

@Repository
public interface FileRepository extends JpaRepository<File, Long> {
}
