package com.ampaschal.soilinfo.ui;

import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;

import com.ampaschal.soilinfo.R;
import com.ampaschal.soilinfo.databinding.FragmentCompareDataBottomDialogBinding;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CompareDataBottomDialogFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CompareDataBottomDialogFragment extends BottomSheetDialogFragment {

    CardView searchImage;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public CompareDataBottomDialogFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CompareDataFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CompareDataBottomDialogFragment newInstance(String param1, String param2) {
        CompareDataBottomDialogFragment fragment = new CompareDataBottomDialogFragment();
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
        final FragmentCompareDataBottomDialogBinding compareDataBottomDialogBinding =
                FragmentCompareDataBottomDialogBinding.inflate(inflater, container, false);

        searchImage = compareDataBottomDialogBinding.imageSearch;
        searchImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                compareDataBottomDialogBinding.imageSearch.setVisibility(View.INVISIBLE);
                compareDataBottomDialogBinding.tvCompareTitle.setVisibility(View.INVISIBLE);
                compareDataBottomDialogBinding.etSearch.setVisibility(View.VISIBLE);
            }
        });

        return compareDataBottomDialogBinding.getRoot();
    }
}