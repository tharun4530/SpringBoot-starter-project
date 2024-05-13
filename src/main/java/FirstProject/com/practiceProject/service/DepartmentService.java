package FirstProject.com.practiceProject.service;

import FirstProject.com.practiceProject.entity.Department;

import java.util.List;

public interface DepartmentService {
   public Department saveDepartment(Department department);

   public List<Department> getDepartments();

    public Department fetchDepartmentById(Long departmentId);

    public void deleteDepartment(Long departmentId);

    public Department updateDepartment(Long departmentId, Department department);

    public Department getDepartmentByName(String departmentName);

    public Department getDepartmentByNameIgnoreCase(String departmentName);
}
