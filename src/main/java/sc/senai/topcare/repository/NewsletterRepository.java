package sc.senai.topcare.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sc.senai.topcare.entity.Newsletter;
@Repository
public interface NewsletterRepository extends JpaRepository<Newsletter, Long> {

}
