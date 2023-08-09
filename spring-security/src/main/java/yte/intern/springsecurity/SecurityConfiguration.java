package yte.intern.springsecurity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.proxy.NoOp;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration   // bu tarz ayarlar bu anatasyon ile yapılır genelde
@EnableMethodSecurity
public class SecurityConfiguration {

    // it can work without @AutoWired
    @Autowired
    public SecurityConfiguration(AuthenticationManagerBuilder authenticationManagerBuilder,
                                 CustomUserDetailsService userDetailsService)
            throws Exception{  //customUserDetailsService

     /* //BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        UserDetails admin = User.builder()
                .username("admin")
                .password("123qwe") //  use just .password(passwordEncoder.encode("123qwe"))  if there is  BCrypt.
                .authorities("ROLE_ADMIN") // ROLE_SOMETHING
                .build();

        UserDetails user = User.builder()
                .username("user")
                .password("123qwe")
                .authorities("ROLE_USER") // ROLE_SOMETHING
                .build();

        authenticationManagerBuilder.inMemoryAuthentication()  //kullanıcılar memoryde tutulsun diye
                .withUser(user)
                .withUser(admin)
                .passwordEncoder(NoOpPasswordEncoder.getInstance()); // NoOp. does no encode passwords

        */

        authenticationManagerBuilder
                .userDetailsService(userDetailsService)
                .passwordEncoder(NoOpPasswordEncoder.getInstance());
    }

  /*  @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http.authorizeHttpRequests()
                .requestMatchers(AntPathRequestMatcher.antMatcher("/user")).hasAnyRole("USER", "ADMIN")
                .requestMatchers(AntPathRequestMatcher.antMatcher("/admin")).hasRole("ADMIN")
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .and()
                .build();
                //other matchers
    }*/
}
