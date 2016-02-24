package com.example.geoquiz;

import android.R.integer;

//import android.R.bool;

public class TrueFalse {
	private int mQuestion;
//	private int mAnswer;
	
	private boolean mTrueQuestion;
//	private boolean mTrueAnswer;
	
	public TrueFalse(int question,boolean trueQuestion){
		mQuestion=question;
		mTrueQuestion=trueQuestion;
	}

	public int getQuestion() {
		return mQuestion;
	}

	public void setQuestion(int question) {
		mQuestion = question;
	}

	public boolean isTrueQuestion() {
		return mTrueQuestion;
	}

	public void setTrueQuestion(boolean trueQuestion) {
		mTrueQuestion = trueQuestion;
	}

}
