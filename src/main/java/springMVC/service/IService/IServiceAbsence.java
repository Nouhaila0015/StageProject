package springMVC.service.IService;

import java.time.LocalDate;
import java.time.YearMonth;

public interface IServiceAbsence {
	public Double calculateAbsence(String username, LocalDate date);
	public Double calculateMonthlyAbsence(String username, YearMonth yearMonth);
}
