package springMVC.service.serviceImplementation;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springMVC.dao.entities.WorkPlace;
import springMVC.dao.repositories.IEntryRepo;
import springMVC.dao.repositories.IWorkPlaceRepo;
import springMVC.service.IService.IServiceAbsence;

@Service
public class ServiceAbsenceImpl implements IServiceAbsence{

	@Autowired
	private IWorkPlaceRepo workPlace;
	
	@Autowired
	private IEntryRepo entry;

	@Override
	public Double calculateAbsence(String username, LocalDate date) {
		WorkPlace workPlace = getCurrentWorkPlace(username, date);

        if (!"COMPANY".equalsIgnoreCase(workPlace.getType())) {
            return 0.0; // Ignorer les autres types de work_place
        }

        Double presencePercentage = workPlace.getPresencePercentage();
        Double totalWorkedHours = entry.sumTotalHoursByUsernameAndDate(username, date.getDayOfMonth(), date.getMonthValue(), date.getYear());
        totalWorkedHours = totalWorkedHours != null ? totalWorkedHours : 0.0;

        // Calcul des heures attendues basées sur le presence_percentage
        Double expectedHours = 8 * presencePercentage ;
        return expectedHours - totalWorkedHours;
	}

	@Override
	public Double calculateMonthlyAbsence(String username, YearMonth yearMonth) {
		double totalAbsence = 0.0;
        for (int day = 1; day <= yearMonth.lengthOfMonth(); day++) {
            LocalDate date = yearMonth.atDay(day);
            totalAbsence += calculateAbsence(username, date);
        }
        return totalAbsence;
	}
	
	private WorkPlace getCurrentWorkPlace(String username, LocalDate date) {
        return workPlace.findCurrentWorkPlace(username, date).orElseGet(() -> {
            WorkPlace defaultWorkPlace = new WorkPlace();
            defaultWorkPlace.setType("COMPANY");
            defaultWorkPlace.setPresencePercentage(100.0);
            return defaultWorkPlace;
        });
    }
}
