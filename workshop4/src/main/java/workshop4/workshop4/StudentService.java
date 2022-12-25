package workshop4.workshop4;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository){
        this.studentRepository=studentRepository;
    }

    public List<Student> findAllStudent(){
           return studentRepository.findAll(); 
    }

    public void saveStudent(Student student){
            Student s = studentRepository.findStudentByEmail(student.getEmail()).get();
            if(s!=null){
                throw new IllegalStateException("Email taken");
            }
            studentRepository.save(student);
    }
    
}
