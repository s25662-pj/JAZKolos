package pl.pjatk.demo.repository;

import pl.pjatk.demo.model.ExchangeRequest;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProjectRepository extends JpaRepository<ExchangeRequest, Long> {
}
