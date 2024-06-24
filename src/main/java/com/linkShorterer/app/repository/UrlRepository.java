package com.linkShorterer.app.repository;

import com.linkShorterer.app.model.UrlMapping;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UrlRepository extends JpaRepository <UrlMapping, Long> {

    Optional<UrlMapping> findById (Long id);
    Optional<UrlMapping> findByOriginalUrl(String originalUrl);
    Optional<UrlMapping> findByShorteredUrl(String shorteredUrl);
}
