package api;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import pojo.Student_Role;
import pojo.TStudent;

public interface StudentApi {
    @PostMapping("/student/insertStudent")
    public void insertStudent(@RequestBody TStudent student);

    @PostMapping("/student/insertStudentRole")
    public void insertStudentRole(@RequestBody Student_Role student);
}
