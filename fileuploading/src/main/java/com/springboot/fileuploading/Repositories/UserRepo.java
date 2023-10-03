package com.springboot.fileuploading.Repositories;

import org.springframework.data.repository.CrudRepository;

import com.springboot.fileuploading.ModelClass.User;

public interface UserRepo extends CrudRepository<User,Long>{
    
}
