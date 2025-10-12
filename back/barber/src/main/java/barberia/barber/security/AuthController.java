package barberia.barber.security;

import barberia.barber.entity.UsuarioEntity;
import barberia.barber.repository.UsuarioRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = {"http://localhost:4200", "http://localhost:8081"})
public class AuthController {

    private final UsuarioRepository ur;
    private final PasswordEncoder passwordEncoder;

    public AuthController(UsuarioRepository usuarioRepo, PasswordEncoder passwordEncoder) {

        this.ur = usuarioRepo;
        this.passwordEncoder = passwordEncoder;

    }

    @PostMapping("/login")
    public String login(@RequestBody LoginRequest request) {

        UsuarioEntity user = ur.findByUsername(request.username);

        if (user == null) throw new RuntimeException("Usuario no encontrado");

        if (!passwordEncoder.matches(request.password, user.getPassword()))

            throw new RuntimeException("Contraseña incorrecta");

        return JwtUtils.generarToken(user.getUsername());

    }

}
