package net.javaguides.sms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.javaguides.sms.entity.Challan;

public interface ChallanRepository extends JpaRepository<Challan, Long>{

}