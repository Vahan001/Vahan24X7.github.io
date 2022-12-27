package net.javaguides.sms.controller;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import net.javaguides.sms.entity.Challan;
import net.javaguides.sms.service.ChallanService;

@Controller
public class ChallanController {
	
	private ChallanService challanService;

	public ChallanController(ChallanService challanService) {
		super();
		this.challanService = challanService;
	}
	
	// handler method to handle list challans and return mode and view
	@GetMapping("/challans")
	public String listChallans(Model m) {
		
		/*
		 * model.addAttribute("challans", challanService.getAllChallans()); return
		 * "challans";
		 */
		
		return findPaginated(0, m);
		
	}
	
	@GetMapping("/challans/new")
	public String createChallanForm(Model model) {
		
		// create challan object to hold challan form data
		Challan challan = new Challan();
		model.addAttribute("challan", challan);
		return "create_challan";
		
	}
	
	@PostMapping("/challans")
	public String saveChallan(@ModelAttribute("challan") Challan challan) {
		challanService.saveChallan(challan);
		return "redirect:/challans";
	}
	@GetMapping("/teams")
	public String viewTeam() {
		return "team";
	}
	
	@GetMapping("/challans/edit/{id}")
	public String editChallanForm(@PathVariable Long id, Model model) {
		model.addAttribute("challan", challanService.getChallanById(id));
		return "edit_challan";
	}

	@PostMapping("/challans/{id}")
	public String updateChallan(@PathVariable Long id,
			@ModelAttribute("challan") Challan challan,
			Model model) {
		
		// get challan from database by id
		Challan existingChallan = challanService.getChallanById(id);
		existingChallan.setId(id);
		existingChallan.setFirstName(challan.getFirstName());
		existingChallan.setLastName(challan.getLastName());
		existingChallan.setEmail(challan.getEmail());
		existingChallan.setModel(challan.getModel());
		existingChallan.setFine(challan.getFine());
		
		// save updated challan object
		challanService.updateChallan(existingChallan);
		return "redirect:/challans";		
	}
	
	// handler method to handle delete challan request
	
	@GetMapping("/challans/{id}")
	public String deleteChallan(@PathVariable Long id) {
		challanService.deleteChallanById(id);
		return "redirect:/challans";
	}
	
	@GetMapping("/page/{pageno}")
	public String findPaginated(@PathVariable int pageno, Model m){
		
		Page<Challan> challanslist = challanService.getChallanByPaginate(pageno, 5);
		m.addAttribute("challans", challanslist);
		m.addAttribute("currentPage", pageno);
		m.addAttribute("totalPages", challanslist.getTotalPages());
		m.addAttribute("totalItem", challanslist.getTotalElements());
		return "challans";
		
	}
	
}





























