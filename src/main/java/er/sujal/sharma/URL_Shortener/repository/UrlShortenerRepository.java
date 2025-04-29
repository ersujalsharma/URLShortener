package er.sujal.sharma.URL_Shortener.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import er.sujal.sharma.URL_Shortener.entity.UrlStore;

public interface UrlShortenerRepository extends JpaRepository<UrlStore, Long> {
	Optional<UrlStore> findBylongurl(String name);
}
