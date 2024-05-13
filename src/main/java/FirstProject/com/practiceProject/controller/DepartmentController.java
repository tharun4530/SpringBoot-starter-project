package FirstProject.com.practiceProject.controller;

import FirstProject.com.practiceProject.entity.Department;
import FirstProject.com.practiceProject.service.DepartmentService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;

    private final Logger LOGGER = LoggerFactory.getLogger(DepartmentController.class);

    @PostMapping("/departments")
    public Department saveDepartment(@Valid @RequestBody Department department){
        LOGGER.info("Inside SaveDepartment of DepartmentController");
       return departmentService.saveDepartment(department);
    }

    @GetMapping("/departments")
    public List<Department> getDepartments(){
        return departmentService.getDepartments();
    }

    @GetMapping("/departments/{id}")
    public Department fetchDepartmentById(@PathVariable("id") Long departmentId){
        return departmentService.fetchDepartmentById(departmentId);
    }
    @DeleteMapping("/departments/{id}")
    public String deleteDepartment(@PathVariable("id") Long departmentId){
        departmentService.deleteDepartment(departmentId);
        return "Department deleted successfully";
    }
    @PutMapping("/departments/{id}")
    public Department updateDepartment(@PathVariable("id") Long departmentId,@RequestBody Department department){
        return departmentService.updateDepartment(departmentId, department);
    }

//    @GetMapping("/departments/name/{name}")
//    public Department getDepartmentByName(@PathVariable("name") String departmentName){
//        return departmentService.getDepartmentByName(departmentName);
//    }

    @GetMapping("/departments/name/{name}")
    public Department getDepartmentByNameIgnoreCase(@PathVariable("name") String departmentName){
        return departmentService.getDepartmentByNameIgnoreCase(departmentName);
    }
}
