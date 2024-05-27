package co.develhope.UnitTest;

import co.develhope.UnitTest.entities.User;
import co.develhope.UnitTest.repositories.UserRepository;
import co.develhope.UnitTest.services.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @Test
    public void testGetUserById() {
        Long userId = 1L;
        User mockUser = new User();
        mockUser.setId(userId);
        when(userRepository.findById(userId)).thenReturn(Optional.of(mockUser));

        User result = userService.getUserById(userId);

        assertNotNull(result);
        assertEquals(userId, result.getId());
    }

    @Test
    public void testCreateUser_NewUser_CreatesUser() {
        User newUser = new User();
        newUser.setUsername("testUser");
        when(userRepository.findByUsername(newUser.getUsername())).thenReturn(null);
        when(userRepository.save(newUser)).thenReturn(newUser);

        User result = userService.createUser(newUser);

        assertNotNull(result);
        assertEquals(newUser.getUsername(), result.getUsername());
    }

    @Test
    public void testUpdateUser_ExistingUser_ReturnsUpdatedUser() {
        Long userId = 1L;
        User existingUser = new User();
        existingUser.setId(userId);
        existingUser.setUsername("existingUser");

        User updatedUser = new User();
        updatedUser.setId(userId);
        updatedUser.setUsername("updatedUser");

        when(userRepository.findById(userId)).thenReturn(Optional.of(existingUser));
        when(userRepository.saveAndFlush(existingUser)).thenReturn(updatedUser);

        User result = userService.updateUser(updatedUser, userId);

        assertNotNull(result);
        assertEquals(updatedUser.getUsername(), result.getUsername());
    }


    @Test
    public void testDeleteUserById_ExistingId_DeletesUser() {
        Long userId = 1L;
        User existingUser = new User();
        existingUser.setId(userId);

        when(userRepository.findById(userId)).thenReturn(Optional.of(existingUser));

        userService.deleteUserById(userId);

        verify(userRepository).deleteById(userId);
    }
}
