package com.example.demo.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Model.Chat;

public interface ChatRepository  extends JpaRepository<Chat, Long> {

}
