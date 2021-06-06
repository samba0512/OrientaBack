package com.samanecorp.orienta.controller;

import com.samanecorp.orienta.entities.Message;
import com.samanecorp.orienta.repos.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/orienta")
public class MessageController {

    @Autowired
    private MessageRepository messageRepository;

    /**
     * get all messages
     * @return
     */
    @GetMapping("/messages")
    public List<Message> getAllMessages() {
        return messageRepository.findAll();
    }

    /**
     * get message by Id
     * @param messageId
     * @return
     * @throws ResourceNotFoundException
     */
    @GetMapping("/messages/{id}")
    public ResponseEntity<Message> getMessageById(@PathVariable(value = "id") int messageId)
            throws ResourceNotFoundException {
        Message message = messageRepository.findById(messageId)
                .orElseThrow(() -> new ResourceNotFoundException("Message not found for this id :: " + messageId));
        return ResponseEntity.ok().body(message);
    }

    /**
     * Add un message
     * @param message
     * @return
     */
    @PostMapping("/messages")
    public Message createMessage(@Valid @RequestBody Message message) {
        return messageRepository.save(message);
    }

    /**
     * Update un message
     * @param messageId
     * @param MessageDetails
     * @return
     * @throws ResourceNotFoundException
     */
    @PutMapping("/messages/{id}")
    public ResponseEntity<Message> updateMessage(@PathVariable(value = "id") int messageId,
                                                     @Valid @RequestBody Message MessageDetails) throws ResourceNotFoundException {
        Message message = messageRepository.findById(messageId)
                .orElseThrow(() -> new ResourceNotFoundException("Message not found for this id :: " + messageId));

        final Message updatedMessage = messageRepository.saveAndFlush(MessageDetails);
        return ResponseEntity.ok(updatedMessage);
    }

    /**
     * Delete un message
     * @param messageId
     * @return
     * @throws ResourceNotFoundException
     */
    @DeleteMapping("/messages/{id}")
    public Map<String, Boolean> deleteMessage(@PathVariable(value = "id") int messageId)
            throws ResourceNotFoundException {
        Message message = messageRepository.findById(messageId)
                .orElseThrow(() -> new ResourceNotFoundException("Message not found for this id :: " + messageId));

        messageRepository.delete(message);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

    /**
     * get le nombre de messages
     * @return
     */
    //fonction qui recupere le nombres de messages
    @GetMapping("/messages/total")
    public int getNombresMessage() {
        return messageRepository.CountMessage();
    }
}
