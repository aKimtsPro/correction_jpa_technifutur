package bstorm.akimts.correction_jpa.controllers;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import javax.servlet.http.HttpServlet;
import java.util.Map;

@RestController
@RequestMapping("/demo")
public class DemoController {

    @GetMapping("/headers")
    public ResponseEntity<?> getHeaders(@RequestHeader HttpHeaders headers){
        headers.forEach((key, value) -> {
            System.out.println(key + " : " + value.get(0) );
        });

//        String host = headers.get("host").get(0);

        return ResponseEntity.ok().build();
    }

    @GetMapping("/header")
    public ResponseEntity<?> getHeader(@RequestHeader(HttpHeaders.HOST) String host){
        System.out.println( host );

        return ResponseEntity.ok().build();
    }

    @GetMapping("/params")
    public ResponseEntity<?> getParams(@RequestParam MultiValueMap<String, String> params){

        params.forEach((key, value) -> {
            System.out.print(key + " : ");
            value.forEach((v) -> System.out.print(v + ", "));
        });

        return ResponseEntity.ok().build();

    }

    @GetMapping("/param")
    public ResponseEntity<?> getParam( @RequestParam(required = false) Integer size ){
        System.out.println("size : " + size);

        return ResponseEntity.ok().build();
    }

    @GetMapping("/for-all")
    @PreAuthorize("permitAll()")
    public String getForAll(){
        return "pour tous";
    }

    @GetMapping("/for-connected")
    @PreAuthorize("isAuthenticated()")
    public String getForConnected(Authentication auth){
        System.out.println(auth);
        return "pour connected";
    }

    @GetMapping("/for-user")
//    @Secured("ROLE_USER")
    @RolesAllowed("ROLE_USER")
    public String getForRoleUser(){
        return "pour les roles USER";
    }

    @GetMapping("/for-admin")
    @Secured("ROLE_ADMIN")
//    @RolesAllowed("ROLE_ADMIN")
    public String getForAdmin(){
        return "pour role ADMIN";
    }

}
