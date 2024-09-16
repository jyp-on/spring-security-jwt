package exam.jwt.demo;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/demo")
@RequiredArgsConstructor
public class DemoController {

    @GetMapping("/user")
    @PreAuthorize("hasRole('USER')") // USER 역할을 가진 사용자만 접근 가능
    public ResponseEntity<String> sayHello() {
        return ResponseEntity.ok("Hello from secured endpoint (User access)");
    }

    @GetMapping("/admin")
    @PreAuthorize("hasRole('ADMIN')") // ADMIN 역할을 가진 사용자만 접근 가능
    public ResponseEntity<String> adminOnly() {
        return ResponseEntity.ok("Hello from admin endpoint");
    }

    @GetMapping("/all")
    @PreAuthorize("hasAnyRole('USER', 'ADMIN')") // USER 또는 ADMIN 역할을 가진 사용자 접근 가능
    public ResponseEntity<String> allRoles() {
        return ResponseEntity.ok("Hello to all authenticated users");
    }
}
