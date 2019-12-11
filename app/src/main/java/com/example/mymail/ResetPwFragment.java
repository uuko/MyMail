package com.example.mymail;

import android.animation.Animator;
import android.content.Context;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.transition.TransitionManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ResetPwFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ResetPwFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ResetPwFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private TextView goback;
    private Button reset;
    private EditText registeredemail;
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private FrameLayout parentFramelayout;
    private FirebaseAuth firebaseAuth;
    private ViewGroup emailcontainer;
    private ImageView emailicon;
    private TextView emailicontext;
    private ProgressBar progressBar;
    private OnFragmentInteractionListener mListener;

    public ResetPwFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ResetPwFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ResetPwFragment newInstance(String param1, String param2) {
        ResetPwFragment fragment = new ResetPwFragment();
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
        View view=inflater.inflate(R.layout.fragment_reset_pw, container, false);
        registeredemail=view.findViewById(R.id.forget_email);
        reset=view.findViewById(R.id.reset_pw);
        goback=view.findViewById(R.id.fogot_pw_goback);
        parentFramelayout=getActivity().findViewById(R.id.register_layout);
        firebaseAuth=FirebaseAuth.getInstance();
        emailcontainer=view.findViewById(R.id.fogot_pw_linear);
        emailicon=view.findViewById(R.id.fogot_email_icon);
        emailicontext=view.findViewById(R.id.forgot_email_ictext);
        progressBar=view.findViewById(R.id.forgot_pw_bar);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable final Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        registeredemail.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                checkintput();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        goback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setFragment(new SigninFragment());
            }
        });
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TransitionManager.beginDelayedTransition(emailcontainer);
                progressBar.setVisibility(View.VISIBLE);
                emailicontext.setVisibility(View.GONE);

                reset.setEnabled(false);
                reset.setTextColor(Color.argb(50,255,255,255));

                firebaseAuth.sendPasswordResetEmail(registeredemail.getText().toString())
                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                if (task.isSuccessful()){
                                    emailicontext.setVisibility(View.VISIBLE);
                                    emailicon.setVisibility(View.VISIBLE);
                                    emailicontext.setText("email send success");
                                    emailicontext.setTextColor(getResources().getColor(R.color.colorPrimary));
                                    TransitionManager.beginDelayedTransition(emailcontainer);
                                    Toast.makeText(getActivity(), "email send success", Toast.LENGTH_SHORT).show();
                                }else {
                                    String error=task.getException().getMessage();
                                    Log.d("444", "onComplete: ");
                                    progressBar.setVisibility(View.GONE);
                                    emailicontext.setVisibility(View.VISIBLE);
                                    emailicon.setVisibility(View.VISIBLE);
                                    emailicontext.setText(error);
                                    emailicontext.setTextColor(getResources().getColor(R.color.red));
                                    TransitionManager.beginDelayedTransition(emailcontainer);
//                                    Toast.makeText(getActivity(), error, Toast.LENGTH_SHORT).show();
                                }
                                progressBar.setVisibility(View.GONE);
                                reset.setEnabled(true);
                                reset.setTextColor(getResources().getColor(R.color.colorwh));
                            }
                        });
            }
        });
    }

    private void checkintput() {
        if (TextUtils.isEmpty(registeredemail.getText())){
            reset.setEnabled(false);
            reset.setTextColor(Color.argb(50,255,255,255));


        }else {
            reset.setEnabled(true);
            reset.setTextColor(getResources().getColor(R.color.colorwh));

        }
    }
    private void setFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction=getActivity().getSupportFragmentManager().beginTransaction();
        fragmentTransaction.setCustomAnimations(R.anim.slide_out_from_right,R.anim.slide_out_from_right);
        fragmentTransaction.replace(parentFramelayout.getId(),fragment);
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
