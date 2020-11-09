package com.pam.fragment_2500;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentKategori#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentKategori extends Fragment implements View.OnClickListener {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public FragmentKategori() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentKategori.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentKategori newInstance(String param1, String param2) {
        FragmentKategori fragment = new FragmentKategori();
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
        return inflater.inflate(R.layout.fragment_kategori, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Button btnSubKategori = view.findViewById(R.id.btn_sub_kategori);
        btnSubKategori.setOnClickListener(this);
    }

    public void onClick(View v) {
        if (v.getId() == R.id.btn_sub_kategori) {
            FragmentDetailKategori mFragmentDetailKategori = new FragmentDetailKategori();

            Bundle mBundle = new Bundle();
            mBundle.putString(FragmentDetailKategori.EXTRA_NAME, "ini dikirim dengan bundle ");
            String description = "Ini dikirim dengan getter setter";

            mFragmentDetailKategori.setArguments(mBundle);
            mFragmentDetailKategori.setDescription(description);

            FragmentManager mFragmentManager = getFragmentManager();
            if (mFragmentManager !=null) {
                mFragmentManager.beginTransaction().replace(R.id.frame_container,
                        mFragmentDetailKategori,
                        FragmentDetailKategori.class.getSimpleName())
                        .addToBackStack(null)
                        .commit();
            }
        }
    }
}