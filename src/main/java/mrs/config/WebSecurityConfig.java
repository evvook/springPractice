package mrs.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import mrs.domain.service.user.ReservationUserDetailsService;

//웹에서 만든 보안화면을 사용하기 위함
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig{

	//빈으로 등록만 하면 명시적으로 사용하지 않더라도 자동적으로 사용가능1
	@Autowired
	ReservationUserDetailsService userDetailService;

	//빈으로 등록만 하면 명시적으로 사용하지 않더라도 자동적으로 사용가능2
	@Bean
	PasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
		
		http.authorizeHttpRequests()
			.antMatchers("/js/**","/css/**").permitAll()
			.antMatchers("/**").authenticated()
			.and()
			.formLogin()
			.loginPage("/loginForm").loginProcessingUrl("/login")
			.usernameParameter("username").passwordParameter("password")
			.defaultSuccessUrl("/rooms", true)
			.permitAll();
		
		return http.build();
	}
}
