package carlos.cardoso.gamification.entities;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Setter
@Getter
@Entity
@Table(name = "user_data")
@EqualsAndHashCode(of = "id")
public class User implements UserDetails {
    @EmbeddedId
    private UserId id;

    @NotBlank
    private String name;

    @NotNull
    private String socialName;

    @NotBlank
    @Size(min = 6)
    private String password;

    @NotBlank
    private String email;

    @OneToMany(mappedBy = "owner")
    private List<Quiz> quizzes = new ArrayList<>();

    public User() {
        this.id = new UserId();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }

    @Override
    public String getUsername() {
        return email;
    }
}
