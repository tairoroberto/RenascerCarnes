package br.com.tairoroberto.renascercarnes;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MostrarSite extends Activity {
	
	WebView site;
		
	@SuppressLint("SetJavaScriptEnabled")
	@Override
	/**************************************************************/
	/**			  Classe desabilitado ate nova versao			 */
	/************************************************************/
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.ver_site_produtos);
		
		site = (WebView)findViewById(R.id.webView1);
		String url = "http://www.tairoroberto.kinghost.net/pagina";
		
		site.getSettings().setJavaScriptEnabled(true);
		site.getSettings().setSupportZoom(true);
		
		site.loadUrl(url);
		site.setWebViewClient(new WebViewClient() {
		    @Override
		    public boolean shouldOverrideUrlLoading(WebView view, String url) {
		        view.loadUrl(url);
		        return true;
		    }
		});

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub
		return super.onCreateOptionsMenu(menu);
	}
	
	
	@Override
	public void finish() {
	Intent intente = new Intent();
	setResult(1, intente);
	super.finish();
	}
}
