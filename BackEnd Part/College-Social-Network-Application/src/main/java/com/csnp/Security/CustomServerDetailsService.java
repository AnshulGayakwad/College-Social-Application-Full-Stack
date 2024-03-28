//package com.csnp.Security;
//
//
//import com.csnp.MyRepositories.StudentRepository;
//import lombok.AllArgsConstructor;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//@Service
//@AllArgsConstructor
//public class CustomServerDetailsService implements UserDetailsService {
//    private StudentRepository studentRepository;
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        User user = studentRepository.findByMobileNumber()
//    }
//}
