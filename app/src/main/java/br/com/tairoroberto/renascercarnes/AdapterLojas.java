package br.com.tairoroberto.renascercarnes;

import android.app.Activity;
import android.graphics.Typeface;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;


public class AdapterLojas extends BaseExpandableListAdapter {

	/************************************************************************************
	*	 					Array com os supervisores do grupo renasce					*
	*************************** ********************************************************/
	public String[] supervisor = new String[] { "Robson", "Alexandre", "Amario" };


	/************************************************************************************
	*	 					Array com as lojas do grupo renascer						*
	*************************** ********************************************************/

	public String[][] lojasRenascer = new String[][] {
			{ "Boi do Povo", "Cocaia", "Conceição", 
			  "Limão", "Santana","Tatuapé", "Vila Maria" }, // Lojas Robson
			{ "Maria Marcolina", "Pari", "Sapopemba" },// Lojas Alexandre
			{ "Belém", "Brás", "Celso Garcia" } };// Lojas Amario

	private Activity activity;
	public AdapterLojas(Activity activity) {
		this.activity = activity;
	}

	@Override
	public Object getChild(int groupPosition, int childPosition) {

		return lojasRenascer[groupPosition][childPosition];
	}

	
	/************************************************************************************/
	/**	 					retorna o id da loja selecionada						   */
	/*************************** ******************************************************/
	@Override
	public long getChildId(int groupPosition, int childPosition) {
		return childPosition;
	}

	@Override
	public View getChildView(int groupPosition, int childPosition,
			boolean arg2, View arg3, ViewGroup arg4) {
		TextView texto = new TextView(this.activity);
		texto.setText(lojasRenascer[groupPosition][childPosition]);
		texto.setPadding(80, 10, 0, 0);
		texto.setTextSize(26);
		return texto; // retorna o nome da loja
	}

	@Override
	public int getChildrenCount(int groupPosition) {
		return lojasRenascer[groupPosition].length;// retorna a quantidade de
													// lojas
	}

	@Override
	public Object getGroup(int groupPosition) {
		return supervisor[groupPosition];// retorna a posição do supervisor
	}

	@Override
	public int getGroupCount() {
		return supervisor.length; // retorna a quantidade de supervisores
	}

	@Override
	public long getGroupId(int groupPosition) {
		return groupPosition; // retorna a posição do supervisor
	}

	@Override
	public View getGroupView(int groupPosition, boolean arg1, View arg2,
			ViewGroup arg3) {
		TextView texto = new TextView(this.activity);
		texto.setText(supervisor[groupPosition]);
		texto.setPadding(60, 20, 0, 0);
		texto.setTextSize(28);
		texto.setTypeface(Typeface.DEFAULT, Typeface.BOLD);

		return texto; // retorna o nome do supervisor
	}

	@Override
	public boolean hasStableIds() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isChildSelectable(int arg0, int arg1) {

		return true;
	}

}
