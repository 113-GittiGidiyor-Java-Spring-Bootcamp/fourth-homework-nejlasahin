package spring.bootcamp.week4.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import spring.bootcamp.week4.dto.ExceptionLoggerDto;
import spring.bootcamp.week4.model.ExceptionLogger;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ExceptionLoggerRepository extends JpaRepository<ExceptionLogger, Long> {

    @Query("SELECT e FROM ExceptionLogger e WHERE e.date= :date")
    List<ExceptionLogger> getByCreatedDate(LocalDate date);

    @Query("SELECT e FROM ExceptionLogger e WHERE e.status= :statusCode")
    List<ExceptionLogger> getByStatusCode(int statusCode);

    @Query("SELECT e FROM ExceptionLogger e WHERE e.message LIKE CONCAT ('%',:exceptionMessage,'%')")
    List<ExceptionLogger> getByExceptionMessage(String exceptionMessage);
}
