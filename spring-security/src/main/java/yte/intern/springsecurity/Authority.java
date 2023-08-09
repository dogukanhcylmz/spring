package yte.intern.springsecurity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Authority implements GrantedAuthority {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToMany(mappedBy = "authorities")
    private Set<Users> userEntities;

    private String authority;
}
