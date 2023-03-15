package com.repository;

import com.model.Employee;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Long > {
    @Modifying
    @Transactional
    @Query(value = "update Employee e set e.salary = ?2 where e.id=?1")
    public void updateEmployeeById(long id, int salary);
}
