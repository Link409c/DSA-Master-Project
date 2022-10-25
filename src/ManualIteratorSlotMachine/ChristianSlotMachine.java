package ManualIteratorSlotMachine;


public class ChristianSlotMachine implements ChristianIterator<E> {

	private int coins;
	
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
	@Override
	public void next() {
		//counter for pulls
		int pullCounter = 0;
		//if you have coins (hasnext)
		while(hasNext()){
			//spin the slot machine
			pull();
			pullCounter++;
		}
		System.out.println("You are out of coins! You played " + pullCounter + " times.");
	}

	@Override
	public void remove() {
		//remove a coin if result of pull is loss
		setCoins(getCoins()-1);
	}

	public void add(){
		//add 2 coins if the result of pull is win
		setCoins(getCoins()+2);
	}

	@Override
	public boolean hasNext() {
		if(getCoins() > 0) {
			return true;
		}else {
			return false;
		}
	}

	public boolean pull(){
		//win flag
		boolean didIWin = false;
		//probability to win is 25%
		//randomly generate a number between 1 and 4, the result must be 4 to win
		didIWin = random.nextInt(1, 4);
		if(didIWin){
			//if you win, you get 2 coins
			add();
			System.out.println("You won! +2 Coins.");
		}
		else{
			remove();
			System.out.println("You lose! -1 Coin.");
		}
		return didIWin;
	}

}
