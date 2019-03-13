package ru.gb.vtitov.materialdesign;

import android.os.Bundle;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.Button;

public class WelcomeActivity extends AppCompatActivity {

	TextInputLayout nameInputLayout;
	TextInputLayout emailInputLayout;
	TextInputEditText nameEditText;
	TextInputEditText emailEditText;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setTheme(R.style.Theme_App);
		setContentView(R.layout.activity_welcome);
		Toolbar toolbar = findViewById(R.id.toolbar);
		setSupportActionBar(toolbar);

		FloatingActionButton fab = findViewById(R.id.fab);
		fab.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
								.setAction("Action", null).show();
			}
		});
		defineUIElements();
	}

	private void defineUIElements() {
		nameInputLayout = findViewById(R.id.name_text_input);
		nameEditText = findViewById(R.id.name_text_edit);
		emailInputLayout = findViewById(R.id.email_text_input);
		emailEditText = findViewById(R.id.email_text_edit);
		Button acceptButton = findViewById(R.id.accept_button);
		acceptButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				onTapAccept();
			}
		});

	}

	private void onTapAccept() {
		if(nameEditText.getText().toString().isEmpty()) {
			nameInputLayout.setError("Name field could not be empty");
			shakeIt(nameInputLayout);
			return;
		} else {
			nameInputLayout.setError("");
		}
		if(emailEditText.getText().toString().isEmpty()) {
			emailInputLayout.setError("Email field could not be empty");
			shakeIt(emailInputLayout);
			return;
		} else {
			emailInputLayout.setError("");
		}
	}

	private void shakeIt(View view) {
		final long duration = 100;
		YoYo.with(Techniques.Shake)
						.delay(duration)
						.playOn(view);
		Snackbar.make(view,
						"Please complete all fields",
						Snackbar.LENGTH_LONG)
						.setAction("Action", null).show();
		view.requestFocus();
	}

}
