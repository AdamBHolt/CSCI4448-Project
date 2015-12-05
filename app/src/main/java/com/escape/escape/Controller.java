package com.escape.escape;

/* imports */
import java.io.* ;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.view.View.OnClickListener;



public class Controller extends Activity implements OnTouchListener {
	private static Controller theController = null;
	void intialization(){
		Button bUp, bRight, bDown, bLeft;
		//do initialization graphics
		bUp.setId(1);
		bRight.setId(2);
		bDown.setId(3);
		bLeft.setId(4);
		MyTouchListener touchListener = new MyTouchListener();
		bUp.setOnTouchListener(touchListener);
		bRight.setOnTouchListener(touchListener);
		bDown.setOnTouchListener(touchListener);
		bLeft.setOnTouchListener(touchListener);
	 }

	/* Controller */
	@Override
    public boolean onTouch(View v, MotionEvent event) {
        switch(v.getId()){
            case 1:
                Player.setYPos(Player.getYPos()+1);
                break;
            case 2:
                Player.setXPos(Player.getXPos()+1);
                break;
            case 3:
				Player.setYPos(Player.getYPos()-1);
                break;
            case 4:
                Player.setXPos(Player.getYPos()-1);
                break;
        }
		return true;
	}
}
