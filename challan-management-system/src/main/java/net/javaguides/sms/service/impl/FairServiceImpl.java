package net.javaguides.sms.service.impl;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import net.javaguides.sms.entity.Fair;
import net.javaguides.sms.repository.FairRepository;
import net.javaguides.sms.service.FairService;

@Service
public class FairServiceImpl implements FairService{

	private FairRepository fairRepository;
	
	public FairServiceImpl(FairRepository fairRepository) {
		super();
		this.fairRepository = fairRepository;
	}

	@Override
	public List<Fair> getAllFairs() {
		return fairRepository.findAll();
	}

	@Override
	public Fair saveFair(Fair fair) {
		return fairRepository.save(fair);
	}

	@Override
	public Fair getFairById(Long id) {
		return fairRepository.findById(id).get();
	}

	@Override
	public Fair updateFair(Fair fair) {
		return fairRepository.save(fair);
	}

	@Override
	public void deleteFairById(Long id) {
		fairRepository.deleteById(id);	
	}
	
	@Override
	public Page<Fair> getFairByPaginate(int currentPage, int page) {
		Pageable p = PageRequest.of(currentPage, page);
		return fairRepository.findAll(p);
	}

}