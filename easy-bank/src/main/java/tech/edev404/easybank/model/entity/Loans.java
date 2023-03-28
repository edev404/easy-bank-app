package tech.edev404.easybank.model.entity;

import java.util.Date;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="loans")
public class Loans {

  @Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name = "loan_number")
	private Integer loanNumber;
	
	@Column(name = "customer_id")
	private Integer customerId;
	
	@Column(name="start_dt")
	private Date startDt;
	
	@Column(name = "loan_type")
	private String loanType;
	
	@Column(name = "total_loan")
	private Integer totalLoan;
	
	@Column(name = "amount_paid")
	private Integer amountPaid;
	
	@Column(name = "outstanding_amount")
	private Integer outstandingAmount;
	
	@Column(name = "create_dt")
    private String createDt;
  
}
