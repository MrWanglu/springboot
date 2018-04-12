package cn.sboot.pojo;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "User")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable{
    @Id
    @Column(name = "user_id", nullable = false)
    @GeneratedValue
    private Integer userId;
    @Column(name = "user_name")
    private String userName;
    @Column(name = "user_sex")
    private String userSex;
    @Column(name = "user_pwd")
    private String userPwd;
}