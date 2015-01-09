package br.com.tairoroberto.renascercarnes;



import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;

public class RenascerSplash extends Activity {
    
    private Thread mSplashThread;
    private boolean mblnClicou = false;
 
    /**************************************************************************************/
	/**	 		 Evento chamado quando a activity é executada pela primeira vez			 */
	/*************************** ********************************************************/
		
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.renascer_splash);
    
        /**************************************************************************************/
    	/**	 		Thead que roda enquanto espera para abrir tela principal do App			 */
    	/*************************** ********************************************************/
        mSplashThread = new Thread() {
            @Override
            public void run() {
             try {
                    synchronized(this){
                        wait(1000);
                        mblnClicou = true;
                    }
                }
                catch(InterruptedException ex){
                }
            /**************************************************************************************/
         	/**	 					Se for clicado Carrega a Activity Principal					 */
         	/*************************** ********************************************************/
                if (mblnClicou){
                      finish();
                     
             
                 Intent i = new Intent();
                 i.setClass(RenascerSplash.this, Login.class);
                 startActivity(i);
                }
            }
        };
         
        mSplashThread.start();
    }
     
    @Override
    public void onPause()
    {
        super.onPause();
     /**********************************************************************************************/
    /**	 garante que quando o usuário clicar no botão "Voltar" o sistema deve finalizar a thread  */
   /*************************** ******************************************************************/
          mSplashThread.interrupt();
    }
     
    
    
     /**********************************************************************************************/
    /**	 O método abaixo finaliza o comando wait mesmo que ele não tenha terminado sua espera	  */
   /*************************** ******************************************************************/
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		if (event.getAction() == MotionEvent.ACTION_DOWN) {
			synchronized (mSplashThread) {
				mblnClicou = true;

				mSplashThread.notifyAll();
			}
		}
		return true;
	}

}