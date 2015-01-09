package br.com.tairoroberto.renascercarnes;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.BaseExpandableListAdapter;
import android.widget.DatePicker;
import android.widget.ExpandableListView;
import android.widget.TextView;

import java.util.Calendar;
import java.util.Locale;

public class Lojas extends Activity {

	ExpandableListView listaLojas;
	BaseExpandableListAdapter adapter;
	static TextView txtdt1;
	static TextView txtdt2;
	
	private static final int VER_RELATORIO = Menu.FIRST;
	private static final int SAIR = Menu.FIRST + 2;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.lojas);

		/************************************************************************************/
		/**			 				Inicialização dos componentes						   */
		/*************************** ******************************************************/
		listaLojas = (ExpandableListView) findViewById(R.id.expList_lojas);
		adapter = new AdapterLojas(this);
		txtdt1 = (TextView) findViewById(R.id.txtdt1);
		txtdt2 = (TextView) findViewById(R.id.txtdt2);

        //verifica de tem uma instancia de onsaveInstaneState
        if (savedInstanceState != null){
            txtdt1.setText(savedInstanceState.getString("dataSexta"));
            txtdt2.setText(savedInstanceState.getString("dataSegunda"));
        }

		listaLojas.setAdapter(adapter);
		
		/************************************************************************************/
		/**	 				Método chamado quando é clicado para selecionar data  		   */
		/*************************** ******************************************************/

		txtdt1.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				DialogFragment newFragment = new PegaDataSexta();
				newFragment.show(getFragmentManager(), "Escolha data Sexta");

			}
		});

		txtdt2.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				DialogFragment newFragment1 = new PegaDataSegunda();
				newFragment1.show(getFragmentManager(), "Escolha data Segunda");

			}
		});

		/************************************************************************************/
		/**	 				Método chamado quando é clicado na loja selecionada	  		   */
		/*************************** ******************************************************/
		listaLojas
				.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {

					@Override
					public boolean onChildClick(ExpandableListView parent,
							View v, int groupPosition, int childPosition,
							long id) {

						String loja = adapter.getChild(groupPosition,
								childPosition).toString();
						String d1 = txtdt1.getText().toString();
						String d2 = txtdt2.getText().toString();
						
						Intent intent = new Intent(Lojas.this, Estoque.class);
						intent.putExtra("lojaSelecionada", loja);
						intent.putExtra("dataSexta", d1);
						intent.putExtra("dataSegunda", d2);

						Lojas.this.startActivity(intent);

						return false;
					}
				});

	}

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("dataSexta",txtdt1.getText().toString());
        outState.putString("dataSegunda",txtdt2.getText().toString());
    }


    /**********************************************************************************/
	/**						Método chamado para criar o MENU						 */
	/********************************************************************************/
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		menu.add(0, VER_RELATORIO, 0, "Ver relatório");
		menu.add(0, SAIR, 0, "Sair");

		getMenuInflater().inflate(R.menu.login, menu);
		return true;
	}
	
	
	/**********************************************************************************/
	/**				Método chamado quando é selecionado algum item no MENU			 */
	/********************************************************************************/
	public boolean onOptionsItemSelected(MenuItem item) {

		switch (item.getItemId()) {
		case VER_RELATORIO:

		/***************************************************************/
		/**  Ver relatório de pedido que está no Site
		*************************************************************/
			Intent intentMostraSite = new Intent();
			intentMostraSite.setClass(this,MostrarSite.class);
			startActivity(intentMostraSite);
			break;
		case SAIR:
			// SAir da aplicação
			this.finish();
			break;
		}
		return super.onContextItemSelected(item);
	}
	
	/*****************************************************************************/
	/**			Classe para disparar mensagem de de Data na Tela				*/
	/***************************************************************************/ 

	public static class PegaDataSexta extends DialogFragment implements
			DatePickerDialog.OnDateSetListener {

		@Override
		public Dialog onCreateDialog(Bundle savedInstanceState) {
			// Use the current date as the default date in the picker
			final Calendar c = Calendar.getInstance(new Locale("pt", "BR"));

			int year = c.get(Calendar.YEAR);
			int month = c.get(Calendar.MONTH);
			int day = c.get(Calendar.DAY_OF_MONTH);

			// Create a new instance of DatePickerDialog and return it
			return new DatePickerDialog(getActivity(), this, year, month, day);
		}

		public void onDateSet(DatePicker view, int year, int month, int day) {

			// set selected date into textview
			txtdt1.setText(new StringBuilder().append(day)
					.append("/").append(month + 1).append("/").append(year));

		}
	}

	public static class PegaDataSegunda extends DialogFragment implements
			DatePickerDialog.OnDateSetListener {

		@Override
		public Dialog onCreateDialog(Bundle savedInstanceState) {
			// Use the current date as the default date in the picker
			final Calendar c = Calendar.getInstance();
			
			int year = c.get(Calendar.YEAR);
			int month = c.get(Calendar.MONTH);
			int day = c.get(Calendar.DAY_OF_MONTH);

			// Create a new instance of DatePickerDialog and return it
			return new DatePickerDialog(getActivity(), this, year, month, day);
		}

		public void onDateSet(DatePicker view, int year, int month, int day) {

			// set selected date into textview
			txtdt2.setText(new StringBuilder().append(day)
					.append("/").append(month + 1).append("/").append(year));
			
		}
	}
}
