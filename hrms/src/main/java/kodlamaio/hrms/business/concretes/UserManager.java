package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.UserService;
import kodlamaio.hrms.business.constants.Messages;
import kodlamaio.hrms.core.utilities.results.*;
import kodlamaio.hrms.dataAccess.abstracts.UserDao;
import kodlamaio.hrms.entities.concretes.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserManager<T extends User> implements UserService<T> {

    private final UserDao<T> userDao;

    @Autowired
    public UserManager(UserDao<T> userDao) {
        this.userDao = userDao;
    }

    @Override
    public DataResult<List<T>> getAll() {
        return new SuccessDataResult<>(this.userDao.findAll());
    }

    @Override
    public Result add(T user) {
        this.userDao.save(user);
        return new SuccessResult(Messages.userAdded);
    }

    public Result existsByEmail(String email){
        var logic = this.userDao.existsByEmail(email);

        if (logic){
            return new ErrorResult(Messages.emailExist);
        }

        return new SuccessResult(Messages.validationSuccess);
    }
}
