package ru.pish.outadapter.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.pish.outadapter.models.entities.DepartmentsDM;
import ru.pish.outadapter.models.entities.EmployeeDM;

@Repository
public interface DepartmentsRepository extends JpaRepository<DepartmentsDM, Long> {
}

