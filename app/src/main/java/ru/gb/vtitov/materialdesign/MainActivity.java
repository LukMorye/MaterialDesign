package ru.gb.vtitov.materialdesign;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setTheme(R.style.Theme_App);
//		setTheme(R.style.Theme_App_Mint); // You can set other app theme
		setContentView(R.layout.activity_main);
	}
}
