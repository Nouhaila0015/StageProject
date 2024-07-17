package springMVC.service.serviceImplementation;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springMVC.dao.entities.Entry;
import springMVC.dao.repositories.IEntryRepo;
import springMVC.service.IService.IServiceEntry;

@Service
public class ServiceEntryImpl implements IServiceEntry{
	@Autowired
	IEntryRepo entry;
	
	@Override
	public List<Entry> listeUserParDate(String username, LocalDate date) {
		return entry.findByUsernameAndDate(username, date.getDayOfMonth(), date.getMonthValue(), date.getYear());
	}

	@Override
	public Double sumTotalHoursByUsernameAndDate(String username, LocalDate date) {
		return entry.sumTotalHoursByUsernameAndDate(username, date.getDayOfMonth(), date.getMonthValue(), date.getYear());
	}

}
