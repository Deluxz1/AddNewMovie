package com.example.tjss.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class FragOne extends Fragment implements View.OnClickListener {

    private EditText edittitle;
    private EditText edityear;
    private EditText editgenre;
    private Button bt1;
    private View mRootView;
    private FragmentOneInterface mCallback;

    public static FragOne newInstance() {
        FragOne fragment = new FragOne();
        return fragment;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            mCallback = (FragmentOneInterface) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString()
                    + " must implement FragmentOneInterface");
        }
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mRootView = inflater.inflate(R.layout.fragone, container, false);
        editgenre = mRootView.findViewById(R.id.editgenre);
        edittitle = mRootView.findViewById(R.id.edittitle);
        edityear = mRootView.findViewById(R.id.edityear);
        bt1 = mRootView.findViewById(R.id.bt1);
        bt1.setOnClickListener(this);
        return mRootView; }

    public interface FragmentOneInterface {
        void sendNewMovie (Movie movie);

}

    @Override
    public void onClick(View view) {
        String sttitle = edittitle.getText().toString();
        String stgenre = editgenre.getText().toString();
        String styear = edityear.getText().toString();

        Movie movie = new Movie(sttitle, stgenre, styear);
        mCallback.sendNewMovie(movie);
    }


}
