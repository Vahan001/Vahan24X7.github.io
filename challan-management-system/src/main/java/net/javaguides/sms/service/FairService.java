package net.javaguides.sms.service;

import java.util.List;

import org.springframework.data.domain.Page;

import net.javaguides.sms.entity.Fair;

public interface FairService {
	List<Fair> getAllFairs();
	
	Fair saveFair(Fair fair);
	
	Fair getFairById(Long id);
	
	Fair updateFair(Fair fair);
	
	void deleteFairById(Long id);
	
	Page<Fair> getFairByPaginate(int currentPage, int page);
}