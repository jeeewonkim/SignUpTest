package Snacks.jsoupWebCrawling.User;

import lombok.RequiredArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
@EnableWebSecurity
@RequiredArgsConstructor

public class SecurityConfig extends WebSecurityConfigurerAdapter {
    public void configure(WebSecurity webSecurity) throws Exception {
        webSecurity.ignoring().antMatchers("/css/**", "/script/**", "image/**", "/fonts/**", "lib/**");
    }

    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable() //csrf 공격을 막아주는 옵션을 disable
                .headers().frameOptions().disable()
                .and()
                .logout().logoutSuccessUrl("/") //로그아웃 요청시 홈으로 이동
                .and()
                .formLogin()
                .loginPage("/login.do")
                .usernameParameter("userID")
                .passwordParameter("password")
                .and()
                .authorizeRequests()
                //.antMatchers("/admin/**").hasRole("ADMIN")
                .antMatchers("/**").permitAll();


    }


    @Bean
    public PasswordEncoder getPasswordEncoder() {
        return new BCryptPasswordEncoder();

    }
}
