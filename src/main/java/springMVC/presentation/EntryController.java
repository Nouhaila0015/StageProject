package springMVC.presentation;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.ui.Model;

import springMVC.dao.entities.Entry;
import springMVC.service.IService.IServiceEntry;
import java.util.*;

@Controller
public class EntryController {
	@Autowired
	IServiceEntry serviceEntry;
	
	@GetMapping("/entry/{username}/{date}")
	public String showEntryPerDate(@PathVariable("username") String username, @PathVariable("date") String dateStr, Model model) {
		// Convert the date string to LocalDate
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        LocalDate date = LocalDate.parse(dateStr, formatter);
        
        // Fetch entries
        List<Entry> entries = serviceEntry.listeUserParDate(username, date);
        
        // Add entries to the model
        model.addAttribute("entries", entries);

        // Return the view name
        return "entryList";
	}
}
