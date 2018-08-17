package hello;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

     //security configuration that ensures that only authenticated users can see the secret greeting:
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        /*
        * method defines which URL paths should be secured and which should not.
        * Specifically, the "/" and "/home" paths are configured to not require any authentication.
        * All other paths must be authenticated.
        * */
        http
            .authorizeRequests()
                .antMatchers("/", "/home").permitAll()
                .anyRequest().authenticated()
                .and()

            .formLogin()
                .loginPage("/login")
                .permitAll()
                .and()

            .logout()
                .permitAll();
    }

    @Bean
    @Override
    public UserDetailsService userDetailsService() {

        //sets up an in-memory user store with a single user. That user is given a username of "user",
        //a password of "password", and a role of "USER".
        UserDetails user =
             User.withDefaultPasswordEncoder()
                .username("user")
                .password("password")
                .roles("USER")
                .build();

        return new InMemoryUserDetailsManager(user);
    }
}