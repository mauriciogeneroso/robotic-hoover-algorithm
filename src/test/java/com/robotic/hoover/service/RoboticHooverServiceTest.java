package com.robotic.hoover.service;

import com.robotic.hoover.model.Input;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.jdbc.core.JdbcTemplate;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

/**
 * @author Mauricio Generoso
 */
@ExtendWith(MockitoExtension.class)
public class RoboticHooverServiceTest {

    @Mock
    private JdbcTemplate jdbcTemplate;

    @InjectMocks
    private RoboticHooverService service;

    @Test
    public void verifyIfPersistOnDatabase() {
        // Arrange
        var input = new Input();
        input.setRoomSize(new int[]{1, 1});
        input.setCoords(new int[]{0, 0});

        doNothing().when(jdbcTemplate).execute(anyString());

        // Act
        service.cleanRoom(input);

        // Assert
        verify(jdbcTemplate, times(1)).execute(anyString());
    }
}
