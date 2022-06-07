package co.edu.unipilito;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

import com.google.android.material.textfield.TextInputLayout;

public class MainActivity3 extends AppCompatActivity {

    private LoginDatabaseHelper myDB;
    private EditText editFullname, editUsername, editEmail, editPassword;
    private RadioButton radioMale, radioFemale;
    private Button btnAddData,btnViewData;
    private int gender;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        getSupportActionBar().setTitle("Singup Form");
        myDB=new LoginDatabaseHelper(this);
        radioMale=(RadioButton) findViewById(R.id.Male);
        btnAddData=(Button) findViewById(R.id.Register);
        editFullname= (EditText) findViewById(R.id.Nombre);
        myDB.initData();
    }

    public void addData(){
        btnAddData.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick(View view){
                        Integer valueInt=new Integer(gender);
                        User user=new User();
                        user.setFullName(editFullname.getEditableText().toString());
                    }

                }


        );

    }

    public void regresar_login(View view){
        startActivity(new Intent(getApplicationContext(),MainActivity2.class));
    }

}