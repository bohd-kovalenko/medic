package com.demo.warmedicapp.services.impl;

import com.demo.warmedicapp.repositories.CredentialsRepository;
import com.demo.warmedicapp.services.CredentialsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CredentialsServiceImpl implements CredentialsService {
    private final CredentialsRepository repository;

}
