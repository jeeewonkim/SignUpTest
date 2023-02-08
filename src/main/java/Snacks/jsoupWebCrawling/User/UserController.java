package Snacks.jsoupWebCrawling.User;

import Snacks.jsoupWebCrawling.User.Dto.UserSignUpDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final PasswordEncoder passwordEncoder;
    private final UserService userService;

 /*   @RequestMapping(value = "/signup.do", method = {RequestMethod.GET})
    public String signup(Model model) {
        model.addAttribute("userDto", new UserDto());
        return "signup";
    }

    @PostMapping(value = "/signup.do")
    public String memberForm(@Valid UserDto userDto, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "signup";
        }

        try {
            User user = User.createUser(userDto, passwordEncoder);
            userService.saveUser(user);
            System.out.println(user.getUserId());
            System.out.println(userDto.getUserId());
        } catch (IllegalStateException e) {
            model.addAttribute("errorMessage", e.getMessage());
            System.out.println(e.getMessage());
            return "signup";
        }

        return "redirect:/";

    }*/
    @PostMapping("/signup")
    public ResponseEntity signUp(@Valid @RequestBody UserSignUpDto userSignUpDto)throws Exception {
        userService.signUp(userSignUpDto);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @PostMapping("/checkId")
    public ResponseEntity checkDuplicated(@RequestBody UserSignUpDto userSignUpDto) throws Exception{
        userService.checkDuplicated(userSignUpDto);
        return new ResponseEntity(HttpStatus.OK);
    }

}
