package ylb.training.holamundo;

import android.app.Activity;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.content.Intent;


public class HolaMundoActivity extends Activity {
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        final EditText txtNombre = (EditText)findViewById(R.id.txtNombre);
    	final Button btnSaludar = (Button)findViewById(R.id.btnSaludar);
        btnSaludar.setOnClickListener(new OnClickListener() {
	        public void onClick(View arg0) {
	            Intent intent = new Intent(HolaMundoActivity.this, frmSaludo.class);
	     
	            Bundle bundle = new Bundle();
	            bundle.putString("NOMBRE", txtNombre.getText().toString());
	            intent.putExtras(bundle);
	     
	            startActivity(intent);
	        }
	
	    });
    }
}