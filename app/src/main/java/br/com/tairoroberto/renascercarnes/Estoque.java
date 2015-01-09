package br.com.tairoroberto.renascercarnes;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ExpandableListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Estoque extends Activity {

	private ExpandableListView expList;
	private static TextView txtDataPedidoSexta;
	private static TextView txtDataPedidoSegunda;

	/**********************************************************************************/
	/** 						 Variáveis do menu  								 */
	/********************************************************************************/
	private static final int EXPORTAR = Menu.FIRST;
	private static final int VER_RELATORIO = Menu.FIRST + 1;
	//private static final int ADICIONAR_FORNECEDOR = Menu.FIRST + 1;//Acrescentar EDITAR fornecedor e Produtos em nova versão
	//private static final int ADICIONAR_PRODUTO = Menu.FIRST + 1;
	private static final int SAIR = Menu.FIRST + 2;

	
	/**********************************************************************************/
	/** 						 Fornecedor 1 -- Aurora								 */
	/********************************************************************************/
	    
	public String[] produtos_0 = { "Costela especial", "Carré Suino",
			"Barriga Suino", "Orelha Salgada",
			"Pés Salgados", "Costela Salgada",
			"Pele Salgada", "Rabo Salgado",
			"Recorte de Costela", "Lombo Salgado",
			"Medalhão de Lombo", "Bacon Especial",
			"Linguiça Toscana", "Linguiça Paio",
			"Linguiça Calabresa", "Salsicha Hot Dog",
			"Apresuntado Peperi", "Lombo Canadense",
			"Mortadela Aurorella", "Mortadela 500grs",
			"Presunto Coz. s/ Capa", "Presunto Peperi",
			"Calabresa Josefina", "Linguiça Portuguesa",
			"Paio Pacote 400grs", "Calabresa Pct. 400grs",
			"Salame Italiano", "Copa Curada",
			"Medalhão Peito Frango", "Linguiça de Frango",
			"Almodega caixeta", "Kibe em Caixeta",
			"Queijo Prato", "Requeijão Cremoso",
			"Pão de Queijo 400grs", "Lasanha Bolonhesa",
			"Auroggets a Granel", "Steak de Frango",
			"Filezinho de Empanado",
			"Filé Peito Frango Empanado", "Peito s/ Osso s/ Pele",
			"Mussarela", "Mortadela Peperi",
			"Apresuntado Aurora", "Linguiça Portuguesa",
			"Presunto Coz. c/ Capa", "Costela Defumada",
			"Aurolat de Morango 900ml", "Aurolat de Pêssego 900ml",
			"Aurolat de Coco 900ml", "Hamburguer em Caixa",
			"Tirinhas de Frango", "Hamburguer 56grs", "Leite Aurolat" };
	
	
	/**********************************************************************************/
	/** 						 Fornecedor 2 -- Nobre								 */
	/********************************************************************************/
	
	public String[] produtos_1 = { "Toscana Nobre", "Bacon Nobre",
			"Calabresa Nobre" };
	
	
	/**********************************************************************************/
	/** 						 Fornecedor 3 -- Sertão								 */
	/********************************************************************************/
	public String[] produtos_2 = { "30kg. Carne seca 5kg", "Troca" };

	
	/**********************************************************************************/
	/** 						 Fornecedor 4 -- Emerson							 */
	/********************************************************************************/
	public String[] produtos_3 = { "Ovos" };
	
	/**********************************************************************************/
	/** 						 Fornecedor 5 -- Sadia/Perdigão						 */
	/********************************************************************************/
	public String[] produtos_4 = { "Calabresa Sadia", "Calabresa Perdigão",
			"Bacon Sadia", "Toscana Sadia", "Mussarela Sadia",
			"Queijo Prato Sadia", "Presunto s/ Capa Sadia",
			"Presunto c/ Capa Sadia", "Presunto s/ Capa Perdigão",
			"Presunto c/ Capa Perdigão", "Salsicha a Granel Sadia",
			"Salsicha pcte 500grs Sadia", "Salsicha a Granel Perdigão",
			"Salsicha pct 500gr Perdigão", "Salame Sadia", "Salame Perdigão" };
	

	/**********************************************************************************/
	/** 						Fornecedor 6 -- Céu Azul							 */
	/********************************************************************************/
	public String[] produtos_5 = { "Galinha cx. 20kg", "Pé cx. 20kg",
			"Drumete temp. cx. 20kg", "Fígado cx. 8kg", "Moela cx. 8kg",
			"Dorso cx. 20kg", "Frango Congelado cx. 20kg",
			"Frango Resfriado cx. 20kg", "Coração cx. 8kg", "Tulipa cx. 20kg",
			"Peito cx. 20kg", "Coxa cx. 20kg", "Asa cx. 20kg",
			"File Interfolhado cx. 20kg", "Sobre Coxa Inter. 20kg",
			"File Coxa cx. 20kg", "Drumete s/ Temp. cx. 20kg" };
	

	/**********************************************************************************/
	/** 						Fornecedor 7 -- JBS/Marfrig							 */
	/********************************************************************************/
	public String[] produtos_6 = { "Cupim", "Lagarto", "Contra Filé",
			"Baby Beef", "Picanha", "Merluza", "Fígado", "Rabo", "Bucho",
			"Mocotó" };
	
	/**********************************************************************************/
	/** 						Fornecedor 8 -- Holambra							 */
	/********************************************************************************/
	public String[] produtos_7 = { "Coxa cx. 30kg", "Peito cx. 30kg",
			"Coração", "Moela cx. 30kg", "Salsicha Hot Dog cx. 20kg",
			"Fígado cx. 20kg", "Asa cx. 30kg", "Pé", "Dorso",
			"Frango Resfr. cx. 30kg", "Frango Cong. cx. 30kg",
			"Filé Interfolhado" };
	

	/**********************************************************************************/
	/** 						Fornecedor 9 -- Rajá/Suzano							 */
	/********************************************************************************/
	public String[] produtos_8 = { "Metades", "Papada", "Frissura 5 unidades" };
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.estoque);

		
		/**********************************************************************************/
		/** 						Inicializa componentes da aplicação					 */
		/********************************************************************************/
		 expList = (ExpandableListView) findViewById(R.id.expListProdutos);
		 txtDataPedidoSexta = (TextView) findViewById(R.id.txtDataSexta);
		 txtDataPedidoSegunda = (TextView)findViewById(R.id.txtDataSegunda);
		 
		
		/**********************************************************************************/
		/** 					 Pega o nome da loja que foi escolhida					 */
		/********************************************************************************/
		Intent intent = getIntent();
		String lojaSelecionada = intent.getStringExtra("lojaSelecionada");

	
		/**********************************************************************************/
		/** 					Toast que mostra a loja selecionada 					 */
		/********************************************************************************/
		Toast.makeText(this, lojaSelecionada, Toast.LENGTH_SHORT).show();




		/**********************************************************************************/
		/**				 	Pega data em que foi realizado o pedido						 */
		/********************************************************************************/

		String dataSexta = intent.getStringExtra("dataSexta");
		String dataSegunda = intent.getStringExtra("dataSegunda");

		txtDataPedidoSexta.setText(dataSexta);
		txtDataPedidoSegunda.setText(dataSegunda);

	/******************************************************************************
	 * 		Cria uma lista para cada Fornecedor e seu produto, essa lista será	  *
	 * 						passada para o ADAPTER								  *
	 *****************************************************************************/

		List<Produtos> listaProduto_0 = new ArrayList<Produtos>();
		List<Produtos> listaProduto_1 = new ArrayList<Produtos>();
		List<Produtos> listaProduto_2 = new ArrayList<Produtos>();
		List<Produtos> listaProduto_3 = new ArrayList<Produtos>();
		List<Produtos> listaProduto_4 = new ArrayList<Produtos>();
		List<Produtos> listaProduto_5 = new ArrayList<Produtos>();
		List<Produtos> listaProduto_6 = new ArrayList<Produtos>();
		List<Produtos> listaProduto_7 = new ArrayList<Produtos>();
		List<Produtos> listaProduto_8 = new ArrayList<Produtos>();


		/**********************************************************************************/
		/**						ADICIONA os produtos em cada lista						 */
		/********************************************************************************/
		for (int i = 0; i < produtos_0.length; i++) {
			listaProduto_0.add(new Produtos(produtos_0[i].toString()));
		}
		for (int i = 0; i < produtos_1.length; i++) {
			listaProduto_1.add(new Produtos(produtos_1[i].toString()));
		}
		for (int i = 0; i < produtos_2.length; i++) {
			listaProduto_2.add(new Produtos(produtos_2[i].toString()));
		}
		for (int i = 0; i < produtos_3.length; i++) {
			listaProduto_3.add(new Produtos(produtos_3[i].toString()));
		}
		for (int i = 0; i < produtos_4.length; i++) {
			listaProduto_4.add(new Produtos(produtos_4[i].toString()));
		}
		for (int i = 0; i < produtos_5.length; i++) {
			listaProduto_5.add(new Produtos(produtos_5[i].toString()));
		}
		for (int i = 0; i < produtos_6.length; i++) {
			listaProduto_6.add(new Produtos(produtos_6[i].toString()));
		}
		for (int i = 0; i < produtos_7.length; i++) {
			listaProduto_7.add(new Produtos(produtos_7[i].toString()));
		}
		for (int i = 0; i < produtos_8.length; i++) {
			listaProduto_8.add(new Produtos(produtos_8[i].toString()));
		}
   
		
		AdapterProdutos adapter = new AdapterProdutos(this, listaProduto_0,
				listaProduto_1, listaProduto_2, listaProduto_3, listaProduto_4,
				listaProduto_5, listaProduto_6, listaProduto_7, listaProduto_8,
				dataSexta,dataSegunda, lojaSelecionada);
		expList.setAdapter(adapter);
		
	}
	
	
	
	
	
	/**********************************************************************************/
	/**								Cria menu da aplicação							 */
	/********************************************************************************/
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		menu.add(0, EXPORTAR, 0, "Exportar por e-mail");
		menu.add(0, VER_RELATORIO, 0, "Ver relatório");
		// menu.add(0, VER_RELATORIO, 0, "Ver relatório");
		menu.add(0, SAIR, 0, "Sair");

		getMenuInflater().inflate(R.menu.login, menu);

		return super.onCreateOptionsMenu(menu);
	}
	
	/**********************************************************************************/
	/**				Método chamado quando é selecionado algum item no MENU			 */
	/********************************************************************************/
	public boolean onOptionsItemSelected(MenuItem item) {

		switch (item.getItemId()) {
		case EXPORTAR:
			Toast.makeText(this, "Envio de relatório por e-mail desabilitado até a proxima versão!", Toast.LENGTH_LONG).show();
			break;
		case VER_RELATORIO:

		/***************************************************************/
		/**  Ver relatório de pedido que está no Site
		*************************************************************/
			Intent intentMostraSite = new Intent(Estoque.this,
					MostrarSite.class);
			Estoque.this.startActivity(intentMostraSite);
			break;
		case SAIR:
			// SAir da aplicação
			this.finish();
			break;
		}
		return super.onContextItemSelected(item);
	}	
}
