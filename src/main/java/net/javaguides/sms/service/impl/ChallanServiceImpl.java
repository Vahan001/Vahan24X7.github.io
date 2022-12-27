package net.javaguides.sms.service.impl;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import net.javaguides.sms.entity.Challan;
import net.javaguides.sms.repository.ChallanRepository;
import net.javaguides.sms.service.ChallanService;

@Service
public class ChallanServiceImpl implements ChallanService{

	private ChallanRepository challanRepository;
	
	public ChallanServiceImpl(ChallanRepository challanRepository) {
		super();
		this.challanRepository = challanRepository;
	}

	@Override
	public List<Challan> getAllChallans() {
		return challanRepository.findAll();
	}

	@Override
	public Challan saveChallan(Challan challan) {
		return challanRepository.save(challan);
	}

	@Override
	public Challan getChallanById(Long id) {
		return challanRepository.findById(id).get();
	}

	@Override
	public Challan updateChallan(Challan challan) {
		return challanRepository.save(challan);
	}

	@Override
	public void deleteChallanById(Long id) {
		challanRepository.deleteById(id);	
	}

	@Override
	public Page<Challan> getChallanByPaginate(int currentPage, int page) {
		Pageable p = PageRequest.of(currentPage, page);
		return challanRepository.findAll(p);
	}

}