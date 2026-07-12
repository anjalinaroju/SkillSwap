//package com.skillswap.backend.controller;
//
//public class ExchangeRequestController {
//
//}

package com.skillswap.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.skillswap.backend.entity.ExchangeRequest;
import com.skillswap.backend.service.ExchangeRequestService;

@RestController
@RequestMapping("/requests")
public class ExchangeRequestController {

    @Autowired
    private ExchangeRequestService exchangeRequestService;

    // Save Exchange Request
    @PostMapping
    public ExchangeRequest saveExchangeRequest(@RequestBody ExchangeRequest exchangeRequest) {
        return exchangeRequestService.saveExchangeRequest(exchangeRequest);
    }

    // Get All Exchange Requests
    @GetMapping
    public List<ExchangeRequest> getAllExchangeRequests() {
        return exchangeRequestService.getAllExchangeRequests();
    }

    // Get Exchange Request By ID
    @GetMapping("/{id}")
    public ExchangeRequest getExchangeRequestById(@PathVariable Long id) {
        return exchangeRequestService.getExchangeRequestById(id);
    }

    // Update Exchange Request
    @PutMapping("/{id}")
    public ExchangeRequest updateExchangeRequest(@PathVariable Long id,
                                                 @RequestBody ExchangeRequest exchangeRequest) {
        return exchangeRequestService.updateExchangeRequest(id, exchangeRequest);
    }

    // Delete Exchange Request
    @DeleteMapping("/{id}")
    public String deleteExchangeRequest(@PathVariable Long id) {
        return exchangeRequestService.deleteExchangeRequest(id);
    }
    
 // Accept Exchange Request
    @PutMapping("/{id}/accept")
    public ExchangeRequest acceptRequest(@PathVariable Long id) {
        return exchangeRequestService.acceptRequest(id);
    }

    // Reject Exchange Request
    @PutMapping("/{id}/reject")
    public ExchangeRequest rejectRequest(@PathVariable Long id) {
        return exchangeRequestService.rejectRequest(id);
    }
    
 // Get Requests Sent By User
    @GetMapping("/sender/{senderId}")
    public List<ExchangeRequest> getRequestsBySender(@PathVariable Long senderId) {
        return exchangeRequestService.getRequestsBySender(senderId);
    }

    // Get Requests Received By User
    @GetMapping("/receiver/{receiverId}")
    public List<ExchangeRequest> getRequestsByReceiver(@PathVariable Long receiverId) {
        return exchangeRequestService.getRequestsByReceiver(receiverId);
    }
}
