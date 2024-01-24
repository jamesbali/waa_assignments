package edu.miu.WebAppArchLab.repository;

import edu.miu.WebAppArchLab.logging.Logger;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoggerRepository extends JpaRepository<Logger, Long> {
}
