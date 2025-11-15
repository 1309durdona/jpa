package idrok.service;


import idrok.model.Student;
import idrok.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {



   private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student create(Student student) {

        return studentRepository.save(student);
    }

    public List<Student> getAll(){
        return studentRepository.findAll();
    }

    public Optional<Student> findById(Long id) {
        return studentRepository.findById(id);
    }


    public Student update(Long id, Student student) {
        Student updatedStudent = studentRepository.findById(id)
                        .orElseThrow(() -> new RuntimeException("Student not found"));

        updatedStudent.setName(student.getName());
        updatedStudent.setEmail(student.getEmail());

        return studentRepository.save(updatedStudent);
    }
}
