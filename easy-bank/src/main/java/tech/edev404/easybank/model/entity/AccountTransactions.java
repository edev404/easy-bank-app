package tech.edev404.easybank.model.entity;


import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
@Table(name="account_transactions")
public class AccountTransactions {

  @Column(name = "transaction_id")
	private String transactionId;
	
	@Column(name="account_number")
	private Long accountNumber;
	
	@Column(name = "customer_id")
	private int customerId;
	
  @Column(name = "transaction_dt")
  @CreationTimestamp
	private Date transactionDt;
	
	@Column(name = "transaction_summary")
	private String transactionSummary;
	
	@Column(name="transaction_type")
	private String transactionType;
	
	@Column(name = "transaction_amt")
	private Integer transactionAmt;
	
	@Column(name = "closing_balance")
	private Integer closingBalance;
	
	@Column(name = "create_dt")
	private String createDt;

}
