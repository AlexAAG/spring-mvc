package web.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import web.model.Permission;
import web.model.Role;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final UserDetailsService userDetailsService;

    //@Qualifier обозначает, какой из бинов внедряем
    @Autowired
    public SecurityConfig(@Qualifier("userDetailsServiceImpl") UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    //работаем с http клиентом, поэтому выбираем configure(http)
    //конфигурируем чтобы создавать наших кастомных пользователей
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //аунтификация - понимаем друг это или враг
        //авторизация - к каким страницам данный юзер имеет доступ
        http
                .csrf().disable()       //защита от csrf угрозы
                .authorizeRequests()
                .antMatchers("/").permitAll()   //в корень проекта имеют доступ все
                .antMatchers(HttpMethod.GET, "/api/**").hasAuthority(Permission.DEVELOPERS_READ.getPermission())
                .antMatchers(HttpMethod.POST, "/api/**").hasAuthority(Permission.DEVELOPERS_WRITE.getPermission())
                .antMatchers(HttpMethod.DELETE, "/api/**").hasAuthority(Permission.DEVELOPERS_WRITE.getPermission())
                .anyRequest().authenticated()   //каждый запрос должен быть аунтифицирован
                .and()
                .httpBasic();
    }

    //идет в UDSimpl и берет оттуда пользователя. Старая реализация
//    @Bean
//    @Override
//    protected UserDetailsService userDetailsService() {
//        return new InMemoryUserDetailsManager(
//                User.builder()                            //User SS!!!
//                    .username("admin")
//                    .password(passwordEncoder().encode("admin"))    //декодирует админ (будет как в бд)
//                    .authorities(Role.ADMIN.getAuthorities())
//                    .build(),
//                User.builder()                            //User SS!!!
//                        .username("user")
//                        .password(passwordEncoder().encode("user"))    //декодирует админ (будет как в бд)
//                        .authorities(Role.USER.getAuthorities())
//                        .build()
//                );
//    }


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(daoAuthenticationProvider());
    }

    @Bean
    protected PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


    //https://www.youtube.com/watch?v=7uxROJ1nduk 1:12:10
    @Bean
    protected DaoAuthenticationProvider daoAuthenticationProvider() {
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
        daoAuthenticationProvider.setUserDetailsService(userDetailsService);
        return daoAuthenticationProvider;
    }
}
