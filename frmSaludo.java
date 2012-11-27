package ylb.training.holamundo;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class frmSaludo extends Activity{
	 /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {    	
        super.onCreate(savedInstanceState);
        setContentView(R.layout.frmsaludo);
        final TextView lblSaludo = (TextView)findViewById(R.id.lblSaludo);
        Bundle bundle = getIntent().getExtras();
       
        new Sumador().execute("5");
    };

}
class Sumador extends AsyncTask<String, Void, String>{

	@Override
	protected String doInBackground(String... params) {
		// TODO Auto-generated method stub
		 String NAMESPACE = "http://www.subgurim.net/";
	        String URL="http://www.subgurim.net/servicios-web/smaths.asmx";
	        String METHOD_NAME = "suma";
	        String SOAP_ACTION = "http://www.subgurim.net/suma";
	        
	        SoapObject request = new SoapObject(NAMESPACE, METHOD_NAME);
	        
	        request.addProperty("a", "5");
	        request.addProperty("b", "2");
	        SoapSerializationEnvelope envelope =
	        	    new SoapSerializationEnvelope(SoapEnvelope.VER11);
	        	 
	        	envelope.dotNet = true;
	        	 
	        	envelope.setOutputSoapObject(request);
	        	HttpTransportSE transporte = new HttpTransportSE(URL);
	        	 
	        	try
	        	{
	        	    transporte.call(SOAP_ACTION, envelope);
	        	 
	        	    //Se procesa el resultado devuelto
	        	    //...
	        	    SoapPrimitive resultado_xml =(SoapPrimitive)envelope.getResponse();
	        	    String res = resultado_xml.toString();
	        	    return res.toString();
	        	}
	        	catch (Exception e)
	        	{
	        		return "Error!";
	        	}
		
	}
	
}
