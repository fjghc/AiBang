package edu.jxsd.x3510.activity;

import java.util.Calendar;
import edu.jxsd.x3510.activity.R;
import edu.jxsd.x3510.activity.R.layout;
import edu.jxsd.x3510.activity.SendHelpMsgActivity.GListener;
import edu.jxsd.x3510.activity.SendHelpMsgActivity.PListener;

import android.R.integer;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.sip.SipAudioCall.Listener;
import android.os.Build;
import android.os.Bundle;
import android.text.StaticLayout;
import android.view.View;
import android.webkit.WebView.FindListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.app.DialogFragment;

@SuppressLint("NewApi")
@TargetApi(Build.VERSION_CODES.HONEYCOMB)
public class DialogType extends DialogFragment {
	public static final int SEX_TYPE = 0;
	public static final int SCHOOL_TYPE = 1;
	public static final int AGE_TYPE = 2;
	public static final int PICTURE_TYPE = 3;
	public static final int GIFT_TYPE = 4;
	public static int choice = 0;
	public static ImageView imageView= null;
	public String mSelectedItems = null;
	String sex = null;
	String school = null;
	String age = null;
	String picture = null;
	String gift = null;
	public static TextView view = null;
	
	public static DialogType newInstance(int c,TextView v) {
		DialogType myDialogFragmentSex = new DialogType();
		Bundle bundle = new Bundle();
		choice = c;
		myDialogFragmentSex.setArguments(bundle);
		view = v;
		return myDialogFragmentSex;
	}
	
	public Dialog onCreateDialog(Bundle savedInstanceState) {
		final String[]  sexType = getResources().getStringArray(R.array.sex_type);
		final String[]  schoolType = getResources().getStringArray(R.array.school_type);
		final String[]	ageType = getResources().getStringArray(R.array.age_type);
		final String[]  pictureType = getResources().getStringArray(R.array.picture_type);
		final String[]  giftType = getResources().getStringArray(R.array.gift_type);
 		AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
		Dialog dialog = null;
		int checkedItem = -1;
		switch (choice) {
		case SEX_TYPE:
			builder.setTitle("性别")
					.setSingleChoiceItems(R.array.sex_type, checkedItem,
							new DialogInterface.OnClickListener() {
								
								@Override
								public void onClick(DialogInterface dialog,
										int which) {
									sex = sexType[which];
								}
							})
					.setPositiveButton("OK",
							new DialogInterface.OnClickListener() {
								@Override
								public void onClick(DialogInterface dialog,
										int id) {
									view.setText(sex);
								}
							});
			break;
		case SCHOOL_TYPE:
	        builder.setTitle("学校")
	            .setSingleChoiceItems(R.array.school_type, checkedItem, new DialogInterface.OnClickListener() {
					
					@Override
					public void onClick(DialogInterface dialog, int which) {
						// TODO Auto-generated method stub
						school = schoolType[which];
					}
				})
	        // Set the action buttons
	               .setPositiveButton("OK", new DialogInterface.OnClickListener() {
	                   @Override
	                   public void onClick(DialogInterface dialog, int id) {
	                       // User clicked OK, so save the mSelectedItems results somewhere
	                       // or return them to the component that opened the dialog
	                	   view.setText(school);
	                   }
	               });
	        break;
		case AGE_TYPE:
			builder.setTitle("年龄")
	            .setItems(R.array.age_type, new DialogInterface.OnClickListener() {
					
					@Override
					public void onClick(DialogInterface dialog, int which) {
						// TODO Auto-generated method stub
						age = ageType[which];
						view.setText(age);
						
					}
				});
			break;
		/*case PICTURE_TYPE:
			final Intent intent = new Intent();
			builder.setTitle("�ϴ���ʽ")
			.setSingleChoiceItems(R.array.picture_type, checkedItem,new DialogInterface.OnClickListener(){

				@Override
				public void onClick(DialogInterface dialog, int which) {
					// TODO Auto-generated method stub
					picture = pictureType[which];
				}}).setPositiveButton("OK", new DialogInterface.OnClickListener() {
					
					@Override
					public void onClick(DialogInterface dialog, int id) {
						// TODO Auto-generated method stub
                         intent.setClass(getActivity(), LoginActivity.class);
                         startActivity(intent);
					}
				});
			break;*/
		case GIFT_TYPE:
			builder.setTitle("回赠ʽ")
			.setItems(R.array.gift_type, new DialogInterface.OnClickListener(){

				@Override
				public void onClick(DialogInterface dialog, int which) {
					// TODO Auto-generated method stub
					gift = giftType[which];
					view.setText(gift);
					view.setVisibility(View.VISIBLE);
				}});
			break;
		}
		
		 return builder.create();
	}
	public static DialogType newInstance(int c, ImageView iv ) {
		// TODO Auto-generated method stub
		DialogType myDialogFragmentPic = new DialogType();
		Bundle bundle = new Bundle();
		choice = c;
		myDialogFragmentPic.setArguments(bundle);
		imageView = iv;
		return myDialogFragmentPic;
	}
	
}
	
