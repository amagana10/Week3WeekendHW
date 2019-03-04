package com.example.navtest;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link OnFragment1InteractionListener} interface
 * to handle interaction events.
 * Use the {@link Frag1recyclerViewDisplay#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Frag1recyclerViewDisplay extends Fragment {
    RecyclerView recyclerView;
    MyRecyclerViewAdapter myRecyclerViewAdapter;
    EmployeeDBHelper employeeDBHelper;


    private OnFragment1InteractionListener mListener;

    public Frag1recyclerViewDisplay() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static Frag1recyclerViewDisplay newInstance() {
        Frag1recyclerViewDisplay fragment = new Frag1recyclerViewDisplay();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_frag1recycler_view_display, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.rvRecyclerView);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);

        employeeDBHelper = new EmployeeDBHelper(getContext());

        myRecyclerViewAdapter = new MyRecyclerViewAdapter(employeeDBHelper.getAllEmployeesFromDB());
        recyclerView.setAdapter(myRecyclerViewAdapter);
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragment1Interaction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragment1InteractionListener) {
            mListener = (OnFragment1InteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragment1InteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }


    public void refreshRecycler() {
        myRecyclerViewAdapter = new MyRecyclerViewAdapter(employeeDBHelper.getAllEmployeesFromDB());
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragment1InteractionListener {
        // TODO: Update argument type and name
        void onFragment1Interaction(Uri uri);
    }
}
