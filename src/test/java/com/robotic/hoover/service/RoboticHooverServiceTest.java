package com.robotic.hoover.service;

import com.robotic.hoover.model.Input;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.jdbc.core.JdbcTemplate;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

/**
 * @author Mauricio Generoso
 */
public class RoboticHooverServiceTest {

    @Mock
    private JdbcTemplate jdbcTemplate;

    @InjectMocks
    private RoboticHooverService service;

    @Test
    public void verifyIfPersistOnDatabase() {
        // Arrange
        Input input = new Input();
        doNothing().when(jdbcTemplate).execute(anyString());

        // Act
        service.cleanRoom(input);

        // Assert
        verify(jdbcTemplate, times(1)).execute(anyString());
    }
}
