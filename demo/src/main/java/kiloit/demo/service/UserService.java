package kiloit.demo.service;

import kiloit.demo.base.BaseService;
import kiloit.demo.base.StructureRS;
import kiloit.demo.config.constants.MessageConstant;
import kiloit.demo.model.to.UserTO;
import kiloit.demo.security.exeception.exception.BadResqestException;
import org.apache.catalina.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService extends BaseService {
    private final List<UserTO> users = new ArrayList<>();

    public List<UserTO> getUsers() {
        return this.users;
    }

    public UserTO getByID(Long id) {
        Optional<UserTO> optionalUserTO = this.users.stream().filter(it -> it.getId().equals(id)).findFirst();
        return optionalUserTO.orElse(null);
    }
    //new teachni
//    public ResponseEntity<?> addUser(UserTO userTO){
//       Optional<UserTO> optionalUserTO = this.users.stream().filter(user->user.equals(userTO.getId())).findFirst();
//       if (optionalUserTO.isPresent()){
//           return new ResponseEntity<Object>("User not found!", HttpStatus.NOT_FOUND);
//       }
//       this.users.add(userTO);
//       return ResponseEntity.ok("user add");
//    }

    public String addUser(UserTO userto){
        Optional<UserTO>optionalUserTO =this.users.stream().filter(it->it.getId().equals(userto.getId())).findFirst();
        if (optionalUserTO.isPresent())
//            return "User already exist!";
            throw new BadResqestException(MessageConstant.ERROR_INSERT_USER);
        this.users.add(userto);
            return "User added";

    }
    public StructureRS update(long id, UserTO userTO) {
        Optional<UserTO> optionalUserTo = this.users.stream().filter(it -> it.getId().equals(id)).findFirst();
        if (optionalUserTo.isPresent()) {
            UserTO newUserTo = optionalUserTo.get();
            newUserTo.setName(userTO.getName());
            return response();
        }
        throw new BadResqestException(MessageConstant.USER_COULD_NOT_BE_FOUND) ;
    }
    public String delete(long id){
        Optional<UserTO>optionalUserTO=this.users.stream().filter(it->it.getId().equals(id)).findFirst();
        if (optionalUserTO.isEmpty())
//            return "user with id:"+id + "could not found!";
            throw new BadResqestException(MessageConstant.USER_COULD_NOT_BE_FOUND);
        this.users.remove(optionalUserTO.get());
            return "user with id:"+id+"has been delete it";
    }
}