package com.example.geoquiz;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CheatActivity extends Activity {

    private static final String TAG = "CheatActivity";
    public static final String EXTRA_ANSWER_IS_TRUE = "com.example.geoquiz.answer_is_true";
    public static final String EXTRA_ANSWER_SHOWN = "com.example.geoquiz.answer_shown";
    
    private final String KEY_IS_CHEAT="isCheat";
    
    private Boolean mIsCheat;
    
    private Boolean mAnswerIsTrue;

    private TextView mAnswerTextView;
    private Button mShowAnswer;
    
    private static final String KEY_INDXE="answer_index";

    private Boolean mCurrentAnswerIndex=false;
    
    private void setAnswerShownResult(boolean isAnswerShown) {
        Intent data = new Intent();
        data.putExtra(EXTRA_ANSWER_SHOWN, isAnswerShown);
        setResult(RESULT_OK, data);
    }
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate() called");
        setContentView(R.layout.activity_cheat);

        if (savedInstanceState == null) {
            // first startup, so the answer must not
            // be shown yet
            setAnswerShownResult(false);
        }

        mAnswerIsTrue = getIntent().getBooleanExtra(EXTRA_ANSWER_IS_TRUE, false);

        mAnswerTextView = (TextView)findViewById(R.id.answerTextView);

        mShowAnswer = (Button)findViewById(R.id.ShowAnswerButton);
        mShowAnswer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mAnswerIsTrue) {
                    mAnswerTextView.setText(R.string.true_button);
                } else {
                    mAnswerTextView.setText(R.string.false_button);
                }
                setAnswerShownResult(true);
            }
        });
        
        if (savedInstanceState!=null
        		&& savedInstanceState.getBoolean(KEY_IS_CHEAT)){
        	
        	if(mAnswerIsTrue){
        		mAnswerTextView.setText(R.string.true_button);
        	}else{
        		mAnswerTextView.setText(R.string.false_button);
        	}
        	
        	setAnswerShownResult(true);
        	mIsCheat=true;
        	//mCurrentAnswerIndex=savedInstanceState.getBoolean(EXTRA_ANSWER_IS_TRUE);
        }
        
    }
    

    
    
    @Override
    public void onSaveInstanceState(Bundle savedInstanceState){
    	super.onSaveInstanceState(savedInstanceState);
    	Log.i(TAG,"onSaveInstanceState");
    	//savedInstanceState.putBoolean(EXTRA_ANSWER_IS_TRUE,mCurrentAnswerIndex);
    	savedInstanceState.putBoolean(KEY_IS_CHEAT,mIsCheat);
    }

}
