package com.example.desafio;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link fragmentoCadastro#newInstance} factory method to
 * create an instance of this fragment.
 */
public class fragmentoCadastro extends Fragment {
    EditText campoNome, campoTipo, campoPreco;
    Button btn;
    ArrayList<Produto> listaProdutos = new ArrayList<>();

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public fragmentoCadastro() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment fragmentoCadastro.
     */
    // TODO: Rename and change types and number of parameters
    public static fragmentoCadastro newInstance(String param1, String param2) {
        fragmentoCadastro fragment = new fragmentoCadastro();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_fragmento_cadastro, container, false);
        fragmentoRecycler.listaProdutos = listaProdutos;
        campoNome = v.findViewById(R.id.campoNome);
        campoTipo = v.findViewById(R.id.campoTipo);
        campoPreco = v.findViewById(R.id.campoPreco);
        btn = v.findViewById(R.id.btnCadastrarProduto);

        btn.setOnClickListener(click -> {
            cadastrar();
        });
        return v;
    }

    public void cadastrar(){
        if(verificarCampos()){
            String infoNome = campoNome.getText().toString();
            String infoTipo = campoTipo.getText().toString();
            float infoPreco = Float.parseFloat(campoPreco.getText().toString());

            Produto p = new Produto (infoNome, infoTipo, infoPreco);
            listaProdutos.add(p);
            fragmentoRecycler.listaProdutos = listaProdutos;
            Toast.makeText(getContext(), "Produto adicionado", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getContext(), "Favor preencher todos os campos!", Toast.LENGTH_SHORT).show();
        }
    }

    public boolean verificarCampos(){
        if(campoNome.getText().toString().isEmpty() || campoTipo.getText().toString().isEmpty() || campoPreco.getText().toString().isEmpty()){
            return false;
        }
        return true;
    }
}