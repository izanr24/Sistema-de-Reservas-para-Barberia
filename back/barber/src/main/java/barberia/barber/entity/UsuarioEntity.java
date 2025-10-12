package barberia.barber.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "usuarios")
public class UsuarioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    private String rol;

    // Constructor vacío
    public UsuarioEntity() {}

    // Constructor completo
    public UsuarioEntity(String username, String password) {

        this.username = username;
        this.password = password;

    }

    public Integer getId() {

        return id;

    }

    public void setId(Integer id) {

        this.id = id;

    }

    public String getUsername() {

        return username;

    }

    public void setUsername(String username) {

        this.username = username;

    }

    public String getPassword() {

        return password;

    }

    public void setPassword(String password) {

        this.password = password;

    }

    public String getRol() {   

        return rol;

    }

    public void setRol(String rol) { 

        this.rol = rol;

    }

}
