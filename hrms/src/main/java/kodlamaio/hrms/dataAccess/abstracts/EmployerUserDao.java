package kodlamaio.hrms.dataAccess.abstracts;

import kodlamaio.hrms.entities.concretes.EmployerUser;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployerUserDao extends UserDao<EmployerUser> {

}
