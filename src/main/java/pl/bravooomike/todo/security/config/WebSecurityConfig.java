package pl.bravooomike.todo.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import pl.bravooomike.todo.security.userIdentity.UserAuthentificationProvider;
import pl.bravooomike.todo.security.userIdentity.UserDetailsService;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private UserDetailsService userDetailsService;
    private LogoutSuccessHandler logoutSuccessHandler;

    @Autowired
    public WebSecurityConfig(UserDetailsService userDetailsService, LogoutSuccessHandler logoutSuccessHandler) {
        this.userDetailsService = userDetailsService;
        this.logoutSuccessHandler = logoutSuccessHandler;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                // .antMatchers(HttpMethod.GET, "/rest/todo/auth/").permitAll()
                .antMatchers(HttpMethod.POST, "/rest/todo/auth/logout").permitAll()
//                .antMatchers(HttpMethod.PUT, "/rest/todo/:id").permitAll()
                .anyRequest().authenticated()
                .and()
                .httpBasic()
                .and()
                .exceptionHandling()
                .authenticationEntryPoint(new RestBasicAuthentificationEntryPoint())
                .and()
                .logout()
                .logoutUrl("/rest/todo/auth/logout")
                .logoutSuccessHandler(this.logoutSuccessHandler)
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.ALWAYS);
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(new UserAuthentificationProvider(userDetailsService));
    }
}
