package kiloit.demo.controller;


import kiloit.demo.base.StructureRS;
import kiloit.demo.model.to.UserTO;
import kiloit.demo.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("api/v1.0.0/user")
@RestController

public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
//
    @GetMapping //get User all
    public ResponseEntity<List<UserTO>>getUser(){
        return ResponseEntity.ok(userService.getUsers());
    }
    @GetMapping("{id}")
    public ResponseEntity<UserTO>getUser(@PathVariable Long id) {
        return ResponseEntity.ok(userService.getByID(id));
    }
//NEW Teach
//    @ResponseStatus(HttpStatus.CREATED)
//    @PostMapping
//    public ResponseEntity<?> addUser(@RequestBody UserTO userTO){
//        return ResponseEntity.ok(userService.addUser(userTO));
//    }
    @PostMapping
    public ResponseEntity<String>addUser(@RequestBody UserTO userTo){
        return ResponseEntity.ok(userService.addUser(userTo));
    }
    @PutMapping("{id}")
  public  ResponseEntity<StructureRS>update(@PathVariable long id, @RequestBody UserTO userTO){
    return ResponseEntity.ok(userService.update(id,userTO));
    }
    @DeleteMapping("{id}")

    public ResponseEntity<String>delete(@PathVariable long id){
        return ResponseEntity.ok(userService.delete(id));
    }

}






//@GetMapping
//    public ResponseEntity<String> getUser(){
//        return ResponseEntity.ok("Hello from user controller");
//    }
