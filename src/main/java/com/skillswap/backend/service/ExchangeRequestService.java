package com.skillswap.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skillswap.backend.entity.ExchangeRequest;
import com.skillswap.backend.repository.ExchangeRequestRepository;

@Service
public class ExchangeRequestService {

    @Autowired
    private ExchangeRequestRepository exchangeRequestRepository;

    // Save Exchange Request
    public ExchangeRequest saveExchangeRequest(ExchangeRequest exchangeRequest) {
        return exchangeRequestRepository.save(exchangeRequest);
    }

    // Get All Exchange Requests
    public List<ExchangeRequest> getAllExchangeRequests() {
        return exchangeRequestRepository.findAll();
    }

    // Get Exchange Request By ID
    public ExchangeRequest getExchangeRequestById(Long id) {
        return exchangeRequestRepository.findById(id).orElse(null);
    }

    // Update Exchange Request
    public ExchangeRequest updateExchangeRequest(Long id, ExchangeRequest updatedRequest) {

        ExchangeRequest request = exchangeRequestRepository.findById(id).orElse(null);

        if (request != null) {
            request.setSender(updatedRequest.getSender());
            request.setReceiver(updatedRequest.getReceiver());
            request.setSkill(updatedRequest.getSkill());
            request.setStatus(updatedRequest.getStatus());

            return exchangeRequestRepository.save(request);
        }

        return null;
    }

    // Delete Exchange Request
    public String deleteExchangeRequest(Long id) {

        if (exchangeRequestRepository.existsById(id)) {
            exchangeRequestRepository.deleteById(id);
            return "Exchange Request Deleted Successfully!";
        }

        return "Exchange Request Not Found!";
    }

    // Accept Exchange Request
    public ExchangeRequest acceptRequest(Long id) {

        ExchangeRequest request = exchangeRequestRepository.findById(id).orElse(null);

        if (request != null) {
            request.setStatus("ACCEPTED");
            return exchangeRequestRepository.save(request);
        }

        return null;
    }

    // Reject Exchange Request
    public ExchangeRequest rejectRequest(Long id) {

        ExchangeRequest request = exchangeRequestRepository.findById(id).orElse(null);

        if (request != null) {
            request.setStatus("REJECTED");
            return exchangeRequestRepository.save(request);
        }

        return null;
    }
    
 // Get Requests Sent By User
    public List<ExchangeRequest> getRequestsBySender(Long senderId) {
        return exchangeRequestRepository.findBySenderId(senderId);
    }

    // Get Requests Received By User
    public List<ExchangeRequest> getRequestsByReceiver(Long receiverId) {
        return exchangeRequestRepository.findByReceiverId(receiverId);
    }
}