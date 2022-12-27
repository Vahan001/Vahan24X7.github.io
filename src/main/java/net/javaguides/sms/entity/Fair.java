package net.javaguides.sms.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "fairs")
public class Fair {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "cause", nullable = false)
	private String fineCause;
	
	@Column(name = "amount")
	private Integer Amount;

	public Fair() {
		
	}
	
	public Fair(String fineCause, Integer Amount) {
		super();
		this.fineCause = fineCause;
		this.Amount = Amount;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFineCause() {
		return fineCause;
	}

	public void setFineCause(String fineCause) {
		this.fineCause = fineCause;
	}

	public Integer getAmount() {
		return Amount;
	}

	public void setAmount(Integer amount) {
		Amount = amount;
	}
}