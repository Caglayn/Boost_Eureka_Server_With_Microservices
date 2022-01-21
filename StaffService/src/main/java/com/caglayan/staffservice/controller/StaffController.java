package com.caglayan.staffservice.controller;

import com.caglayan.staffservice.entity.Staff;
import com.caglayan.staffservice.service.StaffService;
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
@RequestMapping("/staff")
public class StaffController {

    private final StaffService staffService;
    private final EurekaClient eurekaClient;

    @Autowired
    public StaffController(StaffService staffService, EurekaClient eurekaClient) {
        this.staffService = staffService;
        this.eurekaClient = eurekaClient;
    }

    @GetMapping
    public List<Staff> getAll(){
        return staffService.getAllStaff();
    }

    @GetMapping("/{id}")
    public Map<String, String> getStaffInfo(@PathVariable("id") long id){
        Staff staff = staffService.getStaffById(id);
        Map<String, String> departmentInfo = getDepartmentInfo(staff.getDepartmentId());
        departmentInfo.put("id", Long.toString(staff.getId()));
        departmentInfo.put("name", staff.getName());
        departmentInfo.put("lastname", staff.getLastName());

        return departmentInfo;
    }

    private Map<String, String> getDepartmentInfo(long id){
        RestTemplate restTemplate = new RestTemplate();
        InstanceInfo instanceInfo = eurekaClient.getNextServerFromEureka("department-service-app", false);
        String departmentServiceUrl = instanceInfo.getHomePageUrl();
        departmentServiceUrl = departmentServiceUrl + "/department/" + id;
        Map<String, String> departmentInfo = restTemplate.getForObject(departmentServiceUrl, Map.class);
        return  departmentInfo;
    }
}
