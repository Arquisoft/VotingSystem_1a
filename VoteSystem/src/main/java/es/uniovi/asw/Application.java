package es.uniovi.asw;


import javax.faces.webapp.FacesServlet;
import javax.servlet.ServletContext;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.ServletRegistrationBean;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.context.ServletContextAware;

@SpringBootApplication
@EnableJpaRepositories
@ComponentScan
@Configuration
@EnableTransactionManagement
@EnableAutoConfiguration
public class Application extends SpringBootServletInitializer implements ServletContextAware {

    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }
        

    @Override
    public void setServletContext(ServletContext servletContext) {
        servletContext.setInitParameter("com.sun.faces.forceLoadConfiguration", Boolean.TRUE.toString());
        servletContext.setInitParameter("primefaces.CLIENT_SIDE_VALIDATION", "true");
        servletContext.setInitParameter("javax.faces.PROJECT_STAGE", "Development");
        
    }


    @Bean
    public ServletRegistrationBean servletRegistrationBean(ApplicationContext context) {
        ServletRegistrationBean jsfServlet = new ServletRegistrationBean(new FacesServlet(), "*.xhtml");
        return jsfServlet;
    }
    /* 
    public class JsfServletRegistrationBean extends ServletRegistrationBean {

        public JsfServletRegistrationBean() {
            super();
        }

    
  @Bean
    public WebMvcConfigurerAdapter forwardToIndex(){
    	return new WebMvcConfigurerAdapter(){
    		@Override
    		public void addViewControllers(ViewControllerRegistry registry){
    			registry.addRedirectViewController("/", "/login.xhtml");			
    			//registry.addViewController("/").setViewName("redirect:/principal.xhtml");
    		}		
    	};
    }*/
    

}