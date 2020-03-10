package com.example.assignment8;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import java.util.ArrayList;
import java.util.List;

public class FragmentB extends Fragment {
    private ListView listView;
    private ArrayList<Teksti> lista;
    private Adapteri adapteri;
    private Context mContext;
    private ViewModelProvider viewModelProvider;
    private TekstiViewModel tekstiViewModel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){
        View v = inflater.inflate(R.layout.fragment_b, container, false);

        lista = new ArrayList<>();

        listView = v.findViewById(R.id.listView);
        adapteri = new Adapteri(mContext, R.layout.teksti_layout, lista);
        listView.setAdapter(adapteri);

        viewModelProvider = new ViewModelProvider(getActivity());
        this.tekstiViewModel = viewModelProvider.get(TekstiViewModel.class);

        tekstiViewModel.getmAllTekstit().observe(getViewLifecycleOwner(), new Observer<List<Teksti>>() {
            @Override
            public void onChanged(List<Teksti> tekstit) {
                lista.clear();
                lista.addAll(tekstit);
                adapteri.notifyDataSetChanged();
            }
        });

        return v;
    }

    @Override
    public void onAttach(@NonNull Context context){
        super.onAttach(context);
        mContext = context;
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }
}
