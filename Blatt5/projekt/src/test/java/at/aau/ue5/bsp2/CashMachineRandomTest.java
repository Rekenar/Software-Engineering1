package at.aau.ue5.bsp2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class CashMachineRandomTest {

    CashMachine cashMachine;

    @BeforeEach
    public void before(){
        cashMachine = new CashMachine();
    }

    //Minimale-Aufruf-Sequenz: Start - Card_Retained
    @ParameterizedTest
    @CsvSource({ "10342","54642"})
    public void Should_ChangeStateToCardRetained_WhenCardEndsWithFourTwo(String stringInput1) {
        cashMachine.insertCard(stringInput1);
        Assertions.assertEquals(CashMachineState.CARD_RETAINED, cashMachine.getCurrentState());
    }

    //Aufruf-Sequenz: Start - Card_Valid - Pin_Not_OK - Pin_Not_OK - Card_Retained
    @ParameterizedTest
    @CsvSource({ "10341","54643" })
    public void Should_ChangeStateToCardRetained_AfterTwoTimesPinNotOk(String stringInput1) {
        cashMachine.insertCard(stringInput1);
        Assertions.assertEquals(CashMachineState.CARD_INSERTED, cashMachine.getCurrentState());
        cashMachine.inputPIN(stringInput1);
        Assertions.assertEquals(CashMachineState.PIN_NOT_OK,cashMachine.getCurrentState());
        cashMachine.inputPIN(stringInput1);
        Assertions.assertEquals(CashMachineState.PIN_NOT_OK,cashMachine.getCurrentState());
        cashMachine.inputPIN(stringInput1);
        Assertions.assertEquals(CashMachineState.CARD_RETAINED,cashMachine.getCurrentState());
    }


    //Aufruf-Sequenz: Start - Card_Valid - Pin_Not_OK - Pin_OK - Amount_Valid - Cash-Given - Card - Taken
    @ParameterizedTest
    @CsvSource({ "10321, 1234, 50","54651,1234, 60" })
    public void Should_ChangeStateToCardTaken_AfterTwoTimesPinNotOk(String stringInput1,String stringInput2, int intInput){
        cashMachine.insertCard(stringInput1);
        Assertions.assertEquals(CashMachineState.CARD_INSERTED,cashMachine.getCurrentState());
        cashMachine.inputPIN(stringInput1);
        Assertions.assertEquals(CashMachineState.PIN_NOT_OK,cashMachine.getCurrentState());
        cashMachine.inputPIN(stringInput2);
        Assertions.assertEquals(CashMachineState.PIN_OK,cashMachine.getCurrentState());
        cashMachine.selectAmount(intInput);
        Assertions.assertEquals(CashMachineState.AMOUNT_VALID,cashMachine.getCurrentState());
        cashMachine.takeCash();
        Assertions.assertEquals(CashMachineState.CASH_GIVEN,cashMachine.getCurrentState());
        cashMachine.removeCard();
        Assertions.assertEquals(CashMachineState.CARD_TAKEN,cashMachine.getCurrentState());
    }

    //Aufruf-Sequenz: Start - Card_Valid - Amount_Not_Valid - Amount_Not_Valid - Amount_Valid - Cash-Given - Card - Taken
    @ParameterizedTest
    @CsvSource({ "10321, 1234, 50, 21","54651,1234, 60, 22" })
    public void Should_ChangeStateToCardTaken_AfterTwoTimesAmountNotOk(String stringInput1,String stringInput2, int intInput1, int intInput2){
        cashMachine.insertCard(stringInput1);
        Assertions.assertEquals(CashMachineState.CARD_INSERTED,cashMachine.getCurrentState());
        cashMachine.inputPIN(stringInput2);
        Assertions.assertEquals(CashMachineState.PIN_OK,cashMachine.getCurrentState());
        cashMachine.selectAmount(intInput2);
        Assertions.assertEquals(CashMachineState.AMOUNT_NOT_VALID,cashMachine.getCurrentState());
        cashMachine.selectAmount(intInput2);
        Assertions.assertEquals(CashMachineState.AMOUNT_NOT_VALID,cashMachine.getCurrentState());
        cashMachine.selectAmount(intInput1);
        Assertions.assertEquals(CashMachineState.AMOUNT_VALID,cashMachine.getCurrentState());
        cashMachine.takeCash();
        Assertions.assertEquals(CashMachineState.CASH_GIVEN,cashMachine.getCurrentState());
        cashMachine.removeCard();
        Assertions.assertEquals(CashMachineState.CARD_TAKEN,cashMachine.getCurrentState());
    }
    //Aufruf-Sequenz: Start - Card_Valid - Pin_Not_OK - Pin_OK - Amount_Not_Valid - Amount_Not_Valid - Amount_Valid - Cash-Given - Card - Taken
    @ParameterizedTest
    @CsvSource({ "10321, 1234, 50, 21","54651,1234, 60, 22" })
    public void Should_ChangeStateToCardTaken_AfterTwoTimesPinAndAmountNotOk(String stringInput1,String stringInput2, int intInput1, int intInput2){
        cashMachine.insertCard(stringInput1);
        Assertions.assertEquals(CashMachineState.CARD_INSERTED,cashMachine.getCurrentState());
        cashMachine.inputPIN(stringInput1);
        Assertions.assertEquals(CashMachineState.PIN_NOT_OK,cashMachine.getCurrentState());
        cashMachine.inputPIN(stringInput2);
        Assertions.assertEquals(CashMachineState.PIN_OK,cashMachine.getCurrentState());
        cashMachine.selectAmount(intInput2);
        Assertions.assertEquals(CashMachineState.AMOUNT_NOT_VALID,cashMachine.getCurrentState());
        cashMachine.selectAmount(intInput2);
        Assertions.assertEquals(CashMachineState.AMOUNT_NOT_VALID,cashMachine.getCurrentState());
        cashMachine.selectAmount(intInput1);
        Assertions.assertEquals(CashMachineState.AMOUNT_VALID,cashMachine.getCurrentState());
        cashMachine.takeCash();
        Assertions.assertEquals(CashMachineState.CASH_GIVEN,cashMachine.getCurrentState());
        cashMachine.removeCard();
        Assertions.assertEquals(CashMachineState.CARD_TAKEN,cashMachine.getCurrentState());
    }
}
