package Snacks.jsoupWebCrawling.User;

import Snacks.jsoupWebCrawling.Repository.UserRepository;
import Snacks.jsoupWebCrawling.User.Dto.UserSignUpDto;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public void signUp(UserSignUpDto userSignUpDto) throws Exception {
        User user = userSignUpDto.toEntity();
        user.addUserAuthority();
        user.encodePassword(passwordEncoder);
        System.out.println(userRepository.findByUserId(user.getUserId()));

        userRepository.save(user);
    }

    public void checkDuplicated(UserSignUpDto userSignUpDto) throws Exception {
        Optional<User> userCheck = userRepository.findByUserId(userSignUpDto.getUserId());
        if (!userCheck.isEmpty()) {
            throw new Exception("ID exists");
        }
    }
}

