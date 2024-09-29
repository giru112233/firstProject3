package com.example.maru.dto;

import java.util.Date;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ServiceUserDto {

	  /**
     * ID
     */
    private Integer id;
    
    /**
     * 性
     */
    @NotBlank(message = "안녕하세요")
    private String lastName;

    /**
     * 名
     */
   
    private String firstName;

    /**
     * 生年月日
     */
    private Date birthday;

    /**
     * 性別
     */
    private String sex;
    /**
     * 住所１
     */
    private String address1;

    /**
     * 住所２
     */
    private String address2;

    /**
     * 住所３
     */
    private String address3;

    /**
     * 電話番号１
     */
    private String tel1;

    /**
     * 電話番号２
     */
    private String tel2;

    /**
     * 保護者
     */
    private String guardianId;

    /**
     * version
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