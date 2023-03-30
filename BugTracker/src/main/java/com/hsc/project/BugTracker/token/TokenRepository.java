package com.hsc.project.BugTracker.token;

import java.util.List;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;

public interface TokenRepository extends CrudRepository<Token, Integer> {

    
    List<Token> findAllValidTokenByUser(long l);

    Optional<Token> findByToken(String token);
}