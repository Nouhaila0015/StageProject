package springMVC.presentation;

import java.time.LocalDate;
import java.time.YearMonth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import springMVC.service.IService.IServiceAbsence;


@Controller
public class AbsenceController {

	@Autowired
	private IServiceAbsence absence;
	
	 @GetMapping("/absence/{username}/{day}")
	    public String calculateAbsence(@PathVariable("username") String username,
	                                   @PathVariable("day") @DateTimeFormat(pattern = "yyyyMMdd") LocalDate date,
	                                   Model model) {
	        Double absenceHours = absence.calculateAbsence(username, date);
	        model.addAttribute("username", username);
	        model.addAttribute("date", date);
	        model.addAttribute("absenceHours", absenceHours);
	        return "absenceDetails"; 
	    }
	 
	 @GetMapping("/absence/{username}/{year}/{month}")
	    public String calculateMonthlyAbsence(@PathVariable("username") String username,
	                                          @PathVariable("year") int year,
	                                          @PathVariable("month") int month,
	                                          Model model) {
	        YearMonth yearMonth = YearMonth.of(year, month);
	        Double totalAbsenceHours = absence.calculateMonthlyAbsence(username, yearMonth);
	        model.addAttribute("username", username);
	        model.addAttribute("yearMonth", yearMonth);
	        model.addAttribute("totalAbsenceHours", totalAbsenceHours);
	        return "absenceMonthlyDetails"; // Renvoie le template absenceMonthlyDetails.html
	 	}
}
