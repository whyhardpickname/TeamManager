package domain.equipment;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author MarkChern
 */
class PrinterTest {
    Printer printer = new Printer("惠普m6", "5800");
    @Test
    void testPrinterConstructor() {
        assertEquals("惠普m6", printer.getType());
        assertEquals("5800", printer.getName());
    }
    @Test
    void getDescription() {
        assertEquals("Printer{type=惠普m6, name=5800}", printer.getDescription());
    }
}