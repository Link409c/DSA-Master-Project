package ManualIteratorSlotMachine;

import java.util.Iterator;
import java.util.Random;

public class ChristianSlotMachine<T> implements Iterable<T> {

	private int coins;

	@Override
	public Iterator<T> iterator() {
		return null;
	}
	
	public ChristianSlotMachine() {}
	
	public ChristianSlotMachine(int aCoins) {
		coins = aCoins;
	}
	
	public void setCoins(int aCoins) {
		coins = aCoins;
	}
	
	public int getCoins() {
		return coins;
	}

	//move to the next object in the list aka spin / pull

	public void add(){
		//add 2 coins if the result of pull is win
		setCoins(getCoins()+2);
	}


	public void pull(){
		//random object to use for calculations
		Random r = new Random();
		//win flag
		boolean didIWin = false;
		//probability to win is 25%
		//randomly generate a number between 1 and 4, the result must be 4 to win
		int randomNumber =  r.nextInt(1, 5);
		if(randomNumber == 4){
			didIWin = true;
		}
		if(didIWin){
			//if you win, you get 2 coins
			add();
			System.out.println("You won! +2 Coins.");
		}
		else{
			//remove();
			System.out.println("You lose! -1 Coin.");
		}
	}

	public void run(){
		//next();
	}


}
