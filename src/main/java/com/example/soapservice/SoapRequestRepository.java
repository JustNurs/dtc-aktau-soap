package com.example.soapservice;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SoapRequestRepository extends JpaRepository<SoapRequest, Long> {
}
