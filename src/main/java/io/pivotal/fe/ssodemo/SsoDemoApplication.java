package io.pivotal.fe.ssodemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import java.security.Principal;


@SpringBootApplication
@EnableOAuth2Sso
@RestController
public class SsoDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SsoDemoApplication.class, args);
    }


    @GetMapping("/")
    public Principal whoAmI(Principal principal) {
        return principal;
    }

    static {
        HostnameVerifier allHostsValid = (name, sslSession) -> true;
        HttpsURLConnection.setDefaultHostnameVerifier(allHostsValid);
    }

}
