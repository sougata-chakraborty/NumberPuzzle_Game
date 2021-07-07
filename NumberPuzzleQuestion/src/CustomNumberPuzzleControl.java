import java.awt.*;

class CustomNumberPuzzleControl extends NumberPuzzleControl {
	public int getWidth() {
		return 200;
	}
	public int getHeight() {
		return 250;
	}
	public int getXPosition() {
		return 200;
	}
	public int getYPosition() {
		return 200;
	}
	public String getTitle(){
		return "Number Puzzle";
	}
	public int getShuffleButtonFontSize() {
		return 12;
	}
	public int getNumbersFontSize() {
		return 12;
	}
	public Color getEmptyButtonColor() {
		return Color.WHITE;
	}
	public String getWinnerMessage() {
		return "Congrats, you have won!";
	}

	// The following three methods have to be written by the participants...

	public int handleButtonClicked(NumberPuzzleGame game){
		int emptyCellId = game.getEmptyCellId();
		Button buttonClicked = game.getButtonClicked();
		Button[] buttons = game.getButtons();
		
		//Your logic here
		boolean isValidButton = false;
		if(emptyCellId+1<=buttons.length-1) {
			if(buttons[emptyCellId+1].equals(buttonClicked))
				isValidButton = true;
		}
		if(emptyCellId-1>=0) {
			if(buttons[emptyCellId-1].equals(buttonClicked))
				isValidButton = true;
		}
		if(emptyCellId+4<=(buttons.length-1)) {
			if(buttons[emptyCellId+4].equals(buttonClicked))
				isValidButton = true;
		}
		if(emptyCellId-4>=0) {
			if(buttons[emptyCellId-4].equals(buttonClicked))
				isValidButton = true;
		}
		 
		if(isValidButton) {
			swapButton(buttons[emptyCellId],buttonClicked);
			for(int b=0; b<buttons.length;b++) {
				if(buttons[b].equals(buttonClicked)) {
					emptyCellId=b;
					break;
				}
			}
		}
		
		return emptyCellId;

	}
	public int[] getRandomNumbersForGrid() {
		int arr[] = new int[15];
		
		//Your logic here
		boolean exists;
		for(int i=0;i<15;) {
			exists = false;
			int a = getRandomNumber();
			a=a%15+1;
			for(int j=0;j<i;j++) {
				if(a==arr[j]) {
					exists = true;
					break;
				}
			}
			if(exists) {
				continue;
			}
			arr[i++]=a;
		}
		
		
		return arr;
	}
	public boolean checkForWinner(Button[] buttons)
	{
		boolean winner = true;
		
		// Your Logic here
		int arr[] = getIntegerArrayOfButtonIds(buttons);
		for(int i=0;i<15;i++) {
			if(arr[i]!=i+1) {
				winner = false;
				break;
			}
		}

		return winner;
	}
}