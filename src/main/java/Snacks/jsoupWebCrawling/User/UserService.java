package Snacks.jsoupWebCrawling.User;

import Snacks.jsoupWebCrawling.Repository.UserRepository;
import Snacks.jsoupWebCrawling.User.Dto.UserSignUpDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


@Transactional //로직을 처리하다가 에러가 발생하면, 변경된 데이터를 로직을 수행하기 이전 상태로 콜백
@Service
public interface UserService {
    void signUp(UserSignUpDto userSignUpDto) throws Exception;
    void checkDuplicated(UserSignUpDto userSignUpDto) throws Exception;

}