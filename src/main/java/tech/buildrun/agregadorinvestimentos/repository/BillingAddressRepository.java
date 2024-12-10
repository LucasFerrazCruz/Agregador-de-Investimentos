package tech.buildrun.agregadorinvestimentos.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import tech.buildrun.agregadorinvestimentos.entity.BillingAddress;

public interface BillingAddressRepository extends JpaRepository<BillingAddress, UUID>{

}
