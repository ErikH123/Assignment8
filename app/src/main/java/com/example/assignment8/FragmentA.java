package com.example.assignment8;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import java.util.List;

public class FragmentA extends Fragment {
    private EditText editText;
    private Button button;
    private ViewModelProvider viewModelProvider;
    private TekstiViewModel tekstiViewModel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){
        View v = inflater.inflate(R.layout.fragment_a, container, false);

        editText = v.findViewById(R.id.editText);
        button = v.findViewById(R.id.button);
        viewModelProvider = new ViewModelProvider(getActivity());
        this.tekstiViewModel = viewModelProvider.get(TekstiViewModel.class);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Teksti teksti = new Teksti();
                teksti.setTeksti(editText.getText().toString());
                tekstiViewModel.insert(teksti);
                editText.setText("");
            }
        });
        return v;
    }

    @Override
    public void onAttach(Context context){
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }
}
