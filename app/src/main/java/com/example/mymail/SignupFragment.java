package com.example.mymail;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ComponentActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link SignupFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link SignupFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SignupFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;
    private TextView alreadyhave;
    private FrameLayout parentFramlayout;
    private EditText email;
    private  EditText fullname;
    private EditText pw;
    private  EditText checkedpw;

    private Button signup,close;
    private ProgressBar progressBar;
    private FirebaseAuth firebaseAuth;
    private FirebaseFirestore firebaseFirestore;
    private String emailpattern="(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:(2(5[0-5]|[0-4][0-9])|1[0-9][0-9]|[1-9]?[0-9]))\\.){3}(?:(2(5[0-5]|[0-4][0-9])|1[0-9][0-9]|[1-9]?[0-9])|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])";
    public SignupFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SignupFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SignupFragment newInstance(String param1, String param2) {
        SignupFragment fragment = new SignupFragment();
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
        View view=inflater.inflate(R.layout.fragment_signup, container, false);
        alreadyhave=view.findViewById(R.id.already_have_account);
        parentFramlayout=getActivity().findViewById(R.id.register_layout);
        email=view.findViewById(R.id.edit_email);
        fullname=view.findViewById(R.id.edit_name);
        pw=view.findViewById(R.id.edit_email_pw);
        checkedpw=view.findViewById(R.id.check_pw);
        close=view.findViewById(R.id.sign_in_del);
        signup=view.findViewById(R.id.sign_up);
        progressBar=view.findViewById(R.id.sign_up_progress);
        firebaseAuth =FirebaseAuth.getInstance();
        firebaseFirestore=FirebaseFirestore.getInstance();
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        alreadyhave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setFragment(new SigninFragment());
            }
        });
        email.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                Log.d("ff", "onTextChanged: ");
                checkInputs();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        fullname.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                    checkInputs();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        pw.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                checkInputs();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        checkedpw.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                checkInputs();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkEmailandpw();
            }
        });
    }

    private void checkEmailandpw() {
        if (email.getText().toString().matches(emailpattern)){
            if (pw.getText().toString().equals(checkedpw.getText().toString())){
                progressBar.setVisibility(View.VISIBLE);
                signup.setEnabled(false);
                signup.setTextColor(Color.argb(50,255,255,255));
                firebaseAuth.createUserWithEmailAndPassword(email.getText().toString(),pw.getText().toString())
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()){
                                Map<Object,String> userdata=new HashMap<>();
                                userdata.put("fullname",fullname.getText().toString());
                                firebaseFirestore.collection("USERS")
                                        .add(userdata)
                                        .addOnCompleteListener(new OnCompleteListener<DocumentReference>() {
                                            @Override
                                            public void onComplete(@NonNull Task<DocumentReference> task) {
                                                    if (task.isSuccessful()){
                                                        Log.d("111", "onComplete: ");
                                                        Intent mainIntent=new Intent(getActivity(),MainActivity.class);
                                                        startActivity(mainIntent);
                                                        getActivity().finish();
                                                    }
                                                    else {
                                                        Log.d("111", "onComplete:wwwww ");
                                                        progressBar.setVisibility(View.INVISIBLE);
                                                        signup.setEnabled(true);
                                                        signup.setTextColor(getResources().getColor(R.color.colorwh));
                                                        String error=task.getException().getMessage();
                                                        Log.d("111", "onComplete: "+error);
                                                        Toast.makeText(getActivity(),error,Toast.LENGTH_SHORT).show();
                                                    }
                                            }
                                        });

                            }else {
                                Log.d("111", "onComplete:wwwww ");
                                progressBar.setVisibility(View.INVISIBLE);
                                signup.setEnabled(true);
                                signup.setTextColor(getResources().getColor(R.color.colorwh));
                                String error=task.getException().getMessage();
                                Log.d("111", "onComplete: "+error);
                                Toast.makeText(getActivity(),error,Toast.LENGTH_SHORT).show();
                            }
                    }
                }) ;
            }else {
                checkedpw.setError("pw not match");
            }
        }else {
            Log.d("111", "checkEmailandpw: ");
            email.setError("Invalid pattern");
        }
    }

    private void checkInputs() {
        if (!TextUtils.isEmpty(email.getText())){
            if (!TextUtils.isEmpty(fullname.getText())){
                if (!TextUtils.isEmpty(pw.getText()) && pw.length()>=0){
                    if (!TextUtils.isEmpty(checkedpw.getText())){
                        signup.setEnabled(true);
                        signup.setTextColor(getResources().getColor(R.color.colorwh));
                    }else {
                        signup.setEnabled(false);
                        signup.setTextColor(Color.argb(50,255,255,255));
                    }
                }else {
                    signup.setEnabled(false);
                    signup.setTextColor(Color.argb(50,255,255,255));
                }
            }else {
                signup.setEnabled(false);
                signup.setTextColor(Color.argb(50,255,255,255));
            }
        }else {
            signup.setEnabled(false);
            signup.setTextColor(Color.argb(50,255,255,255));
        }
    }

    private void setFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction=getActivity().getSupportFragmentManager().beginTransaction();
        fragmentTransaction.setCustomAnimations(R.anim.slide_from_left,R.anim.slide_from_left);
        fragmentTransaction.replace(parentFramlayout.getId(),fragment);
        fragmentTransaction.commit();

    }
    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }



    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
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
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
