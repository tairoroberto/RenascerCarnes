package br.com.tairoroberto.conexao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
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
public class InserePedidoSegunda extends AsyncTask<String, Void, String> {

	private final int TIMEOUT_MILLISEC = 10000;
	Context contexto;
	
	public InserePedidoSegunda(Context c){
		this.contexto = c;
	}
	
	@Override
	protected String doInBackground(String... parametros) {

        //*****************************************************************************/
        //**		Insere os dados no arquivo Json para enviar ao servidor			 */
        //***************************************************************************/


        HttpClient client = new DefaultHttpClient();
        HttpPost post = new HttpPost("http://www.tairoroberto.kinghost.net/inserirProdutoSegunda");
        try {
            ArrayList<NameValuePair> valores = new ArrayList<NameValuePair>();
            valores.add(new BasicNameValuePair("loja", parametros[0]));
            valores.add(new BasicNameValuePair("nome_fornecedor", parametros[1]));
            valores.add(new BasicNameValuePair("nome_produto", parametros[2]));
            valores.add(new BasicNameValuePair("quantidadeSegunda", parametros[3]));
            valores.add(new BasicNameValuePair("tipoSegunda", parametros[4]));
            valores.add(new BasicNameValuePair("dataPedido", parametros[5]));

            //prepara dados para envias ao webservice
            post.setEntity(new UrlEncodedFormEntity(valores));

            //envia para o webservice
            final HttpResponse response = client.execute(post);

            HttpEntity entity = response.getEntity();

            //roda a resposta na thread principal
            //***************************************************************************//*
            //** 	  Mostra o retorno do arquivo JSON que foi enviado ao servidor	  *//*
            //*************************************************************************//*
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
        } catch (ClientProtocolException e) {}
        catch (IOException e) {}
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
