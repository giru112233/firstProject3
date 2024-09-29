package com.example.maru.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.maru.dto.ServiceDto;
import com.example.maru.entity.ServiceEntity;
import com.example.maru.repository.ServiceRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor //의미?
public class ServiceService {
	
	@Autowired
	ServiceRepository serviceRepository;
	
	public List<ServiceEntity> findAll() {
		return serviceRepository.findAll();
	}

	public Optional<ServiceEntity> findById(Integer id) {
		return serviceRepository.findById(id);
	}
	//롬북이 getset데이터를 만들어주는역활
	public ServiceEntity create(ServiceDto sd) {
		// saveとpersistの違い　TODO:調査のみ
		// TODO　saveAll
		// TODO 必須：トランザクションを管理
		ServiceEntity serviceEntity = new ServiceEntity();
		
		serviceEntity.setServiceUserId(sd.getServiceUserId());
		serviceEntity.setUserId(sd.getUserId());
		serviceEntity.setInsuranceId(sd.getInsuranceId());
		serviceEntity.setHealthInfoid(sd.getHealthInfoId());
		serviceEntity.setServiceDetailsId(sd.getServiceDetailsId());
		serviceEntity.setReservationDate(sd.getReservationDate());
//		serviceEntity.setCancleDate(new Date());
//		serviceEntity.setServiceStartDate(null);
//		serviceEntity.setServiceEndDate(null);
//		serviceEntity.setServiceStatus(null);
//		serviceEntity.setVersion(null);
//		serviceEntity.setDeleteFlag(false);
//		serviceEntity.setCreateUser(null);
//		serviceEntity.setUpdateUser(null); 
//		serviceEntity.setCreateDate(null);
//		serviceEntity.setUpdateDate(null);
//		serviceUserEnitity.setFirstName("b");
//		serviceUserEnitity.setBirthday(new Date());
//		serviceUserEnitity.setSex("v");
//		serviceUserEnitity.setAddress1("d");
//		serviceUserEnitity.setAddress2("e");
//		serviceUserEnitity.setAddress3("f");
//		serviceUserEnitity.setTel1("08012346789");
//		serviceUserEnitity.setTel2("08012349999");
//		serviceUserEnitity.setDeleteFlag(false);
		
		ServiceEntity bb =serviceRepository.save(serviceEntity);
		return bb;		
		
	}
	public Optional<ServiceEntity>  update(Integer id) {
		Optional<ServiceEntity> optionalserviceEntity = serviceRepository.findById(id);
		
		// 対象が存在する場合更新、存在しない場合エラー
		optionalserviceEntity.ifPresentOrElse(
				e -> {
					e.setServiceUserId(002);
					e.setUserId(002);
//					e.setDeleteFlag(false);
					ServiceEntity bb =serviceRepository.save(e);
				},
				() -> System.out.println("에러처리추가（갱신대상이존재x"));

		// 戻り値タイプ確認
		return optionalserviceEntity;

	}

}
