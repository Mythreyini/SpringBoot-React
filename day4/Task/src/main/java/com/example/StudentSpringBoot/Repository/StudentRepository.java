package com.example.StudentSpringBoot.Repository;

import com.example.StudentSpringBoot.model.StudentModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface StudentRepository extends JpaRepository<StudentModel,Integer> {
    StudentModel findReferenceById(int id);

    List<StudentModel> findByCourse(String course);
    List<StudentModel> findByName(String name);
}
