package tech.edev404.easybank.model.entity;

import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;

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
@Table(name="cards")
public class Card {

  @Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name = "card_id")
	private Integer cardId;

	@Column(name = "customer_id")
	private Integer customerId;

	@Column(name = "card_number")
	private String cardNumber;

	@Column(name = "card_type")
	private String cardType;

	@Column(name = "total_limit")
	private Integer totalLimit;

	@Column(name = "amount_used")
	private Integer amountUsed;

	@Column(name = "available_amount")
	private Integer availableAmount;

    @Column(name = "create_dt")
  @CreationTimestamp
	private Date createDt;

}
