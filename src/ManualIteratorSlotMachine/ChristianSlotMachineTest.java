package ManualIteratorSlotMachine;

public class ChristianSlotMachineTest {

    public static void main(String[] args){

        //make a default slot machine

        ChristianSlotMachine slotMachineTest = new ChristianSlotMachine();

        //make a new slot machine

        ChristianSlotMachine slotMachineTest2 = new ChristianSlotMachine(50);

        //spin to win

        slotMachineTest.run();

        slotMachineTest2.run();

    }
}
