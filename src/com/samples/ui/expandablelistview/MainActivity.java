package com.samples.ui.expandablelistview;

import java.util.ArrayList;
import android.util.Log;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnChildClickListener;
import android.widget.ExpandableListView.OnGroupClickListener;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.TextView;


@SuppressWarnings("deprecation")
public class MainActivity extends Activity implements OnGroupClickListener,
		OnChildClickListener {
	private ArrayList<ContactGroup> list;
	private CustomAdapter adapter;
	private TextView textSelect;
	private int bigphoto;
	private int а;
	final String LOG_TAG = "myLogs";

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		ExpandableListView listView = (ExpandableListView) findViewById(R.id.expListView);
		listView.setSelected(true);
		textSelect = (TextView) findViewById(R.id.textSelect);

		initContacts();
		adapter = new CustomAdapter(this, list);
		listView.setAdapter(adapter);
		listView.setOnGroupClickListener(this);
		listView.setOnChildClickListener(this);
		
	}

	
	@Override
	public boolean onChildClick(ExpandableListView parent, View v,
			int groupPosition, int childPosition, long id) {
		
		Log.d(LOG_TAG, "Под группа: position = " + childPosition + ", id = "
	            + id);
		ContactItem item = adapter.getChild(groupPosition, childPosition);

		String text = String.format("Last opened contact:\n%s", item.getName());
		textSelect.setText(text);

		ContactItem.selectedItem = item;
		Intent intent = new Intent();
		intent.setClass(this, DetailsActivity.class);
		startActivity(intent);
		
		
		
		return false;
	}

	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	public boolean onGroupClick(ExpandableListView parent, View v,
			int groupPosition, long id) {
		Log.d(LOG_TAG, "группа: position = " + groupPosition + ", id = "
	            + id);
		return false;
	}

	private void initContacts() {
		list = new ArrayList<ContactGroup>();

		ContactGroup group = new ContactGroup(
				"Проверка оборотов холостого хода/ состава топливовоздушной смеси");
		group.addContact(new ContactItem(
				"Проверка и регулировка оборотов холостого хода", number,
				R.drawable.instrumert, about, j, R.drawable.a13));
		group.addContact(new ContactItem(
				"Проверка и регулировка угла опережения зажигания",
				"111", R.drawable.instrumert, about, j, R.drawable.kluch));
		group.addContact(new ContactItem(
				"Состав смеси на оборотах холостого хода", "222",
				R.drawable.instrumert, about, j, R.drawable.a13));
		list.add(group);

		group = new ContactGroup("Проверка компрессии");
		group.addContact(new ContactItem("Проверка компрессии", "876545644",
				R.drawable.instrumert, about, j, R.drawable.a13));
		list.add(group);

		group = new ContactGroup("Натяжение приводных ремней");
		group.addContact(new ContactItem("Проверка и регулировка", "876545644",
				R.drawable.instrumert, about, j, R.drawable.a13));
		list.add(group);

		group = new ContactGroup("Свечи зажигания");
		group.addContact(new ContactItem("Снятие и установка", "876545644",
				R.drawable.instrumert, about, j, R.drawable.a13));
		list.add(group);

		group = new ContactGroup("Моторное масло");
		group.addContact(new ContactItem(
				"Переодичность замены моторного масла", "876545644",
				R.drawable.instrumert, about, j, R.drawable.a13));
		group.addContact(new ContactItem("Проверка давления масла",
				"907868756", R.drawable.instrumert, about, j, R.drawable.a13));
		list.add(group);

		group = new ContactGroup("Масляный фильтр");
		group.addContact(new ContactItem(
				"Переодичность замены масляного фильтра", "876545644",
				R.drawable.instrumert, about, j, R.drawable.a13));
		group.addContact(new ContactItem("Снятие и установка", "907868756",
				R.drawable.instrumert, about, j, R.drawable.a13));
		list.add(group);

		group = new ContactGroup("Топливный фильтр");
		group.addContact(new ContactItem("Снятие и установка", "876545644",
				R.drawable.instrumert, about, j, R.drawable.a13));
		list.add(group);

		group = new ContactGroup("Охлаждающая жидкость");
		group.addContact(new ContactItem("Сливание ОЖ", "876545644",
				R.drawable.instrumert, about, j, R.drawable.a13));
		group.addContact(new ContactItem("Заливание ОЖ", "907868756",
				R.drawable.instrumert, about, j, R.drawable.a13));
		list.add(group);

		group = new ContactGroup("Механическая часть двигателя");
		group.addContact(new ContactItem("Воздухоочиститель и воздуховод",
				"876545644", R.drawable.instrumert, about, j, R.drawable.a13));
		group.addContact(new ContactItem("Снятие", "907868756", R.drawable.a12,
				about, R.string.vf2025, R.drawable.a13));
		group.addContact(new ContactItem("Проверка", "687699693",
				R.drawable.instrumert, about, j, R.drawable.a13));
		group.addContact(new ContactItem("Установка", "965467575",
				R.drawable.instrumert, about, j, R.drawable.a13));
		list.add(group);

		group = new ContactGroup("Промежуточный охладитель (RB25DET)");
		group.addContact(new ContactItem("Снятие", "876545644",
				R.drawable.instrumert, about, j, R.drawable.a13));
		group.addContact(new ContactItem("Проверка, клапан рецеркуляции",
				"907868756", R.drawable.instrumert, about, j, R.drawable.a13));
		group.addContact(new ContactItem("Установка", "687699693",
				R.drawable.instrumert, about, j, R.drawable.a13));
		list.add(group);

		group = new ContactGroup("Промежуточный охладитель (RB26DETT)");
		group.addContact(new ContactItem("Снятие", "876545644",
				R.drawable.instrumert, about, j, R.drawable.a13));
		group.addContact(new ContactItem("Проверка, клапан рецеркуляции",
				"907868756", R.drawable.instrumert, about, j, R.drawable.a13));
		group.addContact(new ContactItem("Установка", "687699693",
				R.drawable.instrumert, about, j, R.drawable.a13));
		list.add(group);

		group = new ContactGroup("Впускной коллектор (RB20E)");
		group.addContact(new ContactItem("Снятие", "876545644",
				R.drawable.instrumert, about, j, R.drawable.a13));
		group.addContact(new ContactItem(
				"Проверка,коробление впускного коллектора", "907868756",
				R.drawable.instrumert, about, j, R.drawable.a13));
		group.addContact(new ContactItem("Установка", "687699693",
				R.drawable.instrumert, about, j, R.drawable.a13));
		group.addContact(new ContactItem("Разборка", "965467575",
				R.drawable.instrumert, about, j, R.drawable.a13));
		group.addContact(new ContactItem("Сборка", "907865645",
				R.drawable.instrumert, about, j, R.drawable.a13));
		list.add(group);

		group = new ContactGroup("Впускной коллектор (RB25DE/rb250et)");
		group.addContact(new ContactItem("Снятие", "876545644",
				R.drawable.instrumert, about, j, R.drawable.a13));
		group.addContact(new ContactItem(
				"Проверка,коробление впускного коллектора", "907868756",
				R.drawable.instrumert, about, j, R.drawable.a13));
		group.addContact(new ContactItem("Установка", "687699693",
				R.drawable.instrumert, about, j, R.drawable.a13));
		group.addContact(new ContactItem("Разборка", "965467575",
				R.drawable.instrumert, about, j, R.drawable.a13));
		group.addContact(new ContactItem("Сборка", "907865645",
				R.drawable.instrumert, about, j, R.drawable.a13));
		list.add(group);

		group = new ContactGroup("Впускной коллектор (RB26DETT)");
		group.addContact(new ContactItem("Снятие", "876545644",
				R.drawable.instrumert, about, j, R.drawable.a13));
		group.addContact(new ContactItem(
				"Проверка,коробление впускного коллектора", "907868756",
				R.drawable.instrumert, about, j, R.drawable.a13));
		group.addContact(new ContactItem("Установка", "687699693",
				R.drawable.instrumert, about, j, R.drawable.a13));
		group.addContact(new ContactItem("Разборка", "965467575",
				R.drawable.instrumert, about, j, R.drawable.a13));
		group.addContact(new ContactItem("Сборка", "907865645",
				R.drawable.instrumert, about, j, R.drawable.a13));
		list.add(group);

		group = new ContactGroup("Труба впускного коллектора (RB20E)");
		group.addContact(new ContactItem("Снятие", "876545644",
				R.drawable.instrumert, about, j, R.drawable.a13));
		group.addContact(new ContactItem(
				"Проверка,коробление впускного коллектора", "907868756",
				R.drawable.instrumert, about, j, R.drawable.a13));
		group.addContact(new ContactItem("Установка", "687699693",
				R.drawable.instrumert, about, j, R.drawable.a13));
		group.addContact(new ContactItem("Разборка", "965467575",
				R.drawable.instrumert, about, j, R.drawable.a13));
		group.addContact(new ContactItem("Сборка", "907865645",
				R.drawable.instrumert, about, j, R.drawable.a13));
		list.add(group);

		group = new ContactGroup("Труба впускного коллектора (RB25DE/RB25DET)");
		group.addContact(new ContactItem("Снятие", "876545644",
				R.drawable.instrumert, about, j, R.drawable.a13));
		group.addContact(new ContactItem(
				"Проверка,коробление впускного коллектора", "907868756",
				R.drawable.instrumert, about, j, R.drawable.a13));
		group.addContact(new ContactItem("Установка", "687699693",
				R.drawable.instrumert, about, j, R.drawable.a13));
		group.addContact(new ContactItem("Разборка", "965467575",
				R.drawable.instrumert, about, j, R.drawable.a13));
		group.addContact(new ContactItem("Сборка", "907865645",
				R.drawable.instrumert, about, j, R.drawable.a13));
		list.add(group);

		group = new ContactGroup("Труба впускного коллектора (RB26DETT)");
		group.addContact(new ContactItem("Снятие", "876545644",
				R.drawable.instrumert, about, j, R.drawable.a13));
		group.addContact(new ContactItem(
				"Проверка,коробление впускного коллектора", "907868756",
				R.drawable.instrumert, about, j, R.drawable.a13));
		group.addContact(new ContactItem("Установка", "687699693",
				R.drawable.instrumert, about, j, R.drawable.a13));
		group.addContact(new ContactItem("Разборка", "965467575",
				R.drawable.instrumert, about, j, R.drawable.a13));
		group.addContact(new ContactItem("Сборка", "907865645",
				R.drawable.instrumert, about, j, R.drawable.a13));
		list.add(group);

		group = new ContactGroup("Топливные форсунки (RB20E)");
		group.addContact(new ContactItem("Снятие и установка", "876545644",
				R.drawable.instrumert, ab, j, R.drawable.a13));
		list.add(group);

		group = new ContactGroup("Топливные форсунки (RB25DE/RB25DET)");
		group.addContact(new ContactItem("Снятие", "876545644",
				R.drawable.instrumert, about, j, R.drawable.a13));
		group.addContact(new ContactItem("Проверка", "907868756",
				R.drawable.instrumert, about, j, R.drawable.a13));
		group.addContact(new ContactItem("Установка", "687699693",
				R.drawable.instrumert, about, j, R.drawable.a13));
		list.add(group);

		group = new ContactGroup("Топливные форсунки (RB26DETT)");
		group.addContact(new ContactItem("Снятие", "876545644",
				R.drawable.instrumert, about, j, R.drawable.a13));
		group.addContact(new ContactItem("Проверка", "907868756",
				R.drawable.instrumert, about, j, R.drawable.a13));
		group.addContact(new ContactItem("Установка", "687699693",
				R.drawable.instrumert, about, j, R.drawable.a13));
		list.add(group);

		group = new ContactGroup("Выпускной коллектор (RB20E)");
		group.addContact(new ContactItem("Снятие", "876545644",
				R.drawable.instrumert, about, j, R.drawable.a13));
		group.addContact(new ContactItem("Проверка", "907868756",
				R.drawable.instrumert, about, j, R.drawable.a13));
		group.addContact(new ContactItem("Установка", "687699693",
				R.drawable.instrumert, about, j, R.drawable.a13));
		list.add(group);

		group = new ContactGroup("Выпускной коллектор (RB25DE/RB25DET)");
		group.addContact(new ContactItem("Снятие", "876545644",
				R.drawable.instrumert, about, j, R.drawable.a13));
		group.addContact(new ContactItem("Проверка", "907868756",
				R.drawable.instrumert, about, j, R.drawable.a13));
		group.addContact(new ContactItem("Установка", "687699693",
				R.drawable.instrumert, about, j, R.drawable.a13));
		list.add(group);

		group = new ContactGroup("Турбонагнетатель (RB25DET)");
		group.addContact(new ContactItem("Снятие", "876545644",
				R.drawable.instrumert, about, j, R.drawable.a13));
		group.addContact(new ContactItem("Проверка", "907868756",
				R.drawable.instrumert, about, j, R.drawable.a13));
		group.addContact(new ContactItem("Установка", "687699693",
				R.drawable.instrumert, about, j, R.drawable.a13));
		list.add(group);

		group = new ContactGroup(
				"Выпускной коллектор/турбонагнетатель (RB26DETT)");
		group.addContact(new ContactItem("Снятие", "876545644",
				R.drawable.instrumert, about, j, R.drawable.a13));
		group.addContact(new ContactItem("Проверка", "907868756",
				R.drawable.instrumert, about, j, R.drawable.a13));
		group.addContact(new ContactItem("Установка", "687699693",
				R.drawable.instrumert, about, j, R.drawable.a13));
		group.addContact(new ContactItem("Разборка", "965467575",
				R.drawable.instrumert, about, j, R.drawable.a13));
		group.addContact(new ContactItem("Проверка турбонагнетателя",
				"907865645", R.drawable.instrumert, about, j, R.drawable.a13));
		group.addContact(new ContactItem("Люфт оси вращения", "896874556",
				R.drawable.instrumert, about, j, R.drawable.a13));
		group.addContact(new ContactItem("Сборка", "896874556",
				R.drawable.instrumert, about, j, R.drawable.a13));
		list.add(group);

		group = new ContactGroup(
				"Масляный поддон и масляный фильтр (RB20E/RB25DE/RB25DET)");
		group.addContact(new ContactItem("Снятие", "876545644",
				R.drawable.instrumert, about, j, R.drawable.a13));
		group.addContact(new ContactItem("Проверка", "907868756",
				R.drawable.instrumert, about, j, R.drawable.a13));
		group.addContact(new ContactItem("Установка", "687699693",
				R.drawable.instrumert, about, j, R.drawable.a13));
		list.add(group);

		group = new ContactGroup("Масляный поддон и масляный фильтр (RB26DETT)");
		group.addContact(new ContactItem("Снятиеи и установка", "876545644",
				R.drawable.instrumert, about, j, R.drawable.a13));
		list.add(group);

		group = new ContactGroup("Клапанная крышка (RB20E)");
		group.addContact(new ContactItem("Снятие", "876545644",
				R.drawable.instrumert, about, j, R.drawable.a13));
		list.add(group);

		group = new ContactGroup("Ось клапанных коромысел (RB20E)");
		group.addContact(new ContactItem("Проверка", "876545644",
				R.drawable.instrumert, about, j, R.drawable.a13));
		group.addContact(new ContactItem("Установка", "907868756",
				R.drawable.instrumert, about, j, R.drawable.a13));
		group.addContact(new ContactItem("Снятие", "687699693",
				R.drawable.instrumert, about, j, R.drawable.a13));
		group.addContact(new ContactItem("Визуальная проверка и зазоры",
				"965467575", R.drawable.instrumert, about, j, R.drawable.a13));
		group.addContact(new ContactItem("Установка", "907865645",
				R.drawable.instrumert, about, j, R.drawable.a13));
		list.add(group);

		group = new ContactGroup("Клапанная крышка (RB25DE/RB25DET)");
		group.addContact(new ContactItem("Снятие", "876545644",
				R.drawable.instrumert, about, j, R.drawable.a13));
		group.addContact(new ContactItem("Проверка", "907868756",
				R.drawable.instrumert, about, j, R.drawable.a13));
		group.addContact(new ContactItem("Установка", "687699693",
				R.drawable.instrumert, about, j, R.drawable.a13));
		list.add(group);

		group = new ContactGroup("Клапанная крышка (RB26DETT)");
		group.addContact(new ContactItem("Снятие", "876545644",
				R.drawable.instrumert, about, j, R.drawable.a13));
		group.addContact(new ContactItem("Проверка", "907868756",
				R.drawable.instrumert, about, j, R.drawable.a13));
		group.addContact(new ContactItem("Установка", "687699693",
				R.drawable.instrumert, about, j, R.drawable.a13));
		list.add(group);

		group = new ContactGroup("Ремень грм");
		group.addContact(new ContactItem("Снятие", "876545644",
				R.drawable.instrumert, about, j, R.drawable.a13));
		group.addContact(new ContactItem("Проверка", "907868756",
				R.drawable.instrumert, about, j, R.drawable.a13));
		group.addContact(new ContactItem("Установка", "687699693",
				R.drawable.instrumert, about, j, R.drawable.a13));
		list.add(group);

		group = new ContactGroup("Распредвалы");
		group.addContact(new ContactItem("Снятие(RB0E)", "876545644",
				R.drawable.instrumert, about, j, R.drawable.a13));
		group.addContact(new ContactItem("Снятие(RB25DE/RB25DET/RB26DETT)",
				"907868756", R.drawable.instrumert, about, j, R.drawable.a13));
		group.addContact(new ContactItem("Снятие(RB26DETT)", "687699693",
				R.drawable.instrumert, about, j, R.drawable.a13));
		group.addContact(new ContactItem("Проверка(RB0E/RB25DE/RB25DET)",
				"965467575", R.drawable.instrumert, about, j, R.drawable.a13));
		group.addContact(new ContactItem("Установка(RB0E)", "907865645",
				R.drawable.instrumert, about, j, R.drawable.a13));
		group.addContact(new ContactItem(
				"Установка(RB0E/RB25DE/RB25DET/RB26DETT)", "896874556",
				R.drawable.instrumert, about, j, R.drawable.a13));
		list.add(group);

		group = new ContactGroup("Клапанные зазоры (RB26DETT)");
		group.addContact(new ContactItem("Проверка", "876545644",
				R.drawable.instrumert, about, j, R.drawable.a13));
		group.addContact(new ContactItem("Снятие", "907868756",
				R.drawable.instrumert, about, j, R.drawable.a13));
		group.addContact(new ContactItem("Регулировка", "687699693",
				R.drawable.instrumert, about, j, R.drawable.a13));
		group.addContact(new ContactItem("Установка", "965467575",
				R.drawable.instrumert, about, j, R.drawable.a13));
		list.add(group);

		group = new ContactGroup("Прокладка головки цилиндров");
		group.addContact(new ContactItem("Снятие(RB0E)", "876545644",
				R.drawable.instrumert, about, j, R.drawable.a13));
		group.addContact(new ContactItem("Снятие(RB25DE/RB25DET)", "907868756",
				R.drawable.instrumert, about, j, R.drawable.a13));
		group.addContact(new ContactItem("Снятие(RB26DETT)", "687699693",
				R.drawable.instrumert, about, j, R.drawable.a13));
		group.addContact(new ContactItem("Проверка", "965467575",
				R.drawable.instrumert, about, j, R.drawable.a13));
		group.addContact(new ContactItem("Установка", "907865645",
				R.drawable.instrumert, about, j, R.drawable.a13));
		list.add(group);

		group = new ContactGroup("Головка цилиндров(RB26DETT)");
		group.addContact(new ContactItem("Снятие и установка", "876545644",
				R.drawable.instrumert, about, j, R.drawable.a13));
		group.addContact(new ContactItem("Разборка", "907868756",
				R.drawable.instrumert, about, j, R.drawable.a13));
		group.addContact(new ContactItem("Проверка", "687699693",
				R.drawable.instrumert, about, j, R.drawable.a13));
		group.addContact(new ContactItem("Сборка", "965467575",
				R.drawable.instrumert, about, j, R.drawable.a13));
		list.add(group);

		group = new ContactGroup("Блок цилиндров (RB26DETT)");
		group.addContact(new ContactItem("Разборка", "876545644",
				R.drawable.instrumert, about, j, R.drawable.a13));
		group.addContact(new ContactItem("Проверка зазоров", "907868756",
				R.drawable.instrumert, about, j, R.drawable.a13));
		group.addContact(new ContactItem("Проверка диаметров", "687699693",
				R.drawable.instrumert, about, j, R.drawable.a13));
		group.addContact(new ContactItem("Проверка состояния", "965467575",
				R.drawable.instrumert, about, j, R.drawable.a13));
		group.addContact(new ContactItem("Сборка", "907865645",
				R.drawable.instrumert, about, j, R.drawable.a13));
		list.add(group);

		group = new ContactGroup("Снятие и установка двигателя (RB20E)");
		group.addContact(new ContactItem("Снятие", "876545644",
				R.drawable.instrumert, about, j, R.drawable.a13));
		group.addContact(new ContactItem("Проверка", "907868756",
				R.drawable.instrumert, about, j, R.drawable.a13));
		group.addContact(new ContactItem("Установка", "687699693",
				R.drawable.instrumert, about, j, R.drawable.a13));
		list.add(group);

		group = new ContactGroup(
				"Снятие и установка двигателя (RB25DE&RB25DET)");
		group.addContact(new ContactItem("Снятие", "876545644",
				R.drawable.instrumert, about, j, R.drawable.a13));
		group.addContact(new ContactItem("Проверка2", "907868756",
				R.drawable.instrumert, about, j, R.drawable.a13));
		group.addContact(new ContactItem("Установка3", "687699693",
				R.drawable.instrumert, about, j, R.drawable.a13));
		list.add(group);

		group = new ContactGroup("Снятие и установка двигателя (RB26DETT)");
		group.addContact(new ContactItem("Снятие", "876545644",
				R.drawable.instrumert, about, j, R.drawable.a13));
		group.addContact(new ContactItem("Проверка", "907868756",
				R.drawable.instrumert, about, j, R.drawable.a13));
		group.addContact(new ContactItem("Установка", "687699693",
				R.drawable.instrumert, about, j, R.drawable.a13));
		list.add(group);

		group = new ContactGroup("Масляный насос");
		group.addContact(new ContactItem("Снятие", "876545644",
				R.drawable.instrumert, about, j, R.drawable.a13));
		group.addContact(new ContactItem("Проверка", "907868756",
				R.drawable.instrumert, about, j, R.drawable.a13));
		group.addContact(new ContactItem("Установка", "687699693",
				R.drawable.instrumert, about, j, R.drawable.a13));
		group.addContact(new ContactItem("Разборка", "965467575",
				R.drawable.instrumert, about, j, R.drawable.a13));
		group.addContact(new ContactItem("Сборка", "907865645",
				R.drawable.instrumert, about, j, R.drawable.a13));
		list.add(group);

		group = new ContactGroup(
				"Кронштеин масляного фильтра и масляный радиатор с водяным охлаждением(RB26DETT)");
		group.addContact(new ContactItem("Снятие", "876545644",
				R.drawable.instrumert, about, j, R.drawable.a13));
		group.addContact(new ContactItem("Проверка", "907868756",
				R.drawable.instrumert, about, j, R.drawable.a13));
		group.addContact(new ContactItem("Установка", "687699693",
				R.drawable.instrumert, about, j, R.drawable.a13));
		list.add(group);

		group = new ContactGroup("Кронштеин масляного фильтра(комплектация n1)");
		group.addContact(new ContactItem("Снятие", "876545644",
				R.drawable.instrumert, about, j, R.drawable.a13));
		group.addContact(new ContactItem("Проверка", "907868756",
				R.drawable.instrumert, about, j, R.drawable.a13));
		group.addContact(new ContactItem("Установка", "687699693",
				R.drawable.instrumert, about, j, R.drawable.a13));
		list.add(group);

		group = new ContactGroup(
				"Масляный радиатор с воздушным охлаждением (комплектация n1)");
		group.addContact(new ContactItem("Снятие", "876545644",
				R.drawable.instrumert, about, j, R.drawable.a13));
		group.addContact(new ContactItem("Проверка", "907868756",
				R.drawable.instrumert, about, j, R.drawable.a13));
		group.addContact(new ContactItem("Установка", "687699693",
				R.drawable.instrumert, about, j, R.drawable.a13));
		list.add(group);

		group = new ContactGroup("Радиатор");
		group.addContact(new ContactItem("Снятие", "876545644",
				R.drawable.instrumert, about, j, R.drawable.a13));
		group.addContact(new ContactItem("Проверка", "907868756",
				R.drawable.instrumert, about, j, R.drawable.a13));
		group.addContact(new ContactItem("Установка3", "687699693",
				R.drawable.instrumert, about, j, R.drawable.a13));
		list.add(group);

		group = new ContactGroup("Вентилятор охлаждения");
		group.addContact(new ContactItem("Снятие", "876545644",
				R.drawable.instrumert, about, j, R.drawable.a13));
		group.addContact(new ContactItem("Проверка", "907868756",
				R.drawable.instrumert, about, j, R.drawable.a13));
		group.addContact(new ContactItem("Установка", "687699693",
				R.drawable.instrumert, about, j, R.drawable.a13));
		list.add(group);

		group = new ContactGroup("Дополнительный винтелятор с электроприводом");
		group.addContact(new ContactItem("Снятие и установка", "876545644",
				R.drawable.instrumert, about, j, R.drawable.a13));
		list.add(group);

		group = new ContactGroup("Водяной насос");
		group.addContact(new ContactItem("Снятие", "876545644",
				R.drawable.instrumert, about, j, R.drawable.a13));
		group.addContact(new ContactItem("Проверка", "907868756",
				R.drawable.instrumert, about, j, R.drawable.a13));
		group.addContact(new ContactItem("Установка", "687699693",
				R.drawable.instrumert, about, j, R.drawable.a13));
		list.add(group);

		group = new ContactGroup("Термостат и водовпускной патрубок");
		group.addContact(new ContactItem("Снятие", "876545644",
				R.drawable.instrumert, about, j, R.drawable.a13));
		group.addContact(new ContactItem("Проверка", "907868756",
				R.drawable.instrumert, about, j, R.drawable.a13));
		group.addContact(new ContactItem("Установка", "687699693",
				R.drawable.instrumert, about, j, R.drawable.a13));
		list.add(group);

		group = new ContactGroup("Устройство системы");
		group.addContact(new ContactItem("RB20E", "876545644",
				R.drawable.instrumert, about, j, R.drawable.a13));
		group.addContact(new ContactItem("RB25DE", "907868756",
				R.drawable.instrumert, about, j, R.drawable.a13));
		group.addContact(new ContactItem("RB25DET", "687699693",
				R.drawable.instrumert, about, j, R.drawable.a13));
		group.addContact(new ContactItem("RB26DETT", "965467575",
				R.drawable.instrumert, about, j, R.drawable.a13));
		list.add(group);

		group = new ContactGroup("Электрическаясхема");
		group.addContact(new ContactItem(
				"RB20E Расположение и назначение контактов блока управления",
				"876545644", R.drawable.instrumert, about, j, R.drawable.a13));
		group.addContact(new ContactItem(
				"RB25DE/RB25DET Расположение и назначение контактов блока управления",
				"907868756", R.drawable.instrumert, about, j, R.drawable.a13));
		group.addContact(new ContactItem(
				"RB26DETT Расположение и назначение контактов блока управления",
				"687699693", R.drawable.instrumert, about, j, R.drawable.a13));
		list.add(group);

		group = new ContactGroup("Диагностика по признакам неисправности");
		group.addContact(new ContactItem(
				"Двигатель не запускаеться(нет первоначальногосгорания топлива)",
				"876545644", R.drawable.instrumert, about, j, R.drawable.a13));
		group.addContact(new ContactItem(
				"Двигатель запускаеться с трудом(Затруднен запуск холодного двигателя)",
				"907868756", R.drawable.instrumert, about, j, R.drawable.a13));
		group.addContact(new ContactItem(
				"Двигатель запускаеться с трудом(Затруднен запуск прогретого двигателя)",
				"687699693", R.drawable.instrumert, about, j, R.drawable.a13));
		group.addContact(new ContactItem(
				"Двигатель запускаеться с трудом(Затруднен запуск холодного и прогретого двигателя)",
				"965467575", R.drawable.instrumert, about, j, R.drawable.a13));
		group.addContact(new ContactItem("Снижены обороты холостого хода",
				"907865645", R.drawable.instrumert, about, j, R.drawable.a13));
		group.addContact(new ContactItem(
				"Низкие обороты холостого хода(На прогретом двигателе)",
				"896874556", R.drawable.instrumert, about, j, R.drawable.a13));
		group.addContact(new ContactItem(
				"Высокие обороты холостого хода(На прогретом двигателе)",
				"896874556", R.drawable.instrumert, about, j, R.drawable.a13));
		group.addContact(new ContactItem(
				"Неустойчивые обороты холостого хода(На холодном двигателе)",
				"896874556", R.drawable.instrumert, about, j, R.drawable.a13));
		group.addContact(new ContactItem(
				"Неустойчивые обороты холостого хода(На прогретом двигателе)",
				"896874556", R.drawable.instrumert, about, j, R.drawable.a13));
		group.addContact(new ContactItem(
				"Снижение мощности двигателя(Всасывание постороннего воздуха)",
				"896874556", R.drawable.instrumert, about, j, R.drawable.a13));
		group.addContact(new ContactItem(
				"Снижение мощности двигателя(Детонация)", "896874556",
				R.drawable.instrumert, about, j, R.drawable.a13));
		group.addContact(new ContactItem(
				"Снижение мощности двигателя,плохая приемистость, слабая реакция на педаль акселератора ",
				"896874556", R.drawable.instrumert, about, j, R.drawable.a13));
		group.addContact(new ContactItem("Двигатель глохнет в начале движения",
				"896874556", R.drawable.instrumert, about, j, R.drawable.a13));
		group.addContact(new ContactItem(
				"Двигатель глохнет на холостых оборотах", "896874556",
				R.drawable.instrumert, about, j, R.drawable.a13));
		group.addContact(new ContactItem(
				"Двигатель глохнет при замедлении или остановки движения",
				"896874556", R.drawable.instrumert, about, j, R.drawable.a13));
		group.addContact(new ContactItem(
				"Двигатель глохнет после включения электрической нагрузки",
				"896874556", R.drawable.instrumert, about, j, R.drawable.a13));
		list.add(group);

		group = new ContactGroup("Система диагностики");
		group.addContact(new ContactItem(
				"Средства предупреждения о неисправности", "876545644",
				R.drawable.instrumert, about, j, R.drawable.a13));
		group.addContact(new ContactItem("Функция самодиагностики",
				"907868756", R.drawable.instrumert, about, j, R.drawable.a13));
		group.addContact(new ContactItem("Аварийный режим", "687699693",
				R.drawable.instrumert, about, j, R.drawable.a13));
		group.addContact(new ContactItem("Диагностический тестер CONSULT",
				"965467575", R.drawable.instrumert, about, j, R.drawable.a13));
		list.add(group);

		group = new ContactGroup("Основные проверки (RB20E/RB26DETT)");
		group.addContact(new ContactItem("Основные проверки (RB20E/RB26DETT)",
				"876545644", R.drawable.instrumert, about, j, R.drawable.a13));
		list.add(group);

		group = new ContactGroup("Основные проверки (RB25DE/RB25DET)");
		group.addContact(new ContactItem("Основные проверки (RB25DE/RB25DET)",
				"876545644", R.drawable.instrumert, about, j, R.drawable.a13));
		list.add(group);

		group = new ContactGroup("Входные/выходные сигналы на блоке управления");
		group.addContact(new ContactItem("1", "876545644",
				R.drawable.instrumert, about, j, R.drawable.a13));
		list.add(group);

		group = new ContactGroup("ECCS11");
		group.addContact(new ContactItem(
				"ОСЦИЛЛОГРАММЫ И ЭТАЛОННЫЕ НАПРЯЖЕНИЯ НА РАЗЪЕМЕ БЛОКА ECCS (ДВИГАТЕЛЬ RB20E)",
				"876545644", R.drawable.instrumert, about, j, R.drawable.a13));
		group.addContact(new ContactItem(
				"ОСЦИЛЛОГРАММЫ И ЭТАЛОННЫЕ НАПРЯЖЕНИЯ НА РАЗЪЕМЕ БЛОКА ECCS (ДВИГАТЕЛЬ RB25DE/RB25DET)",
				"907868756", R.drawable.instrumert, about, j, R.drawable.a13));
		group.addContact(new ContactItem(
				"ОСЦИЛЛОГРАММЫ И ЭТАЛОННЫЕ НАПРЯЖЕНИЯ НА РАЗЪЕМЕ БЛОКА ECCS (ДВИГАТЕЛЬ RB26DETT)",
				"687699693", R.drawable.instrumert, ab, j, R.drawable.a13));
		list.add(group);
	}

	public int getj() {
		return j;
	}

	private final int j = R.string.test;
	private final String ab = "ddsds";
	@SuppressWarnings("unused")
	private final String abou = "Текст 2";
	private final String about = new String("Текст ");
	private final String number = "321" + "\n" + "123";
}