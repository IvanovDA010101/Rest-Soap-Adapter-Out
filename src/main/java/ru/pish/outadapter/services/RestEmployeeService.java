package ru.pish.outadapter.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.stereotype.Service;
import ru.pish.outadapter.models.dto.EmployeeDTO;
import ru.pish.outadapter.models.dto.EmployeesDTO;
import ru.pish.outadapter.models.entities.DepartmentsDM;
import ru.pish.outadapter.models.entities.EmployeeDM;
import ru.pish.outadapter.models.entities.PositionsDM;
import ru.pish.outadapter.repositories.DepartmentsRepository;
import ru.pish.outadapter.repositories.EmployeeRepository;
import ru.pish.outadapter.repositories.PositionRepository;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Service
@EnableCaching
@CacheConfig(cacheNames = "employeeCache")
public class RestEmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private DepartmentsRepository departmentsRepository;
    @Autowired
    private PositionRepository positionRepository;

    @Cacheable(key = "#categoryId", value = "employeeCache")
    public void writeEmployee(EmployeesDTO employees) {
        for (EmployeeDTO employeeDTO : employees.getEmployees()) {

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//            Date birthdate = Date.from(Instant.parse(employeeDTO.getBirthdate()));
            LocalDate birthdate = null;

            DepartmentsDM departmentsDM = DepartmentsDM.builder()
                    .uuid(employeeDTO.getJobInformation().getDepartment().getUuid())
                    .description(employeeDTO.getJobInformation().getDepartment().getDescription())
                    .build();

            departmentsRepository.save(departmentsDM);

            PositionsDM positionsDM = PositionsDM.builder()
                    .uuid(employeeDTO.getJobInformation().getPosition().getUuid())
                    .description(employeeDTO.getJobInformation().getPosition().getDescription())
                    .build();

            positionRepository.save(positionsDM);

            EmployeeDM employee = EmployeeDM.builder()
                    .uuid(employeeDTO.getUuid())
                    .firstName(employeeDTO.getFirstName())
                    .lastName(employeeDTO.getLastName())
                    .middleName(employeeDTO.getMiddleName())
                    .birthdate(birthdate)
                    .departmentUuid(employeeDTO.getJobInformation().getDepartment().getUuid())
                    .positionUuid(employeeDTO.getJobInformation().getPosition().getUuid())
                    .jobNumber(employeeDTO.getPersonalInformation().getJobNumber())
                    .build();

            employeeRepository.save(employee);


        }
    }
    @Cacheable(key = "#categoryId", value = "employeeCache")
    public EmployeeDM getEmployeeById(Long id) {
        return employeeRepository.getReferenceById(id);
    }

    @CacheEvict
    public void deleteEmployeeById(Long id){
        employeeRepository.deleteById(id);
    }
}