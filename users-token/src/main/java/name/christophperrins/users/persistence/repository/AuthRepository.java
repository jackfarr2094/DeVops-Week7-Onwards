package name.christophperrins.users.persistence.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import name.christophperrins.users.persistence.domain.AuthToken;

public interface AuthRepository extends JpaRepository<AuthToken, Long>{

	public Optional<AuthToken> findByBearerToken(String bearerToken);
	public List<AuthToken> findByUsername(String username);
}
