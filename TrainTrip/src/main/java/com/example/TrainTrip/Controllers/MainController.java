package com.example.TrainTrip.Controllers;

import com.example. CourseProject.Models.entities.Trip;
import com.example. CourseProject.Models.service.TripService;
import org.springframework.data.repository.query. Param;
import org.springframework.stereotype.Controller;
import org.springframework.vi. Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation. RequestMapping;
import org.springframework.web.bind.annotation. RequestParam;
import java.util.List;

@Controller
public class MainController {
	private final TripService tripService;
	public MainController (TripService tripService) { this.tripService = tripService; }
	@GetMapping("/")
	public String home (@Param ("keyword") String keyword, Model model) {
		List<Trip> trips = tripService.listAll(keyword);
		model. addAttribute ("trips", trips);
		return "home";
	}
	@GetMapping ("about")
	public String about() { return "about"; }
	@GetMapping ("/Log")
	public String log() { return "Log"; }
	@RequestMapping ("/log")
	public String getLogin(@Requestaram(value = "error", required = false) String error,
						   @RequestParam (value = "logout", required = false) String logout,
						   Model model) {
		model. addAttribute ("error", error != null);
		model. addAttribute ( "Logout", logout != null);
		return "log";
	}