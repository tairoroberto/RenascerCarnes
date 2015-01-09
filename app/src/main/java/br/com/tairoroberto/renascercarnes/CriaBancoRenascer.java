package br.com.tairoroberto.renascercarnes;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class CriaBancoRenascer {

	private final String _ID = "_id";
	private final String NOME_LOJA = "nome_loja";
	private final String NOME_FORNECEDOR = "nome_fornecedor";
	private final String NOME_PRODUTO = "nome_produto";
	private final String QUANTIDADE_SEXTA = "quantidadeSexta";
	private final String QUANTIDADE_SEGUNDA = "quantidadeSegunda";
	private final String TIPO_SEXTA = "tipoSexta";
	private final String TIPO_SEGUNDA = "tipoSegunda";
	private final String DATA_PEDIDO_SEXTA = "dataPedidoSexta";
	private final String DATA_PEDIDO_SEGUNDA = "dataPedidoSegunda";
	private final String NOME_BANCO = "bancoRenascer.db";
	private final String NOME_TABELA_SEXTA = "PedidoSexta";
	private final String NOME_TABELA_SEGUNDA = "PedidoSegunda";
	private final int DB_VERSION = 1;

	private final Context context;
	private DbHelper myHelper;
	private SQLiteDatabase database;

	// Construtor
	public CriaBancoRenascer(Context context) {
		this.context = context;
	}

	public class DbHelper extends SQLiteOpenHelper {

		// Construtor de DbHelper
		public DbHelper(Context context) {
			super(context, NOME_BANCO, null, DB_VERSION);
			// TODO Auto-generated constructor stub
		}

		/** Cria as tabelas do banco de dados*/
		@Override
		public void onCreate(SQLiteDatabase db) {
			String sqlSexta = "CREATE TABLE "
						+ NOME_TABELA_SEXTA + " (" 
						+ _ID	+ " INTEGER PRIMARY KEY AUTOINCREMENT , "
						+ NOME_LOJA	+ " TEXT, " 
						+ NOME_FORNECEDOR + " TEXT, " 
						+ NOME_PRODUTO + " TEXT, " 
						+ QUANTIDADE_SEXTA + " TEXT, "
						+ TIPO_SEXTA + " TEXT, "
						+ DATA_PEDIDO_SEXTA + " TEXT );";
			
			String sqlSegunda = "CREATE TABLE "
					+ NOME_TABELA_SEGUNDA + " (" 
					+ _ID	+ " INTEGER PRIMARY KEY AUTOINCREMENT , "
					+ NOME_LOJA	+ " TEXT, " 
					+ NOME_FORNECEDOR + " TEXT, " 
					+ NOME_PRODUTO + " TEXT, " 
					+ QUANTIDADE_SEGUNDA + " TEXT, " 
					+ TIPO_SEGUNDA + " TEXT, " 
					+ DATA_PEDIDO_SEGUNDA + " TEXT );";
			db.execSQL(sqlSexta);
			db.execSQL(sqlSegunda);

		}

		@Override
		public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
			db.execSQL("DROP TABLE IF EXISTS " + NOME_TABELA_SEXTA);
			db.execSQL("DROP TABLE IF EXISTS " + NOME_TABELA_SEGUNDA);
			onCreate(db);
		}

	}

	/**
	 * Abre o banco de dados para ser escrito
	 */
	public CriaBancoRenascer open() {
		myHelper = new DbHelper(context);
		database = myHelper.getWritableDatabase();
		return this;
	}

	/**
	 * fecha o banco de dados
	 */
	public void close() {
		database.close();

	}

	/** insere dados no banco */
	public void inserirSextaBanco(String nome_loja, String nome_fornecedor, String nome_produto,
			String quantidadeSexta, String quantidadeSegunda, String tipoSexta,
			String tipoSegunda, String data) {

		ContentValues valores = new ContentValues();
		valores.put(NOME_LOJA, nome_loja);
		valores.put(NOME_FORNECEDOR, nome_fornecedor);
		valores.put(NOME_PRODUTO, nome_produto);
		valores.put(QUANTIDADE_SEXTA, quantidadeSexta);
		valores.put(QUANTIDADE_SEGUNDA, quantidadeSegunda);
		valores.put(TIPO_SEXTA, tipoSexta);
		valores.put(TIPO_SEGUNDA, tipoSegunda);
		valores.put(DATA_PEDIDO_SEXTA, data);

		database.insert(NOME_TABELA_SEXTA, null, valores);
	}
	
	
	/** insere dados no banco */
	public void inserirSegundaBanco(String nome_loja, String nome_fornecedor, String nome_produto,
			String quantidadeSexta, String quantidadeSegunda, String tipoSexta,
			String tipoSegunda, String data) {

		ContentValues valores = new ContentValues();
		valores.put(NOME_LOJA, nome_loja);
		valores.put(NOME_FORNECEDOR, nome_fornecedor);
		valores.put(NOME_PRODUTO, nome_produto);
		valores.put(QUANTIDADE_SEXTA, quantidadeSexta);
		valores.put(QUANTIDADE_SEGUNDA, quantidadeSegunda);
		valores.put(TIPO_SEXTA, tipoSexta);
		valores.put(TIPO_SEGUNDA, tipoSegunda);
		valores.put(DATA_PEDIDO_SEGUNDA, data);

		database.insert(NOME_TABELA_SEGUNDA, null, valores);
	}

	/**Pega os valores da tabela de sexta*/
	public ArrayList<String> pegarValoresSextaBanco() {

		String[] colunms = { _ID, NOME_LOJA, NOME_FORNECEDOR, NOME_PRODUTO,
				QUANTIDADE_SEXTA, TIPO_SEXTA, DATA_PEDIDO_SEXTA };
		Cursor cursor = database.query(NOME_TABELA_SEXTA, colunms, null, null, null,
				null, null);
		ArrayList<String> resultado = new ArrayList<String>();
		for (cursor.moveToFirst(); !cursor.isAfterLast(); cursor.moveToNext()) {
			if (!cursor.getString(1).isEmpty()) {

				resultado.add(cursor.getString(1));
				resultado.add(cursor.getString(2));// id da coluna que ira
				// retornar
			}
		}
		if (cursor != null) {
			return resultado;
		}
		return null;

	}
	
	
	/**Pega os valores da tabela de segunda*/
	public ArrayList<String> pegarValoresSegundaBanco() {

		String[] colunms = { _ID, NOME_LOJA, NOME_FORNECEDOR, NOME_PRODUTO,
				QUANTIDADE_SEGUNDA, TIPO_SEGUNDA, DATA_PEDIDO_SEGUNDA };
		Cursor cursor = database.query(NOME_TABELA_SEGUNDA, colunms, null, null, null,
				null, null);
		ArrayList<String> resultado = new ArrayList<String>();
		for (cursor.moveToFirst(); !cursor.isAfterLast(); cursor.moveToNext()) {
			if (!cursor.getString(1).isEmpty()) {

				resultado.add(cursor.getString(1));
				resultado.add(cursor.getString(2));// id da coluna que ira
				// retornar
			}
		}
		if (cursor != null) {
			return resultado;
		}
		return null;

	}

	
	/**Deleta os valores da tabela de sexta*/
	public void deletarSexta(String item) {
		database.execSQL("DELETE " + item + "FROM " + NOME_TABELA_SEXTA);
	}
	
	/**Deleta os valores da tabela de segunda*/
	public void deletarSegunda(String item) {
		database.execSQL("DELETE " + item + "FROM " + NOME_TABELA_SEGUNDA);
	}
}
