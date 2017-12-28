package br.com.rafa.estudo2.conf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailsService userDetailsService;

	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/home").permitAll()
		        .antMatchers("/home/**").permitAll()
				.antMatchers("/login").permitAll()
				.antMatchers("/user/**").permitAll()
//				.antMatchers(HttpMethod.POST, "/product/**").hasRole("ADMIN")
				.antMatchers("/product").permitAll()
				.antMatchers("/product/**").permitAll()   //.anyRequest().authenticated()
				.antMatchers("/category").permitAll()
				.antMatchers("/category/**").permitAll()
				.and().formLogin().loginPage("/login").defaultSuccessUrl("/home").and().logout().permitAll().and().exceptionHandling()
				.accessDeniedPage("/WEB-INF/views/errors/403.jsp");
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder());
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		// you can change
		web.ignoring().antMatchers("/resources/**");
	}
}
