package br.com.tairoroberto.conexao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.json.JSONObject;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.widget.Toast;


/*****************************************************************************/
/**				Classe para envio de estoque para SERVIDOR					*/
/***************************************************************************/ 
public class AtualizaPedidoSegunda extends AsyncTask<String, Void, String> {

	private final int TIMEOUT_MILLISEC = 10000;
	Context contexto;
	
	public AtualizaPedidoSegunda(Context c){
		this.contexto = c;
	}
	
	@Override
	protected String doInBackground(String... parametros) {
		try {
 
			/*****************************************************************************/
			/**		Insere os dados no arquivo Json para enviar ao servidor				*/
			/***************************************************************************/ 
		
			JSONObject json = new JSONObject();
			json.put("loja", parametros[0]);
			json.put("nome_fornecedor", parametros[1]);
			json.put("nome_produto", parametros[2]);
			json.put("quantidadeSexta", parametros[3]);
			json.put("tipoSexta", parametros[4]);
			json.put("dataPedido", parametros[5]);
			
			
			/** Passa os parametros de conexão */
			HttpParams httpParams = new BasicHttpParams();
			HttpConnectionParams.setConnectionTimeout(httpParams,
					TIMEOUT_MILLISEC);
			HttpConnectionParams.setSoTimeout(httpParams, TIMEOUT_MILLISEC);
			HttpClient client = new DefaultHttpClient(httpParams);

			
			/*****************************************************************************/
			/**		Url do servidor que será enviado o arquivo Json com os dados		*/
			/***************************************************************************/
			String url = "http://www.tairoroberto.kinghost.net/atualizaProdutoSegunda";

			HttpPost request = new HttpPost(url);
			request.setEntity(new ByteArrayEntity(json.toString().getBytes(
					"UTF8")));
			request.setHeader("json", json.toString());
			HttpResponse response = client.execute(request);
			HttpEntity entity = response.getEntity();

			
			/***************************************************************************/
			/** 	  Mostra o retorno do arquivo JSON que foi enviado ao servidor	  */
			/*************************************************************************/
			if (entity != null) {
				InputStream instream = entity.getContent();

				final String result = convertStreamToString(instream);
				Log.i("Read from server", result);

				Handler mHandler = new Handler(Looper.getMainLooper());
				mHandler.post(new Runnable() {

					@Override
					public void run() {
						Toast.makeText(contexto, result,
								Toast.LENGTH_SHORT).show();
					}
				});

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/***************************************************************************/
	/** 	    Método executado quando a classe de envio é chamada			  */
	/*************************************************************************/
	@Override
	protected void onPostExecute(String result) {
		/*** Colacar algo aqui caso queira passar uma messagem ao usuário */
	}

	
	/*******************************************************************************************************/
	/**     Método executado para fazer a conveão do objeto JSON que veio do servidor pra uma String	  */
	/*****************************************************************************************************/
	public String convertStreamToString(InputStream is) {

		BufferedReader reader = new BufferedReader(
				new InputStreamReader(is));
		StringBuilder sb = new StringBuilder();

		String line = null;
		try {
			while ((line = reader.readLine()) != null) {
				sb.append(line + "\n");
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				is.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return sb.toString();
	}
}