package servise;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author MarkChern
 */
class StatusTest
{
    @Test
    void testStatus()
    {
        assertEquals("FREE", Status.FREE.name());
        assertEquals("BUSY", Status.BUSY.name());
        assertEquals("VOCATION", Status.VOCATION.name());
    }
}