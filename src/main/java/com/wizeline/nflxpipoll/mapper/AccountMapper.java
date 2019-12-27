package com.wizeline.nflxpipoll.mapper;

import com.wizeline.nflxpipoll.dto.AccountDto;
import com.wizeline.nflxpipoll.model.Account;
import com.wizeline.nflxpipoll.persistence.entity.AccountEntity;
import java.util.Collection;
import java.util.List;
import org.mapstruct.Mapper;

@Mapper(
    componentModel = "spring",
    uses = {})
public abstract class AccountMapper {

  public abstract Account toDto(AccountDto accountDto);

  public abstract AccountEntity toEntity(Account account);

  public abstract AccountEntity toEntity(AccountDto account);

  public abstract Account toModel(AccountEntity account);

  public abstract AccountDto toDto(Account account);

  public abstract AccountDto toDto(AccountEntity entity);

  public abstract List<Account> toModelList(Collection<AccountEntity> entities);

  public abstract List<AccountDto> fromEntityToDtoList(Collection<AccountEntity> entities);

  public abstract List<AccountDto> toDtoList(Collection<Account> models);
}
