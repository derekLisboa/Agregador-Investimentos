package com.java.agregadorinvestimentos.service;

import java.time.Instant;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import static org.mockito.ArgumentMatchers.any;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.doThrow;
import org.mockito.junit.jupiter.MockitoExtension;

import com.java.agregadorinvestimentos.controller.CreateUserDTO;
import com.java.agregadorinvestimentos.entity.User;
import com.java.agregadorinvestimentos.repository.UserRepository;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @Captor
    private ArgumentCaptor<User> userArgumentCaptor;

    @Nested
    class createUser {
        @Test
        @DisplayName("Should create a user with success")
        void shouldCreateAUserWithSuccess(){

            // Arrange
            var user = new User(
                UUID.randomUUID(),
                "username",
                "email@email.com",
                "password",
                Instant.now(),
                null
            );

            doReturn(user).when(userRepository).save(userArgumentCaptor.capture());
            var input = new CreateUserDTO("username", "email@email.com", "123");
            
            // Act
            var output = userService.createUser(input);
            
            // Assert

            assertNotNull(output);
            var userCaptured = userArgumentCaptor.getValue();

            assertEquals(input.username(), userCaptured.getUsername());
            assertEquals(input.email(), userCaptured.getEmail());
            assertEquals(input.password(), userCaptured.getPassword());
        }

        @Test
        @DisplayName("Should throw exception when error ocours")
        void shouldThrowExceptionWhenErrorOcours(){
            // Arrange
            
            doThrow(new RuntimeException()).when(userRepository).save(any());
            var input = new CreateUserDTO("username", "email@email.com", "123");
            
            // Act & Assert
            assertThrows(RuntimeException.class, () -> userService.createUser(input));

            
        }
    }
}