package net.hassani.bankaccountservice.mappers;

import net.hassani.bankaccountservice.dtos.BankAccountDTO;
import net.hassani.bankaccountservice.entities.BankAccount;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface BankAccountMapper {
    BankAccountMapper INSTANCE = Mappers.getMapper(BankAccountMapper.class);

    BankAccountDTO toDto(BankAccount bankAccount);

    BankAccount toEntity(BankAccountDTO bankAccountDTO);

    List<BankAccountDTO> toDtoList(List<BankAccount> bankAccounts);

    List<BankAccount> toEntityList(List<BankAccountDTO> bankAccountDTOs);
}