package com.caglayan.departmentservice.controller;

import com.caglayan.departmentservice.entity.Department;
import com.caglayan.departmentservice.service.DepartmentService;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/department")
public class DepartmentController {
    private final DepartmentService departmentService;
    private final EurekaClient eurekaClient;

    @Autowired
    public DepartmentController(DepartmentService departmentService, EurekaClient eurekaClient) {
        this.departmentService = departmentService;
        this.eurekaClient = eurekaClient;
    }

    @GetMapping
    public List<Department> getAllDepartments() {
        return departmentService.getAllDepartments();
    }


    @GetMapping("/{id}")
    public Map<String, String> getDepartmentAndCityInfo(@PathVariable("id") long id) {
        Department departmentDB = departmentService.getDepartmentById(id);
        String cityName = getCityFromCityServiceById(departmentDB.getCityId());
        Map<String, String> departmentInfo = new HashMap<>();
        departmentInfo.put("department", departmentDB.getName());
        departmentInfo.put("city", cityName);
        return departmentInfo;
    }


    private String getCityFromCityServiceById(long id) {

        RestTemplate restTemplate = new RestTemplate();
        InstanceInfo instanceInfo = eurekaClient.getNextServerFromEureka("city-service-app", false);
        String cityServiceUrl = instanceInfo.getHomePageUrl();
        cityServiceUrl = cityServiceUrl + "/city/" + id;
        String cityName = restTemplate.getForObject(cityServiceUrl, String.class);
        return cityName;

    }


//    @GetMapping
//    public List<Department> getAllDepartments(){
//        return departmentService.getAllDepartments();
//    }
//
//    @GetMapping("/{id}")
//    public DepartmentDto getDepartmentAndCity(@PathVariable("id") long id){
//        DepartmentDto departmentDto = null;
//        Department department = departmentService.getDepartmentById(id);
//        CityDto cityDto = getCityInfoFromCityService(department.getCityId());
//        if (department.getId()!=0 && cityDto != null){
//            departmentDto = new DepartmentDto(department.getName(), cityDto.getName());
//        }
//        return departmentDto;
//    }
//
//    private CityDto getCityInfoFromCityService(long cityId){
//        CityDto cityDto = null;
//        if (cityId != 0){
//            RestTemplate restTemplate = new RestTemplate();
//            InstanceInfo instanceInfo = eurekaClient.getNextServerFromEureka("city-service-app", false);
//            String cityServiceUrl = instanceInfo.getHomePageUrl();
//            cityServiceUrl = cityServiceUrl + "/city/" + cityId;
//            cityDto = restTemplate.getForObject(cityServiceUrl, CityDto.class);
//        }
//        return cityDto;
//    }
}
