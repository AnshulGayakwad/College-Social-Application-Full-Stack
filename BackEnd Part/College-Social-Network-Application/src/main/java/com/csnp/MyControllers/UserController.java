//package com.csnp.MyControllers;
//
//import com.csnp.Models.User;
//import com.csnp.MyServices.UserService;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@RequestMapping("/users")
//public class UserController {
//
//    private final UserService userService;
//
//    // Use @Qualifier to specify which UserService bean to inject
//    public UserController(@Qualifier("userService") UserService userService) {
//        this.userService = userService;
//    }
//
//    @GetMapping("/{id}")
//    public User getUserById(@PathVariable Long id) {
//        return userService.getUserById(id);
//
//    }
//}
