package com.platform.match.repository;

import com.platform.match.domain.ClientVisitor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientVisitorRepository extends JpaRepository<ClientVisitor, Long> {
}