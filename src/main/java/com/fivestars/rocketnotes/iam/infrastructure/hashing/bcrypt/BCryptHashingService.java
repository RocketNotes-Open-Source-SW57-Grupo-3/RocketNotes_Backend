package com.fivestars.rocketnotes.iam.infrastructure.hashing.bcrypt;

import com.fivestars.rocketnotes.iam.application.internal.outboundservices.hashing.HashingService;
import org.springframework.security.crypto.password.PasswordEncoder;

public interface BCryptHashingService extends HashingService, PasswordEncoder {

}
