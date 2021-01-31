package at.aau.ue5.bsp2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CashMachineStateTest {

    CashMachine cashMachine;

    @BeforeEach
    public void before(){
        cashMachine = new CashMachine();
    }

    /**
     * Exception
     */
    @Test
    public void Should_ThrowIllegalStateException_WhenNotInStartState(){
        cashMachine.insertCard("5215");
        Assertions.assertThrows(IllegalStateException.class, () -> cashMachine.insertCard("15846"));
    }
    @Test
    public void Should_ThrowIllegalStateException_WhenNotInCardInsertedState(){
        Assertions.assertThrows(IllegalStateException.class, () -> cashMachine.inputPIN("1234"));
    }
    @Test
    public void Should_ThrowIllegalStateException_WhenNotInPinNotOkState(){
        cashMachine.insertCard("5215");
        cashMachine.inputPIN("1234");
        Assertions.assertThrows(IllegalStateException.class, () -> cashMachine.inputPIN("1234"));
    }
    @Test
    public void Should_ThrowIllegalStateException_WhenNotInPinOkState(){
        cashMachine.insertCard("5215");
        Assertions.assertThrows(IllegalStateException.class, () -> cashMachine.selectAmount(500));
    }
    @Test
    public void Should_ThrowIllegalStateException_WhenNotInAmountNotValidState(){
        cashMachine.insertCard("5215");
        cashMachine.inputPIN("1523");
        Assertions.assertThrows(IllegalStateException.class, () -> cashMachine.selectAmount(500));
    }
    @Test
    public void Should_ThrowIllegalStateException_WhenNotInAmountValidState(){
        cashMachine.insertCard("5215");
        cashMachine.inputPIN("1234");
        cashMachine.selectAmount(199);
        Assertions.assertThrows(IllegalStateException.class, () -> cashMachine.takeCash());
    }
    @Test
    public void Should_ThrowIllegalStateException_WhenNotInCashGivenState(){
        cashMachine.insertCard("5215");
        cashMachine.inputPIN("1234");
        cashMachine.selectAmount(200);
        Assertions.assertThrows(IllegalStateException.class, () -> cashMachine.removeCard());
    }

}
