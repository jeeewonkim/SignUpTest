package Snacks.jsoupWebCrawling.User;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.*;

@NoArgsConstructor
@DynamicUpdate //update 할때 실제 값이 변경된 컬럼으로만 update 쿼리를 만듦
@Entity
@Getter
@Table(name = "userTBL")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userNum")
    private Long userNum;

    @Column(name = "userID")
    private String userId;

    @Column(name = "userEmail")
    private String userEmail;

    @Column(name = "userName")
    private String userName;

    @Column(name = "platformType")
    private String platformType;

    @Column(name = "password")
    private String password;

    @Enumerated(EnumType.STRING)
    private UserRole role;

    @Builder
    public User(Long userNum, String userId, String userEmail, String userName, String password, String platformType, UserRole role) {
        this.userNum = userNum;
        this.userId = userId;
        this.userEmail = userEmail;
        this.userName = userName;
        this.password = password;
        this.platformType = platformType;
        this.role = role;
    }

   /* public static User createUser(UserInfoDto userDto, PasswordEncoder passwordEncoder) {
        User user = User.builder()
                .userId(userDto.getUserId())
                .userEmail(null)
                .platformType("own")
                .userName(userDto.getUserName())
                .password(passwordEncoder.encode(userDto.getPassword()))
                .role(UserRole.USER)
                .build();
        return user;

    }*/

    public void encodePassword(PasswordEncoder passwordEncoder){
        this.password = passwordEncoder.encode(password);
    }

    public void addUserAuthority(){
        this.role = role.USER;
    }
}
