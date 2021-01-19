package domain.equipment;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author MarkChern
 */
class NoteBookTest
{
    NoteBook noteBook = new NoteBook("联想Y5", 6000.0);

    @Test
    void testNoteBookConstructor()
    {
        assertEquals("联想Y5", noteBook.getModel());
        assertEquals(6000.0, noteBook.getPrice());
    }

    @Test
    void testGetDescription()
    {
        assertEquals("NoteBook{model=联想Y5, price=6000.0}", noteBook.getDescription());
    }
}