package barberia.barber;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import barberia.barber.repository.UsuarioRepository;
import barberia.barber.entity.UsuarioEntity;

@SpringBootApplication
public class BarberApplication {

    public static void main(String[] args) {
        SpringApplication.run(BarberApplication.class, args);
    }

	//	LA PRIMERA VEZ QUE INICIES EL BACK DESCOMENTA LA SIGUIENTE LÍNEA PARA CREAR AUTOMÁTICAMENTE AL USUARIO CON EL QUE VAS A INICIAR SESIÓN

	//  UNA VEZ YA ESTE EL USUARIO CREADO VUELVE A COMENTARLA O PUEDES BORRARLA

    /* @Bean
		CommandLineRunner crearUsuarioPropietario(UsuarioRepository ur) {

			return args -> {
				if (!ur.existsByUsername("propietario")) {
					UsuarioEntity propietario = new UsuarioEntity();
					propietario.setUsername("izan");
					propietario.setPassword(new BCryptPasswordEncoder().encode("izan")); // contraseña
					propietario.setRol("PROPIETARIO");
					ur.save(propietario);
					System.out.println("Usuario propietario creado automáticamente");
				}
			};
		}	

	*/
}
