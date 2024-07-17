package springMVC.service.IService;


import java.time.LocalDate;
import java.util.*;
import springMVC.dao.entities.Entry;

public interface IServiceEntry {
	public List<Entry> listeUserParDate(String username, LocalDate date);
}
