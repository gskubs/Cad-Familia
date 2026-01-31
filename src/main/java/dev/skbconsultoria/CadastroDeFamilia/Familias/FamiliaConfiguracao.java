package dev.skbconsultoria.CadastroDeFamilia.Familias;

import org.h2.server.web.JakartaWebServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FamiliaConfiguracao {

    @Bean
    public ServletRegistrationBean<JakartaWebServlet> h2ConsoleServletRegistration() {
        ServletRegistrationBean<JakartaWebServlet> registration =
                new ServletRegistrationBean<>(new JakartaWebServlet(), "/h2-console/*");

        // opcional: permite acesso de outras máquinas na rede
        // registration.addInitParameter("webAllowOthers", "true");

        // opcional: desabilita os banners
        // registration.addInitParameter("trace", "false");

        return registration;
    }
}
