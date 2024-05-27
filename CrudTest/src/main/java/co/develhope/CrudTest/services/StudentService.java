package co.develhope.CrudTest.services;

import co.develhope.CrudTest.entities.Student;
import co.develhope.CrudTest.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;

    public Student getStudentById(Long id){
        return studentRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }
    public Iterable<Student> getAllStudents(){
        return studentRepository.findAll();
    }
    public Student postStudent(Student student){
        Optional <Student> optionalStudent = Optional.ofNullable(studentRepository.findByCodiceFiscale(student.getCodiceFiscale()));
        if(optionalStudent.isEmpty()){
            throw new IllegalArgumentException("Student already exists");
        }else{
           return studentRepository.save(student);
        }
    }
    public Student updateStudent(Student student, Long id){
        Optional <Student> optionalStudent = studentRepository.findById(id);
        if(optionalStudent.isPresent()){
        Student updatedStudent = optionalStudent.get();
        updatedStudent.setName(student.getName());
        updatedStudent.setSurname(student.getSurname());
        return studentRepository.save(updatedStudent);
        }else{
            throw new NoSuchElementException("User not found");
        }
    }
    public Student isWorkingUpdate(Long id, Boolean isWorking){
      Student student = studentRepository.findById(id).orElseThrow(()->new NoSuchElementException("User not found"));
      student.setIsWorking(isWorking);
      return studentRepository.save(student);
    }


    public void deleteStudent(Long id){
        studentRepository.deleteById(id);
    }
}
