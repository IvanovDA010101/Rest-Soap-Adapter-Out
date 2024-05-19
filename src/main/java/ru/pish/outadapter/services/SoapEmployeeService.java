package ru.pish.outadapter.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.pish.education.EmployeeItem;
import ru.pish.education.Employees;
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
public class SoapEmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private DepartmentsRepository departmentsRepository;
    @Autowired
    private PositionRepository positionRepository;

    public void writeEmployee(Employees employees) {
        for (EmployeeItem employeeDTO : employees.getEmployee()) {

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate birthdate = LocalDate.parse(employeeDTO.getBirthdate().toString(), formatter);

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

    public EmployeeDM getEmployeeById(Long id) {
        return employeeRepository.getReferenceById(id);
    }

}