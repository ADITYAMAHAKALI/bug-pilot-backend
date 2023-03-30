package com.hsc.project.BugTracker.security;

import org.springframework.data.relational.core.mapping.Embedded.Nullable;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClient;

public interface RegisteredClientRepository {
    @Nullable
    RegisteredClient findById(String id);
    @Nullable
    RegisteredClient findByClientId(String clientId);
}
