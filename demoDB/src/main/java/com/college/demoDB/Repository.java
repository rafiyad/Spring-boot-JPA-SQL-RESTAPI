package repository;

import com.example.demodb.StudentID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Repository extends JpaRepository <StudentID, Integer> {


}
