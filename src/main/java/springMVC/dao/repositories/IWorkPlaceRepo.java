package springMVC.dao.repositories;

import java.time.LocalDate;
import java.util.*;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import springMVC.dao.entities.WorkPlace;

public interface IWorkPlaceRepo extends JpaRepository<WorkPlace, Integer>{
	@Query("SELECT wp FROM WorkPlace wp WHERE wp.userUsername = :username AND wp.startDate <= :date AND wp.startDate = (SELECT Max(w.startDate) FROM WorkPlace w WHERE w.userUsername = :username AND w.startDate <= :date)")
    Optional<WorkPlace> findCurrentWorkPlace(@Param("username") String username, @Param("date") LocalDate date);
}
