package com.samples.ui.expandablelistview;


import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class DetailsActivity extends Activity {
	private ImageView photo;
	private ImageView bigphoto;
	private TextView name;
	private TextView phone;
	private TextView about;
	private TextView j;
	private Gallery gallery;
	private ImageView imageView;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.details);
		
		gallery=(Gallery)findViewById(R.id.gallery1);
		imageView=(ImageView)findViewById(R.id.imageView1);
		gallery.setAdapter(new ImageAdapter(this));
		
		gallery.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> adapter, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				Toast.makeText(getApplicationContext(), position+"", Toast.LENGTH_SHORT).show();
				imageView.setImageResource(ImageAdapter.Thumbslbs[position]);
			}
		
		});
		
		photo = (ImageView)findViewById(R.id.detailsPhoto);
		bigphoto = (ImageView)findViewById(R.id.detailsBigPhoto);
		name = (TextView)findViewById(R.id.detailsName);
		phone = (TextView)findViewById(R.id.detailsPhone);
		about = (TextView)findViewById(R.id.detailsAbout);
		j = (TextView)findViewById(R.id.detailsj);

		ContactItem item = ContactItem.selectedItem;
		photo.setImageResource(item.getPhotoID());
		bigphoto.setImageResource(item.getbigphoto());
		name.setText(item.getName());
		phone.setText(item.getPhone());
		about.setText(item.getAbout());
		j.setText(item.getj());
	}
}
