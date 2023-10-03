package com.springboot.fileuploading.ModelClass;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name="regester_user")
public class User {

    @Id
    @SequenceGenerator(
        name = "user_id",
        sequenceName="user_id_generator",
        allocationSize = 1
    )
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "user_id_generator"
    )
    private int id;

    @Column(length = 30)
    private String name;
    @Column(length = 15)
    private String gender;
    private String email;
    @Column(length = 15)
    private String phone;
    private String imageName;
    
}
