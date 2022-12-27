package net.javaguides.sms.controller;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import net.javaguides.sms.entity.Fair;
import net.javaguides.sms.service.FairService;

@Controller
public class FairController {
	
	private FairService fairService;

	public FairController(FairService fairService) {
		super();
		this.fairService = fairService;
	}
	
	// handler method to handle list fairs and return mode and view
	@GetMapping("/fairs")
	public String listFairs(Model m) {
		/*
		 * model.addAttribute("fairs", fairService.getAllFairs()); return "fairs";
		 */
		return findsPaginated(0, m);
	}
	
	@GetMapping("/fairs/new")
	public String createfairForm(Model model) {
		
		// create fair object to hold fair form data
		Fair fair = new Fair();
		model.addAttribute("fair", fair);
		return "create_fair";
		
	}
	
	@PostMapping("/fairs")
	public String saveFair(@ModelAttribute("fair") Fair fair) {
		fairService.saveFair(fair);
		return "redirect:/fairs";
	}
	
	@GetMapping("/fairs/edit/{id}")
	public String editFairForm(@PathVariable Long id, Model model) {
		model.addAttribute("fair", fairService.getFairById(id));
		return "edit_fair";
	}

	@PostMapping("/fairs/{id}")
	public String updateFair(@PathVariable Long id,
			@ModelAttribute("fair") Fair fair,
			Model model) {
		
		// get fair from database by id
		Fair existingFair = fairService.getFairById(id);
		existingFair.setId(id);
		existingFair.setFineCause(fair.getFineCause());
		existingFair.setAmount(fair.getAmount());
		
		// save updated fair object
		fairService.updateFair(existingFair);
		return "redirect:/fairs";		
	}
	
	// handler method to handle delete fair request
	
	@GetMapping("/fairs/{id}")
	public String deleteFair(@PathVariable Long id) {
		fairService.deleteFairById(id);
		return "redirect:/fairs";
	}
	
	@GetMapping("/pages/{pagesno}")
	public String findsPaginated(@PathVariable int pagesno, Model m){
		
		Page<Fair> fairlist = fairService.getFairByPaginate(pagesno, 5);
		m.addAttribute("fairs", fairlist);
		m.addAttribute("CurrentPage", pagesno);
		m.addAttribute("totalPage", fairlist.getTotalPages());
		m.addAttribute("totalItems", fairlist.getTotalElements());
		return "fairs";
		
	}
	
}