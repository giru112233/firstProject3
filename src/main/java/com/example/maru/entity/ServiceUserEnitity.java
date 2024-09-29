package com.example.maru.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Data;

/**
 * ユーザー情報 Entity
 */
@Entity
@Data
@EntityListeners(value = AuditingEntityListener.class)
@Table(name = "service_user")
public class ServiceUserEnitity {

	/**
	 * ID
	 * @GeneratedValue：プライマリキーカラムにユニークな値を自動で生成，付与する方法を指定するアノテーション。
	 *  @Idを持つエンティティクラスなどに適用される。
	 * Strategy：プライマリキー値を生成する方法を指定する属性。
	 * GenerationType.IDENTITY：データベースのidentity列を利用して，プライマリキー値を生成する。
	 */
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	/**
	 * 性
	 */
	@Column(name = "last_name")
	private String lastName;

	/**
	 * 名
	 */
	@Column(name = "first_name")
	private String firstName;

	/**
	 * 生年月日
	 */
	@Column(name = "birthday")
	private Date birthday;

	/**
	 * 性別
	 */
	@Column(name = "sex")
	private String sex;
	/**
	 * 住所１
	 */
	@Column(name = "address_1")
	private String address1;

	/**
	 * 住所２
	 */
	@Column(name = "address_2")
	private String address2;

	/**
	 * 住所３
	 */
	@Column(name = "address_3")
	private String address3;

	/**
	 * 電話番号１
	 */
	@Column(name = "tel_1")
	private String tel1;

	/**
	 * 電話番号２
	 */
	@Column(name = "tel_2")
	private String tel2;

	/**
	 * 保護者
	 */
	@Column(name = "guardian_id")
	private String guardianId;

	/**
	 * version
	 */
	@Column(name = "version")
	private Integer version;

	/**
	 * 削除フラグ
	 * 下記設定でデフォルト値falseが設定されない。TODO:調査のみ
	 */
	@Column(name = "delete_flag", columnDefinition = "boolean default false")
	private Boolean deleteFlag;

	/**
	 * 登録者
	 */
	@CreatedBy
	@Column(name = "create_user")
	private String createUser;

	/**
	 * 更新者
	 */
	@LastModifiedBy
	@Column(name = "update_user")
	private String updateUser;

	/**
	 * 登録日時
	 */
	@CreatedDate
	@Column(name = "create_date")
	private Date createDate;

	/**
	 * 更新日時
	 */
	@LastModifiedDate
	@Column(name = "update_date")
	private Date updateDate;

}