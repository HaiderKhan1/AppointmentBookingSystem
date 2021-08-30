package sk.fsk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import sk.fsk.controller.cto.SettingsCto;
import sk.fsk.model.Settings;
import sk.fsk.service.CalendarService;

@Controller
@RestController
@RequestMapping("/")
public class AdminController {

	@Autowired
	private CalendarService calendarService;

	@RequestMapping("/{calendarName}/dashboard")
	public ModelAndView settings(Model model, @PathVariable("calendarName") String calendarName) {
		ModelAndView modelAndView = new ModelAndView();
		model.addAttribute("calendarName", calendarName);
		modelAndView.setViewName("dashboard");
		return modelAndView;
	}

	@GetMapping("/{calendarName}/settings/find")
	public ResponseEntity<SettingsCto> signupAdminUser(Model model, @PathVariable("calendarName") String calendarName)
			throws Exception {
		Settings saveCalenderSettings = calendarService.findCalenderSettings(calendarName);
		SettingsCto settingsCto = new SettingsCto(saveCalenderSettings);
		return new ResponseEntity<SettingsCto>(settingsCto, new HttpHeaders(), HttpStatus.OK);
	}

	@PostMapping("/{calendarName}/settings/save")
	//TODO: check valid session then save
	public ResponseEntity<Settings> signupAdminUser(Settings settings,
			@PathVariable("calendarName") String calendarName) throws Exception {
		Settings saveCalenderSettings = calendarService.saveCalenderSettings(settings, calendarName);
		return new ResponseEntity<Settings>(saveCalenderSettings, new HttpHeaders(), HttpStatus.OK);
	}

}