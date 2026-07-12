//package com.skillswap.backend.repository;
//
//public interface ExchangeRequestRepository {
//
//}

//package com.skillswap.backend.repository;
//
//import org.springframework.data.jpa.repository.JpaRepository;
//
//import com.skillswap.backend.entity.ExchangeRequest;
//
//public interface ExchangeRequestRepository extends JpaRepository<ExchangeRequest, Long> {
//
//}


package com.skillswap.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skillswap.backend.entity.ExchangeRequest;

public interface ExchangeRequestRepository extends JpaRepository<ExchangeRequest, Long> {

    List<ExchangeRequest> findBySenderId(Long senderId);

    List<ExchangeRequest> findByReceiverId(Long receiverId);

}