package com.springboot.fileuploading.ControllerClasses;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.springboot.fileuploading.ModelClass.User;
import com.springboot.fileuploading.ServiceClasses.UserService;

@Controller
public class MainController {
    
    final UserService userService;

    //constructor dependency injection
    @Autowired
    public MainController(UserService userService){
        this.userService=userService;
    }

    /*
     * Post requst upload_data Handler that accept incoming http request and exactract tha name and MultipartFile using @RequestParam from request and process it 
     */

    @RequestMapping(path="/upload_data",method=RequestMethod.POST)
    public String uploadUserData(@ModelAttribute User user ,@RequestParam("image") MultipartFile file){
        return userService.uploadUserData(user,file);
        
    }
    @GetMapping("/home")
    public String home(){
        return "index";
    }
    
}
