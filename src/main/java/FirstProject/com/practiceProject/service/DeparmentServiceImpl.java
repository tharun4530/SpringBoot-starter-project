package FirstProject.com.practiceProject.service;

import FirstProject.com.practiceProject.entity.Department;
import FirstProject.com.practiceProject.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class DeparmentServiceImpl implements DepartmentService{

    @Autowired
    private DepartmentRepository departmentRepository;
    @Override
    public Department saveDepartment(Department department) {
        return departmentRepository.save((department));
    }

    @Override
    public List<Department> getDepartments() {
        return departmentRepository.findAll();
    }

    @Override
    public Department fetchDepartmentById(Long departmentId) {
        return departmentRepository.findById(departmentId).get();
    }

    @Override
    public void deleteDepartment(Long departmentId) {
        departmentRepository.deleteById((departmentId));
    }

    @Override
    public Department updateDepartment(Long departmentId, Department department) {
        Department depDb = departmentRepository.findById(departmentId).get();
        if(Objects.nonNull(department.getDepartmentName()) && !"".equalsIgnoreCase(department.getDepartmentName())){
            depDb.setDepartmentName(department.getDepartmentName());
        }
        if(Objects.nonNull(department.getDepartmentAddress()) && !"".equalsIgnoreCase(department.getDepartmentAddress())){
            depDb.setDepartmentAddress(department.getDepartmentAddress());
        }
        if(Objects.nonNull(department.getDepartmentCode()) && !"".equalsIgnoreCase(department.getDepartmentCode())) {
            depDb.setDepartmentCode(department.getDepartmentCode());
        }
        System.out.println(depDb);
        return departmentRepository.save(depDb);
    }

    @Override
    public Department getDepartmentByName(String departmentName) {
        return departmentRepository.findByDepartmentName(departmentName);
    }

    @Override
    public Department getDepartmentByNameIgnoreCase(String departmentName) {
        return departmentRepository.findByDepartmentNameIgnoreCase(departmentName);
    }
}
