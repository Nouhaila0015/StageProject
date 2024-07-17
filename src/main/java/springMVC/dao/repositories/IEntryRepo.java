package springMVC.dao.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.*;
import springMVC.dao.entities.Entry;

public interface IEntryRepo extends JpaRepository<Entry,Long>{
	@Query("SELECT e FROM Entry e WHERE e.username = :username AND e.day = :day AND e.month = :month AND e.year = :year")
	public List<Entry> findByUsernameAndDate(@Param("username") String username, 
	                                          @Param("day") int day, 
	                                          @Param("month") int month, 
	                                          @Param("year") int year);
	
	@Query("SELECT SUM(e.totalHours) FROM Entry e WHERE e.username = :username AND e.day = :day AND e.month = :month AND e.year = :year")
    Double sumTotalHoursByUsernameAndDate(@Param("username") String username, 
                                          @Param("day") int day, 
                                          @Param("month") int month, 
                                          @Param("year") int year);
	
	@Query("SELECT SUM(e.totalHours) FROM Entry e WHERE e.username = :username AND e.month = :month AND e.year = :year AND FUNCTION('DAY', e.entryTime) = FUNCTION('DAY', e.exitTime)")
    Double sumTotalHoursByUsernameAndMonthAndYear(@Param("username") String username, 
                                           @Param("month") int month, 
                                           @Param("year") int year);
}
