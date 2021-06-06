package com.samanecorp.orienta.repos;

import com.samanecorp.orienta.entities.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageRepository extends JpaRepository<Message, Integer> {

    //recupere le nombre de messages
    @Query("select count(id) from Message")
    public int CountMessage();
}
