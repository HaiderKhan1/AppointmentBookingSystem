package sk.fsk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import sk.fsk.controller.cto.SettingsCto;
import sk.fsk.model.Calendar;
import sk.fsk.model.Settings;
import sk.fsk.service.CalendarService;

@RestController
@RequestMapping("/")
public class SignupController {

	@Autowired
	private CalendarService calendarService;

	@GetMapping("/signup")
	public ModelAndView settings() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("signup");
		return modelAndView;
	}

	@PostMapping("/signup")
	public ResponseEntity<Calendar> signupAdminUser(Calendar calendar) throws Exception {
		Calendar createdCalendar = calendarService.signupNewCalendar(calendar);
		Settings settings = new SettingsCto(null).toSettings();
		settings.setCalendar(createdCalendar);
		createdCalendar.setSettings(settings);
		return new ResponseEntity<Calendar>(createdCalendar, new HttpHeaders(), HttpStatus.OK);
	}

}