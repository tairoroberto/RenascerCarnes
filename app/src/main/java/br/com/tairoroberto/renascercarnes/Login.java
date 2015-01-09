package br.com.tairoroberto.renascercarnes;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Login extends Activity {

	private Button btnEntrar;
	private EditText edtLogin;
	private EditText edtSenha;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login);

		btnEntrar = (Button) findViewById(R.id.btnEntrar);
		edtLogin = (EditText) findViewById(R.id.edtLogin);
		edtSenha = (EditText) findViewById(R.id.edtSenha);

		btnEntrar.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {

				if (edtLogin.getText().toString().equals("")
						&& edtSenha.getText().toString().equals("")) {
					Intent intent = new Intent(Login.this, Lojas.class);
					Login.this.startActivity(intent);
					Login.this.finish();

				}

			}
		});

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.login, menu);
		return true;
	}
}
