package com.kh.chap04.run;

import com.kh.chap04.controller.FieldController;
import com.kh.chap04.view.FiledView;

public class Run {

	public static void main(String[] args) {
		
		System.out.println(FieldController.str);
		
		new FiledView().check();

	}

}
