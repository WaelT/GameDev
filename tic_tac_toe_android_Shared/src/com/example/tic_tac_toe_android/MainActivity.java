package com.example.tic_tac_toe_android;
//Commit Test
import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {

	/* Instance Variables */
	private int[][] winCombinations = new int[][] { { 0, 1, 2 }, { 3, 4, 5 },
			{ 6, 7, 8 }, // horizontal wins
			{ 0, 3, 6 }, { 1, 4, 7 }, { 2, 5, 8 }, // Vertical wins
			{ 0, 4, 8 }, { 2, 4, 6 } // diagonal wins
	};

	private String board[] = new String[9];
	private int count = 0;
	private String letter = "";
	private boolean win = false;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		for (int i = 0; i < board.length; i++)
			board[i] = "";
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

	public void onClickHandler(View v) {

	}

	public void OnClickListener() {

	}

	public void ButtonClicked(View view) {

		count++;

		/* Calculate whose turn it is */
		if (count % 2 == 0) {
			letter = "O";
		} else {
			letter = "X";
		}

		/* Write the letter to the button and deactivate it */
		Button pressedButton = ((Button) view);
		pressedButton.setText(letter);
		pressedButton.setEnabled(false);
		int id = Integer.parseInt((String) pressedButton.getHint());
		board[id - 1] = letter;

		/* Determine who won */
		for (int i = 0; i <= 7; i++) {
			if (board[winCombinations[i][0]]
					.equals(board[winCombinations[i][1]])
					&& board[winCombinations[i][1]]
							.equals(board[winCombinations[i][2]])
					&& board[winCombinations[i][0]] != "") {
				win = true;
			}
		}

		/* Show a dialog when game is over */
		if (win == true) {
			new AlertDialog.Builder(this).setTitle("Info")
					.setMessage(letter + " wins the game!")
					.setNeutralButton("Okey", null).show();
			//System.exit(0);
		} else if (count == 9 && win == false) {
			new AlertDialog.Builder(this).setTitle("Info")
					.setMessage("The game was tie!")
					.setNeutralButton("Okey", null).show();
			//System.exit(0);
		}

	}

}
