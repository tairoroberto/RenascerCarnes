package br.com.tairoroberto.renascercarnes;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.BaseExpandableListAdapter;
import android.widget.CheckBox;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.List;

import br.com.tairoroberto.conexao.DeletaPedidoSegunda;
import br.com.tairoroberto.conexao.DeletaPedidoSexta;
import br.com.tairoroberto.conexao.InserePedidoSegunda;
import br.com.tairoroberto.conexao.InserePedidoSexta;


public class AdapterProdutos extends BaseExpandableListAdapter {
	
	/************************************************************************************
	*	 			 		String con todos os fornecedores							*
	*************************** ********************************************************/

	public String[] fornecedores = { "Fornecedor 1 -- Aurora",
			"Fornecedor 2 -- Nobre", "Fornecedor 3 -- Sertão",
			"Fornecedor 4 -- Emerson", "Fornecedor 5 -- Sadia/Perdigão",
			"Fornecedor 6 -- Céu Azul", "Fornecedor 7 -- JBS/Marfrig",
			"Fornecedor 8 -- Holambra", "Fornecedor 9 -- Rajá/Suzano" };
	
	
	
	/************************************************************************************
	*	 				 Array de String com todos os fornecedores						*
	*************************** ********************************************************/

	
	/************************ Fornecedor 1 -- Aurora *************************/
	
	public String[][] produtos = {
			{ "Costela especial", "Carré Suino",
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
					"Tirinhas de Frango", "Hamburguer 56grs", "Leite Aurolat" }, 
					

		/************************ Fornecedor 2 -- Nobre ************************/

			{ "Toscana Nobre", "Bacon Nobre", "Calabresa Nobre" },

						
		/************************ Fornecedor 3 -- Sertão ************************/

			{ "30kg. Carne seca 5kg - ", "Troca" },// Fornecedor 3

			
		/************************ Fornecedor 4 -- Emerson ************************/

			{ "Ovos" },// Fornecedor 4
						
		/************************ Fornecedor 5 -- Sadia/Perdigão ************************/

			{ "Calabresa Sadia", "Calabresa Perdigão", "Bacon Sadia",
					"Toscana Sadia", "Mussarela Sadia", "Queijo Prato Sadia",
					"Presunto s/ Capa Sadia", "Presunto c/ Capa Sadia",
					"Presunto s/ Capa Perdigão", "Presunto c/ Capa Perdigão",
					"Salsicha a Granel Sadia", "Salsicha pcte 500grs Sadia",
					"Salsicha a Granel Perdigão",
					"Salsicha pct 500gr Perdigão", "Salame Sadia",
					"Salame Perdigão" },
					
					
		/************************ Fornecedor 6 -- Céu Azul ************************/

			{ "Galinha cx. 20kg", "Pé cx. 20kg", "Drumete temp. cx. 20kg",
					"Fígado cx. 8kg", "Moela cx. 8kg", "Dorso cx. 20kg",
					"Frango Congelado cx. 20kg", "Frango Resfriado cx. 20kg",
					"Coração cx. 8kg", "Tulipa cx. 20kg", "Peito cx. 20kg",
					"Coxa cx. 20kg", "Asa cx. 20kg",
					"File Interfolhado cx. 20kg", "Sobre Coxa Inter. 20kg",
					"File Coxa cx. 20kg", "Drumete s/ Temp. cx. 20kg" },
					
					
		/************************ Fornecedor 7 -- JBS/Marfrig ************************/

			{ "Cupim", "Lagarto", "Contra Filé", "Baby Beef", "Picanha",
					"Merluza", "Fígado", "Rabo", "Bucho", "Mocotó" },

		/************************ Fornecedor 8 -- Holambra ************************/

			{ "Coxa cx. 30kg", "Peito cx. 30kg", "Coração", "Moela cx. 30kg",
					"Salsicha Hot Dog cx. 20kg", "Fígado cx. 20kg",
					"Asa cx. 30kg", "Pé", "Dorso", "Frango Resfr. cx. 30kg",
					"Frango Cong. cx. 30kg", "Filé Interfolhado" },
		/************************ Fornecedor 9 -- Rajá/Suzano ************************/

			{ "Metades", "Papada", "Frissura 5 unidades" }

	};

	public String[] quantidade = { "--", "01", "02", "03", "04", "05", "06",
			"07", "08", "09", " 10", "11", "12", "13", "14", "15", "20", "25", 
			"30", "35", "40", "45",	"50", "60", "70", "80", "90", "100"};

	public String[] tipo = { "--", "cx", "pct", "kg", "un" };
	
	
	
	/************************************************************************************
	*				Declaração dos list que serão usadas no Banco de Dados				*
	*************************** ********************************************************/
	
	CriaBancoRenascer criaBanco;
	
	
	/************************************************************************************
	*		Declaração dos list que serão usados para o método Construtos da classe		*
	*************************** ********************************************************/

	private final Activity activity;
	String dataPedidoSexta;
	String dataPedidoSegunda;
	String loja;
	private List<Produtos> itens_0;
	private List<Produtos> itens_1;
	private List<Produtos> itens_2;
	private List<Produtos> itens_3;
	private List<Produtos> itens_4;
	private List<Produtos> itens_5;
	private List<Produtos> itens_6;
	private List<Produtos> itens_7;
	private List<Produtos> itens_8;

	
	/************************************************************************************
	*		Método construtor que recebe as listas de produtos 							*
	*************************** ********************************************************/

	public AdapterProdutos(Activity activity, List<Produtos> itens_0,
			List<Produtos> itens_1, List<Produtos> itens_2,
			List<Produtos> itens_3, List<Produtos> itens_4,
			List<Produtos> itens_5, List<Produtos> itens_6,
			List<Produtos> itens_7, List<Produtos> itens_8,
			String dataPedidoSexta,String dataPedidoSegunda,
			String loja) {
		
		this.activity = activity;
		this.itens_0 = itens_0;
		this.itens_1 = itens_1;
		this.itens_2 = itens_2;
		this.itens_3 = itens_3;
		this.itens_4 = itens_4;
		this.itens_5 = itens_5;
		this.itens_6 = itens_6;
		this.itens_7 = itens_7;
		this.itens_8 = itens_8;
		this.dataPedidoSexta = dataPedidoSexta;
		this.dataPedidoSegunda = dataPedidoSegunda;
		this.loja = loja;
		
	}

	
	/************************************************************************************
	*		Criação da classe estática ViewHolder que será uma ponte para a lista		* 
	*			Essa classe é usada para dar mehor desempenho a lista 					*
	*************************** ********************************************************/

	static class ViewChildHolder {

		TextView nomeProduto;
		Spinner quantidadeSexta;
		Spinner quantidadeSegunda;
		Spinner tipoSexta;
		Spinner tipoSegunda;

		CheckBox sexta;
		CheckBox segunda;
	}

	/************************************************************************************
	*		Métodos Abstratos da Classes BASEADAPTER que devem ser implementados		*
	*************************** ********************************************************/

	@Override
	public int getGroupCount() {
		return fornecedores.length;
	}

	@Override
	public int getChildrenCount(int groupPosition) {
		return produtos[groupPosition].length;
	}

	@Override
	public Object getGroup(int groupPosition) {
		return fornecedores[groupPosition];
	}

	@Override
	public Object getChild(int groupPosition, int childPosition) {
		return produtos[groupPosition][childPosition];
	}

	@Override
	public long getGroupId(int groupPosition) {
		return groupPosition;
	}

	@Override
	public long getChildId(int groupPosition, int childPosition) {
		return childPosition;
	}

	@Override
	public boolean hasStableIds() {
		// TODO Auto-generated method stub
		return false;
	}

	/************************************************************************************
	*				GetGroupView Mostra o fornecedor selecionado 						*
	*************************** ********************************************************/

	@Override
	public View getGroupView(int groupPosition, boolean isExpanded,
			View convertView, ViewGroup parent) {
		TextView texto = new TextView(this.activity);
		texto.setText(fornecedores[groupPosition]);
		texto.setPadding(60, 20, 0, 0);
		texto.setTextColor(Color.RED);
		texto.setTextSize(32);
		texto.setTypeface(Typeface.DEFAULT, Typeface.BOLD);

		return texto; // retorna o nome do
						// fornecedor
	}

	/************************************************************************************
	*			GetChildView Mostra a lista de produtos de cada fornecedor				*
	*		    Esse método é o responsavel por fazer a lista de produtos				*
	*************************** ********************************************************/

	@Override
	public View getChildView(final int groupPosition, int childPosition,
			boolean isLastChild, View convertView, ViewGroup parent) {

		
		/************************************************************************************
		*						Variável de instaciação do produto 							*
		*************************** ********************************************************/

		Produtos produto;

		/************************************************************************************
		*	Verifica qual foi o Fornecedor selecionado e pega os produtos	equivalentes	*
		*   Se for clicado no fornecedor de indice 0, a lista de indice 0 será mostrada 	*
		*    Se for clicado no fornecedor de indice 1, a lista de indice 1 será mostrada 	*
		*    e assim por diante																*
		*************************** ********************************************************/
		
		if (groupPosition == 0) {
			produto = itens_0.get(childPosition);
		} else if (groupPosition == 1) {
			produto = itens_1.get(childPosition);
		} else if (groupPosition == 2) {
			produto = itens_2.get(childPosition);
		} else if (groupPosition == 3) {
			produto = itens_3.get(childPosition);
		} else if (groupPosition == 4) {
			produto = itens_4.get(childPosition);
		} else if (groupPosition == 5) {
			produto = itens_5.get(childPosition);
		} else if (groupPosition == 6) {
			produto = itens_6.get(childPosition);
		} else if (groupPosition == 7) {
			produto = itens_7.get(childPosition);
		} else {
			produto = itens_8.get(childPosition);
		}

		/************************************************************************************
		*						Variável child que terá os objetos da lista					*
		*************************** ********************************************************/
		
		ViewChildHolder child = new ViewChildHolder();

		
		/************************************************************************************
		*					Adapter do Spinner de quantidade dos produtos 					*
		*************************** ********************************************************/
	

		ArrayAdapter<String> adapterQuantidadeSexta = new ArrayAdapter<String>(
				this.activity, android.R.layout.simple_list_item_1, quantidade);
		adapterQuantidadeSexta
				.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

		ArrayAdapter<String> adapterQuantidadeSegunda = new ArrayAdapter<String>(
				this.activity, android.R.layout.simple_list_item_1, quantidade);
		adapterQuantidadeSegunda
				.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

		/************************************************************************************
		*					Adapter do Spinner de tipo dos produtos 						*
		*************************** ********************************************************/

		ArrayAdapter<String> adapterTipoSexta = new ArrayAdapter<String>(
				this.activity, android.R.layout.simple_list_item_1, tipo);
		adapterTipoSexta
				.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

		ArrayAdapter<String> adapterTipoSegunda = new ArrayAdapter<String>(
				this.activity, android.R.layout.simple_list_item_1, tipo);
		adapterTipoSegunda
				.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		

		/************************************************************************************
		*	 Se o layout estiver vazio ele infla, senão ele pega os objetos já existentes	*
		*************************** ********************************************************/
		
		if (convertView == null) {
			
			
			/************************************************************************************************
			*	Seta os objetos do ViewHolder child com os objtos do Xml em que foi feito o layout de linha	*
			*************************** *********************************************************************/
			
			LayoutInflater inflater = (LayoutInflater) activity
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

			convertView = inflater.inflate(R.layout.produtos, null);

			child.nomeProduto = (TextView) convertView
					.findViewById(R.id.txtLayoutProduto);

			child.quantidadeSexta = (Spinner) convertView
					.findViewById(R.id.spinnerLayoutQuantidade);
			child.quantidadeSegunda = (Spinner) convertView
					.findViewById(R.id.spinnerLayoutQuantidade2);

			child.tipoSexta = (Spinner) convertView
					.findViewById(R.id.spinnerLayoutTipo);
			child.tipoSegunda = (Spinner) convertView
					.findViewById(R.id.spinnerLayoutTipo2);

			child.sexta = (CheckBox) convertView.findViewById(R.id.checkSexta);

			child.segunda = (CheckBox) convertView
					.findViewById(R.id.checkSegunda);

			convertView.setTag(child);

		}

		/************************************************************************************
		*	 Se o layout já estiver inflado será usado os valores dos objetos do layout		*
		*************************** ********************************************************/
		
		final ViewChildHolder holder = (ViewChildHolder) convertView.getTag();

		
		/************************************************************************************
		*					Seta o Nome e a FORMATAÇÂO do produto							*
		*************************** ********************************************************/
		
		holder.nomeProduto.setText(produto.getNome());
		holder.nomeProduto.setPadding(20, 10, 0, 0);
		holder.nomeProduto.setTextSize(28);
		holder.nomeProduto.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
		
		
		/************************************************************************************
		*						SETA os adapters para os Spinners							*
		*************************** ********************************************************/
		
		holder.quantidadeSexta.setAdapter(adapterQuantidadeSexta);
		holder.tipoSexta.setAdapter(adapterTipoSexta);
		holder.quantidadeSegunda.setAdapter(adapterQuantidadeSegunda);
		holder.tipoSegunda.setAdapter(adapterTipoSegunda);

		
		/************************************************************************************
		*						 Função para marcar checkBox Sexta 							*
		*************************** ********************************************************/
		
		holder.sexta.setTag(produto);
		holder.sexta.setChecked(produto.isSexta());
		holder.sexta.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				CheckBox check = (CheckBox) v;
				Produtos item = (Produtos) check.getTag();
				item.setSexta((check.isChecked()));
			
				
			/************************************************************************************
			*		Verifica se os produtos e tipos de SEXTA foram serlecionados				*
			*************************** ********************************************************/
			if(holder.sexta.isChecked()){
				if ((item.isSexta())
						&& (holder.quantidadeSexta.getSelectedItem().toString() == "--")
						&& (holder.tipoSexta.getSelectedItem().toString() == "--")) {

					mensagem("Alerta",
							"Selecione a QUANTIDADE e TIPO do produto de Sexta-feira...!");
					holder.sexta.setChecked(false);

				} else if ((item.isSexta())
						&& (holder.quantidadeSexta.getSelectedItem().toString() != "--")
						&& (holder.tipoSexta.getSelectedItem().toString() == "--")) {

					mensagem("Alerta",
							"Selecione o TIPO do produto de Sexta-feira..!");
					holder.sexta.setChecked(false);

				} else if ((item.isSexta())
						&& (holder.quantidadeSexta.getSelectedItem().toString() == "--")
						&& (holder.tipoSexta.getSelectedItem().toString() != "--")) {

					mensagem("Alerta",
							"Selecione a QUANTIDADE do produto de Sexta-feira...!");
					holder.sexta.setChecked(false);

				} else {
			
					String[] pedido_Sexta = {loja,fornecedores[groupPosition],
									holder.nomeProduto.getText().toString(),
									holder.quantidadeSexta.getSelectedItem()
											.toString(), holder.tipoSexta
											.getSelectedItem().toString(),
									dataPedidoSexta};
							InserePedidoSexta enviaSexta = new InserePedidoSexta(activity);
							enviaSexta.execute(pedido_Sexta);
				}

			}else{
				String[] deletaPedido_Sexta = {loja,fornecedores[groupPosition],
						holder.nomeProduto.getText().toString(),
						holder.quantidadeSexta.getSelectedItem()
								.toString(), holder.tipoSexta
								.getSelectedItem().toString(),
						dataPedidoSexta};
				DeletaPedidoSexta deletaSexta = new DeletaPedidoSexta(activity);
				deletaSexta.execute(deletaPedido_Sexta);
			}
		}
		});
		
	

		
		/************************************************************************************
		*						 Função para marcar checkBox Segunda 						*
		*************************** ********************************************************/
		
		holder.segunda.setTag(produto);
		holder.segunda.setChecked(produto.isSegunda());
		holder.segunda.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				CheckBox check = (CheckBox) v;
				Produtos item = (Produtos) check.getTag();
				item.setSegunda((check.isChecked()));
			
			/************************************************************************************
			*		Verifica se os produtos e tipos de SEGUNDA foram serlecionados				*
			*************************** ********************************************************/
				if(holder.segunda.isChecked()){
					if ((item.isSegunda())
							&& (holder.quantidadeSegunda.getSelectedItem()
									.toString() == "--")
							&& (holder.tipoSegunda.getSelectedItem().toString() == "--")) {

						mensagem("Alerta",
								"Selecione a QUANTIDADE e TIPO do produto de Segunda-feira...!");
						holder.segunda.setChecked(false);

					} else if ((item.isSegunda())
							&& (holder.quantidadeSegunda.getSelectedItem()
									.toString() != "--")
							&& (holder.tipoSegunda.getSelectedItem().toString() == "--")) {

						mensagem("Alerta",
								"Selecione o TIPO do produto de Segunda-feira...!");
						holder.segunda.setChecked(false);

					} else if ((item.isSegunda())
							&& (holder.quantidadeSegunda.getSelectedItem()
									.toString() == "--")
							&& (holder.tipoSegunda.getSelectedItem().toString() != "--")) {

						mensagem("Alerta",
								"Selecione a QUANTIDADE do produto de Segunda-feira...!");
						holder.segunda.setChecked(false);

					} else {

						String[] parametros_segunda = {loja,fornecedores[groupPosition],
													   holder.nomeProduto.getText().toString(),
													   holder.quantidadeSegunda.getSelectedItem().toString(), 
													   holder.tipoSegunda.getSelectedItem().toString(), 
													   dataPedidoSegunda};
						InserePedidoSegunda enviaSegunda = new InserePedidoSegunda(activity);
						enviaSegunda.execute(parametros_segunda);
					}

				}else{
					String[] deletaPedido_segunda = {loja,fornecedores[groupPosition],
							   holder.nomeProduto.getText().toString(),
							   holder.quantidadeSegunda.getSelectedItem().toString(), 
							   holder.tipoSegunda.getSelectedItem().toString(), 
							   dataPedidoSegunda};
					DeletaPedidoSegunda deletaSegunda = new DeletaPedidoSegunda(activity);
					deletaSegunda.execute(deletaPedido_segunda);
				}
			}
				
			
		});


		
		/************************************************************************************
		*	 			 Função para deixar marcado o SPINNER QUANTIDADE SEXTA				*
		*************************** ********************************************************/
		
		holder.quantidadeSexta.setTag(produto);
		holder.quantidadeSexta.setSelection(produto.getQuantidadeSexta());
		holder.quantidadeSexta
				.setOnItemSelectedListener(new OnItemSelectedListener() {

					@Override
					public void onItemSelected(AdapterView<?> parent,
							View view, int position, long id) {
						Spinner sp = (Spinner) parent;
						Produtos item = (Produtos) sp.getTag();
						item.setQuantidadeSexta((sp.getSelectedItemPosition()));
					}

					@Override
					public void onNothingSelected(AdapterView<?> parent) {
						// TODO Auto-generated method stub

					}
				});

		
		/************************************************************************************
		*	 			 Função para deixar marcado o SPINNER QUANTIDADE SEGUNDA				*
		*************************** ********************************************************/
		
		holder.quantidadeSegunda.setTag(produto);
		holder.quantidadeSegunda.setSelection(produto.getQuantidadeSegunda());
		holder.quantidadeSegunda
				.setOnItemSelectedListener(new OnItemSelectedListener() {

					@Override
					public void onItemSelected(AdapterView<?> parent,
							View view, int position, long id) {
						Spinner sp = (Spinner) parent;
						Produtos item = (Produtos) sp.getTag();
						item.setQuantidadeSegunda((sp.getSelectedItemPosition()));
					}

					@Override
					public void onNothingSelected(AdapterView<?> parent) {
						// TODO Auto-generated method stub

					}
				});

		
		/************************************************************************************
		*	 			 Função para deixar marcado o SPINNER TIPO SEXTA					*
		*************************** ********************************************************/
		
		holder.tipoSexta.setTag(produto);
		holder.tipoSexta.setSelection(produto.getTipoSexta());
		holder.tipoSexta
				.setOnItemSelectedListener(new OnItemSelectedListener() {

					@Override
					public void onItemSelected(AdapterView<?> parent,
							View view, int position, long id) {
						Spinner sp = (Spinner) parent;
						Produtos item = (Produtos) sp.getTag();
						item.setTipoSexta((sp.getSelectedItemPosition()));
					}

					@Override
					public void onNothingSelected(AdapterView<?> parent) {
						// TODO Auto-generated method stub

					}
				});

		
	/**************************************************************************************/
	/**	 			 Função para deixar marcado o SPINNER TIPO SEGUNDA					 */
	/*************************** ********************************************************/
		
		holder.tipoSegunda.setTag(produto);
		holder.tipoSegunda.setSelection(produto.getTipoSegunda());
		holder.tipoSegunda
				.setOnItemSelectedListener(new OnItemSelectedListener() {

					@Override
					public void onItemSelected(AdapterView<?> parent,
							View view, int position, long id) {
						Spinner sp = (Spinner) parent;
						Produtos item = (Produtos) sp.getTag();
						item.setTipoSegunda((sp.getSelectedItemPosition()));
					}

					@Override
					public void onNothingSelected(AdapterView<?> parent) {
						// TODO Auto-generated method stub

					}
				});
		
		
		/************************************************************************************
		*	 							BANCO DE DADOS										*
		*************************** ********************************************************/
		
		
		
		
		
		
		
		
		
		
		
		
		/************************************************************************************
		*	 			Retorna o Convert view com todos os objetos inflados 				*
		*************************** ********************************************************/
		return convertView;
	
	}

	@Override
	public boolean isChildSelectable(int groupPosition, int childPosition) {
		// TODO Auto-generated method stub
		return true;
	}
	
	
	public void mensagem(String titulo, String texto) {
		AlertDialog.Builder Mensagem = new AlertDialog.Builder(this.activity);
		Mensagem.setTitle(titulo);
		Mensagem.setMessage(texto);
		Mensagem.setNeutralButton("OK", null);
		Mensagem.show();

	}
}
