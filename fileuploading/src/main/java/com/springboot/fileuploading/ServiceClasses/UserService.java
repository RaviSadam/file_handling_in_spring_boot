package com.springboot.fileuploading.ServiceClasses;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.springboot.fileuploading.ModelClass.User;
import com.springboot.fileuploading.Repositories.UserRepo;

@Service
public class UserService {

    private UserRepo userRepo;

    @Autowired
    public UserService(UserRepo userRepo){
        this.userRepo=userRepo;
    }
    
    public String uploadUserData(User user, MultipartFile file) {
        System.out.println("User Name:"+user.getName());
        System.out.println("File specifications");
        System.out.println("File name"+file.getName());
        System.out.println("File Original Name"+file.getOriginalFilename());
        System.out.println("File Type"+file.getContentType());
        System.out.println("File Size in bytes"+file.getSize());
        System.out.println("File Size in Mb's"+file.getSize()/(1048576));

        Random random=new Random();
        byte b[]=new byte[20];
        random.nextBytes(b);
        

        //get random name
        String randomFileName=this.generateRandomString()+file.getOriginalFilename();
        System.out.println(randomFileName);

        Path path=Path.of("C:/Users/ravis/Documents/Ravi/Programming/Java/SpringBoot/fileuploading/src/main/resources/static/Images/"+randomFileName);
        try{
            file.transferTo(path);
            user.setImageName(randomFileName);
            userRepo.save(user);
        }
        catch(IOException exception){
            System.out.println(exception.getMessage());
            return "Error";
        }
        catch(IllegalStateException illegalStateException){
            try {
                Files.deleteIfExists(path);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        catch(Exception exception){
            System.out.println(exception.getMessage());
        }
        System.out.println("File Successfilly uploaded and moved to destination location");
        return "success";
    }
    private String generateRandomString() {
        // Define the characters that can be used in the random string
        String allowedChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789{}()!@#$%&-+=_";

        // Create a StringBuilder to store the random string
        StringBuilder randomString = new StringBuilder(30);

        // Create a random number generator
        Random random = new Random();

        // Generate the random string
        for (int i = 0; i < 30; i++) {
            int randomIndex = random.nextInt(allowedChars.length());
            randomString.append(allowedChars.charAt(randomIndex));
        }
        return randomString.toString();
    }
    
}
