package Snacks.jsoupWebCrawling.User.Dto;

import Snacks.jsoupWebCrawling.User.User;

public class UserSignUpDto {
    private String userId;
    private String userName;
    private String password;

    public String getUserId() {
        return userId;
    }

    public UserSignUpDto(String userId, String userName, String password){
        this.userId = userId;
        this.userName  = userName;
        this.password = password;
    }
    public User toEntity(){
        return User.builder()
                .userId(userId)
                .userName(userName)
                .password(password)
                .platformType("own")
                .build();
    }

}
