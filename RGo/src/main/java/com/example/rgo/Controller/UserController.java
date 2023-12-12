package com.example.rgo.Controller;

import com.example.rgo.Model.MyUser;
import com.example.rgo.Service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/user")
public class UserController {
    private final UserService userService;
    Logger logger= LoggerFactory.getLogger(UserController.class);

    @GetMapping("/get")
    public ResponseEntity getAllUser(){
        return ResponseEntity.status(HttpStatus.OK).body(userService.getAllUser());
    }
    @PostMapping("/add")
    public ResponseEntity addUser(@RequestBody @Valid MyUser myUser) {
        logger.info("added user");
        userService.addUser(myUser);
        return ResponseEntity.status(HttpStatus.OK).body("added user");
    }
    @PutMapping("/put/{id}")
    public ResponseEntity updateUser(@PathVariable Integer id ,@RequestBody @Valid MyUser myUser){
        logger.info("update user");

        return ResponseEntity.status(HttpStatus.OK).body(userService.updateUser(id, myUser));
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteUser(@PathVariable Integer id){
        logger.info("delete user");

        return ResponseEntity.status(HttpStatus.OK).body(userService.deleteUser(id));
    }
    @GetMapping("search/{id}")
    public ResponseEntity searchUser(@PathVariable Integer id){
        List<MyUser> myUsers =userService.searchAllUser(id);
        return ResponseEntity.status(HttpStatus.OK).body(myUsers);
    }
    @GetMapping("check/{number}")
    public ResponseEntity checkNumber(@PathVariable String number){
        MyUser users =userService.check(number);
        return ResponseEntity.status(HttpStatus.OK).body(users);
    }
    @GetMapping("scan/{user}")
    public ResponseEntity checkUser(@PathVariable String user){
        logger.info("search user");

        MyUser User =userService.checkUserName(user);
        return ResponseEntity.status(HttpStatus.OK).body(User);
    }
    @GetMapping("retern/{email}")
    public ResponseEntity checkEmail(@PathVariable String email){
        MyUser Users =userService.reternEmail(email);
        return ResponseEntity.status(HttpStatus.OK).body(Users);
    }

}
