package net.javaguides.sms.service;

import java.util.List;

import org.springframework.data.domain.Page;

import net.javaguides.sms.entity.Challan;

public interface ChallanService {
	List<Challan> getAllChallans();
	
	Challan saveChallan(Challan challan);
	
	Challan getChallanById(Long id);
	
	Challan updateChallan(Challan challan);
	
	void deleteChallanById(Long id);
	
	Page<Challan> getChallanByPaginate(int currentPage, int page);
}