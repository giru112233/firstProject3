package com.example.maru.entity;

import java.util.Date;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@EntityListeners(value = AuditingEntityListener.class) //무슨의미인지 모르겟음;
@Table(name = "service")
public class ServiceEntity {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private Integer id;

	//利用者
	@Column(name = "service_user_id")  //TODO 데이터베이스는 스네이크문자
	private Integer serviceUserId;     //TODO 자바외 다른언어에서는 캬넬문자

	//担当者
	@Column(name = "user_id")
	private Integer userId;

	//M_保険
	@Column(name = "insurance_id")
	private String insuranceId;

	//健康情報
	@Column(name = "healthInfo_id")
	private String healthInfoid;

	//利用サービス
	@Column(name = "service_details_id")
	private String serviceDetailsId;

	//予約日時
	@Column(name = "reservation_date")
	private Date reservationDate;

	//キャンセル日時
	@Column(name = "cancle_date")
	private Date cancleDate;

	//利用開始日
	@Column(name = "service_start_date")
	private Date serviceStartDate;

	//利用終了日
	@Column(name = "service_end_date")
	private Date serviceEndDate;

	//利用状況
	@Column(name = "service_status")
	private String serviceStatus;

	/**
	 * version
	 */
	@Column(name = "version")
	private Integer version;

	/**
	 * 削除フラグ
	 */
	@Column(name = "deleteFlag")
	private Boolean deleteFlag;

	/**
	 * 登録者
	 */
	@Column(name = "createUser")
	private String createUser;

	/**
	 * 更新者
	 */
	@Column(name = "updateUser")
	private String updateUser;

	/**
	 * 登録日時
	 */
	@Column(name = "createDate")
	private Date createDate;

	/**
	 * 更新日時
	 */
	@Column(name = "updateDate")
	private Date updateDate;

}
