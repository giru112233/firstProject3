package com.example.maru.service;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.maru.dto.ServiceUserDto;
import com.example.maru.entity.ServiceUserEnitity;
import com.example.maru.repository.ServiceUserRepository;

import lombok.RequiredArgsConstructor;

/**
 * ユーザー情報 Entity
 */

@Service
@RequiredArgsConstructor
public class ServiceUserService {
	
    @Autowired
    ServiceUserRepository serviceUserRepository;
            
//    @Autowired
//    ServiceUserEnitity serviceUserEnitity;
    
//	private final ServiceUserRepository serviceUserRepository;
    
    private static final ModelMapper modelMapper = new ModelMapper();
    
    

	public List<ServiceUserEnitity> findAll() {
		return serviceUserRepository.findAll();
	}

	public Optional<ServiceUserEnitity> findById(Integer id) {
		return serviceUserRepository.findById(id);
	}
	
	public ServiceUserEnitity create(ServiceUserDto serviceUserDto) {
		// saveとpersistの違い　TODO:調査のみ
		// TODO　saveAll
		// TODO 必須：トランザクションを管理
		//ServiceUserEnitity serviceUserEnitity;
		
//		serviceUserEnitity.setLastName(serviceUserDto.getLastName());
//		serviceUserEnitity.setFirstName(serviceUserDto.getFirstName());
//		//serviceUserEnitity.setBirthday(new Date());
//		serviceUserEnitity.setBirthday(serviceUserDto.getBirthday());
//		serviceUserEnitity.setSex(serviceUserDto.getSex());
//		serviceUserEnitity.setAddress1(serviceUserDto.getAddress1());
//		serviceUserEnitity.setAddress2(serviceUserDto.getAddress2());
//		serviceUserEnitity.setAddress3(serviceUserDto.getAddress3());
//		serviceUserEnitity.setTel1(serviceUserDto.getTel1());
//		serviceUserEnitity.setTel2(serviceUserDto.getTel2());
//		//serviceUserEnitity.setDeleteFlag(false);
//		serviceUserEnitity.setDeleteFlag(serviceUserDto.getDeleteFlag());
		
		//ServiceUserEnitity serviceUserEnitity = modelMapper.map(serviceUserDto, ServiceUserEnitity.class);//주의해야할점 51~61행까지 각각의 항목의 이름이(엔티티와 디티오항목이름 같아야함) 똑같아야한다 매핑이된다
		
		
		//ServiceUserEnitity serviceUserEnitity =serviceUserRepository.save(modelMapper.map(serviceUserDto, ServiceUserEnitity.class));
		return serviceUserRepository.save(modelMapper.map(serviceUserDto, ServiceUserEnitity.class));
		//0928개념정리하기 
	}
	
	public Optional<ServiceUserEnitity>  update(Integer id) {
		Optional<ServiceUserEnitity> optionalserviceUserEnitity = serviceUserRepository.findById(id);
		
		// 対象が存在する場合更新、存在しない場合エラー
		optionalserviceUserEnitity.ifPresentOrElse(
				e -> {
					e.setFirstName("g");
					e.setLastName("h");
//					e.setDeleteFlag(false);
					ServiceUserEnitity aa =serviceUserRepository.save(e);
				},
				() -> System.out.println("에러처리추가（갱신대상이존재x"));

		// 戻り値タイプ確認
		return optionalserviceUserEnitity;

	}
}