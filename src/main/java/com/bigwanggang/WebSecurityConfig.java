package com.bigwanggang;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/","/login").permitAll()//1鏍硅矾寰勫拰/login璺緞涓嶆嫤鎴?
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login") //2鐧婚檰椤甸潰
                .defaultSuccessUrl("/chat") //3鐧婚檰鎴愬姛杞悜璇ラ〉闈?
                .permitAll()
                .and()
                .logout()
                .permitAll();
    }

    //4
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    		auth
                .inMemoryAuthentication()
                .withUser("wyf").password("wyf").roles("USER")
                .and()
                .withUser("wisely").password("wisely").roles("USER");
    }
    //5蹇界暐闈欐?佽祫婧愮殑鎷︽埅
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/resources/static/**");
    }

}
