package com.example.maru.controller;

import java.util.List;
import java.util.Optional;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.maru.dto.ServiceDto;
import com.example.maru.dto.ServiceUserDto;
import com.example.maru.entity.ServiceEntity;
import com.example.maru.entity.ServiceUserEnitity;
import com.example.maru.service.ServiceService;
import com.example.maru.service.ServiceUserService;

import jakarta.validation.Valid;
import jakarta.validation.constraints.PositiveOrZero;

@RestController
@RequestMapping(value = "/")
public class HomeController {

	@Autowired
	ServiceUserService serviceUserService;
	@Autowired
	ServiceService serviceService;
	
	

	//    @Autowired
	//    DepartmentService departmentService;

	/**
	 * 初期化
	 * @return
	 */
	//    @RequestMapping(path="/init", method = RequestMethod.GET)
	//    public HomeInitResultDto init() {
	//
	//        HomeInitResultDto resultDto = new HomeInitResultDto();
	//        resultDto.employeeList = employeeService.selectAll();
	////        resultDto.departmentList = departmentService.selectAll();
	//
	//        return resultDto;
	//    }
	//    

	@GetMapping("serviceUser")
	public List<ServiceUserEnitity> getServiceUser() {
		return serviceUserService.findAll();

	}

	// @PathVariable：URLの一部をメソッドの引数として受け取るために使用する。OK
	@GetMapping("serviceUserForId/{id}")
	public Optional<ServiceUserEnitity> findServiceUserById(@PathVariable Integer id) {
		return serviceUserService.findById(id);
	}

	//	@GetMapping("/serviceUserForId")
	//	public Optional<ServiceUserEnitity> getServiceUserById(@RequestParam(value="id") Integer id) {
	//		return serviceUserService.findById(id);
	//	}

	// @PathVariable：URLの一部をメソッドの引数として受け取るために使用する。OK
	@GetMapping("updateServiceUserById/{id}")
	@PositiveOrZero
	public Optional<ServiceUserEnitity> updateServiceUserById(@PathVariable String id) throws Exception {
		// 숫자 검사기
		
		isNumeric(id);

		//boolean ck = isNumeric(id);

		if (isNumeric(id) == true) {

			return serviceUserService.update(Integer.parseInt(id));
		} else {
			throw new Exception();
		} //강제로 Exception객체를 생성하였습니다.

	}

	@PostMapping("createServiceUser")
	public ServiceUserEnitity create(@Valid @RequestBody ServiceUserDto sud) {
		
		
		
		
		return serviceUserService.create(sud);

	}

	// @RequestBodyを付けることで、json形式で受け取る。
	// 変数名はなんでもいいが、プロパティが一致する必要がある。
	//	@PostMapping("/regest")
	//	public String create(@RequestBody ServiceUserDto serviceUserDto) {
	//		return serviceUserService.create();
	//
	//	}

	//------------------------------serviceDB連動
	@GetMapping("service")
	public List<ServiceEntity> getService() {
		return serviceService.findAll();

	}

	@GetMapping("serviceForId/{id}")
	public Optional<ServiceEntity> findServiceById(@PathVariable Integer id) {
		return serviceService.findById(id);
	}

	@PostMapping("/createService")
	public ServiceEntity create(@RequestBody ServiceDto sd) {
	    return serviceService.create(sd);
	}
//	
//	@GetMapping("updateServiceById/{id}")
//	@PositiveOrZero
//	public Optional<ServiceEntity> updateServiceById(@PathVariable String id) throws Exception {
//		// 1番
//		
//		isNumeric(id);
//
//		//boolean ck = isNumeric(id);
//
//		if (isNumeric(id) == true) {
//
//			return serviceService.update(Integer.parseInt(id));
//		} else {
//			throw new Exception();
//		} //강제로 Exception객체를 생성하였습니다.
//
//	}
//
	public boolean isNumeric(String str) {
		return Pattern.matches("^[0-9]*$",str);
	}
	
	


}
