package inc.iris.demoibarts;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;

import inc.iris.demoibarts.ListView.CustomAdapter;
import inc.iris.demoibarts.ListView.DBHelper;
import inc.iris.demoibarts.ListView.Info;

public class EmployeeList extends AppCompatActivity {

    ListView empList;
    CustomAdapter adapter;
    List<Info> list;
    final int IMAGE_REQ_CODE=1;
    private ImageView uploadDP;
    byte[] dp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_list);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addEmployee(EmployeeList.this);
            }
        });

        //Listview
        empList = findViewById(R.id.empList);
        list=initializeList();
        final DBHelper helper=new DBHelper(this);

        adapter=new CustomAdapter(this,R.layout.custom_row,list);
        empList.setAdapter(adapter);
        empList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                AlertDialog.Builder dialog= new AlertDialog.Builder(EmployeeList.this);
                dialog.setMessage("Delete the record");
                final int pos=i;
                dialog.setPositiveButton("Confirm", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        helper.delete(list.get(pos).getName());
                        startActivity(new Intent(EmployeeList.this,EmployeeList.class));
                        finish();}
                });
                dialog.create().show();

            }
        });

    }

    private void addEmployee(final Context context) {
        final AlertDialog.Builder dialog=new AlertDialog.Builder(this);
        View view=getLayoutInflater().inflate(R.layout.add_emp,null);
        final EditText name_et=view.findViewById(R.id.empName);
        final EditText post_et=view.findViewById(R.id.empPost);
        uploadDP=view.findViewById(R.id.uploadDP_img);
        dialog.setView(view);
        dialog.setPositiveButton("Add", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                String name=name_et.getText().toString();
                String post=post_et.getText().toString();
                DBHelper helper=new DBHelper(context);
                Info emp= new Info(name,post,dp);
                helper.addEmp(emp);
                startActivity(new Intent(context,EmployeeList.class));
                finish();


            }
        });
        dialog.setTitle("Add Employee");
        dialog.create().show();

    }

    private List<Info> initializeList() {
       DBHelper helper=new DBHelper(this);
       Toast.makeText(this,"size= "+helper.getEmpList().size(),Toast.LENGTH_SHORT).show();
        return helper.getEmpList();

    }

    public void addImage(View view) {
        Intent camera=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(camera,IMAGE_REQ_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode== IMAGE_REQ_CODE && resultCode==RESULT_OK)
        {
            Bitmap dp_bitmap= (Bitmap) data.getExtras().get("data");
            ByteArrayOutputStream stream=new ByteArrayOutputStream();
            dp_bitmap.compress(Bitmap.CompressFormat.PNG,100,stream);
            dp=stream.toByteArray();
            uploadDP.setVisibility(View.VISIBLE);
        }
    }
}
