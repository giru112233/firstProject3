package com.example.maru.dto;

//import java.sql.Date;  찾아볼것
import java.util.Date;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ServiceDto {
	/**
     * ID
     */
	private Integer id;
	
	//利用者
	private Integer serviceUserId;
	
	//担当者
	@NotBlank(message = "xxx3")
	private Integer userId;
	
	//M_保険
	private String insuranceId;
	
	//健康情報
	private String healthInfoId;
	
	//利用サービス
	private String serviceDetailsId;
	
	//予約日時
	private Date reservationDate;
	
	//キャンセル日時
	private Date cancleDate;
	
	//利用開始日
	private Date serviceStartDate;
	
	//利用終了日
	private Date serviceEndDate;
	
	//利用状況
	private String serviceStatus;
	
	/**
     * version1
     */
    private Integer version;

    /**
     * 削除フラグ
     */
    private Boolean deleteFlag;

    /**
     * 登録者
     */
    private String createUser;

    /**
     * 更新者
     */
    private String updateUser;

    /**
     * 登録日時
     */
    private Date createDate;

    /**
     * 更新日時
     */
    private Date updateDate;


}
