package com.wizeline.nflxpipoll.persistence.repository;

import com.wizeline.nflxpipoll.persistence.entity.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<AccountEntity, Long> {}
