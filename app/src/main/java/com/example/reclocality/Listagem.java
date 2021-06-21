package com.example.reclocality;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

public class Listagem extends AppCompatActivity {

    private ListView listView;
    private LocalDAO localDAO;
    private List<Local> lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listagem);

        listView = findViewById(R.id.listView);
        localDAO = new LocalDAO(this);
        lista = localDAO.retornarLista();

        ArrayAdapter<Local> adapter = new ArrayAdapter<Local>
                (this, android.R.layout.simple_list_item_1, lista);

        listView.setAdapter(adapter);
        registerForContextMenu(listView);
    }

    public void redirecionarMain(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void onCreateContextMenu(ContextMenu menu, View view, ContextMenu.ContextMenuInfo menuInfo){
        super.onCreateContextMenu(menu, view, menuInfo);
        MenuInflater i = getMenuInflater();
        i.inflate(R.menu.excluir, menu);
    }

    public void excluir(MenuItem item){
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();

        Local localExcluir = lista.get(info.position);
        lista.remove(localExcluir);
        localDAO.excluir(localExcluir);
        listView.invalidateViews();
    }
}