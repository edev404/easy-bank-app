package tech.edev404.easybank.model.entity;

import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

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
@Table(name="account_transactions")
public class Notice {

  @Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name = "notice_id")
	private Integer noticeId;

	@Column(name = "notice_summary")
	private String noticeSummary;

	@Column(name = "notice_details")
	private String noticeDetails;

	@Column(name = "notic_beg_dt")
	private Date noticBegDt;
	
	@Column(name = "notic_end_dt")
	private Date noticEndDt;
	
    @Column(name = "create_dt")
  @CreationTimestamp
	private Date createDt;
	
	@Column(name = "update_dt")
  @UpdateTimestamp
	private Date updateDt;
  
}
