package com.example.callapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.SimpleExpandableListAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import timber.log.Timber;

public class MainActivity extends Activity {

    // названия компаний (групп)
    String[] groups = new String[] {
            "Часть 1 - Идея, архитектура и игровой цикл ",
            "Часть 2 - Вывод рисунка на экран и его перемещения",
            "Часть 3 - Как добиться одинаковой скорости выполнения игры на разных телефонах",
            "Часть 4 - Спрайтовая анимация"};


    // названия телефонов (элементов)
    String[] gameone = new String[]
            {
                    "Вступительное слово",
                    "Идея и архитектура",
                    "Создаем проект-заготовку для будущей Android игры",
                    "Главный игровой цикл",
                    "Добавляем взаимодействие с экраном",
                    "Логирование"
            };
    String[] gametwo = new String[]
            {
                    "Вывод рисунка на экран",
                    "Перемещение изображения",
                    "Самостоятельное перемещение робота"};
    String[] gamethree = new String[]
            {
                    "Optimus",
                    "Optimus Link",
                    "Optimus Black",
                    "Optimus One"};
    String[] gamefour = new String[]
            {
                    "Optimus",
                    "Optimus Link",
                    "Optimus Black",
                    "Optimus One"};

    // коллекция для групп
    ArrayList<Map<String, String>> groupData;

    // коллекция для элементов одной группы
    ArrayList<Map<String, String>> childDataItem;

    // общая коллекция для коллекций элементов
    ArrayList<ArrayList<Map<String, String>>> childData;
    // в итоге получится childData = ArrayList<childDataItem>

    // список атрибутов группы или элемента
    Map<String, String> m;

    ExpandableListView elvMain;


    /** Called when the activity is first created. */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_main);

        // заполняем коллекцию групп из массива с названиями групп
        groupData = new ArrayList<>();
        for (String group : groups) {
            // заполняем список атрибутов для каждой группы
            m = new HashMap<>();
            m.put("groupName", group); // имя компании
            groupData.add(m);
        }

        // список атрибутов групп для чтения
        String[] groupFrom = new String[] {"groupName"};
        // список ID view-элементов, в которые будет помещены атрибуты групп
        int[] groupTo = new int[] {android.R.id.text1};



        // создаем коллекцию для коллекций элементов
        childData = new ArrayList<>();

        // создаем коллекцию элементов для первой группы
        childDataItem = new ArrayList<>();
        // заполняем список атрибутов для каждого элемента
        for (String game : gameone) {
            m = new HashMap<>();
            m.put("gameName", game); // название телефона
            childDataItem.add(m);
        }
        // добавляем в коллекцию коллекций
        childData.add(childDataItem);

        // создаем коллекцию элементов для второй группы
        childDataItem = new ArrayList<>();
        for (String game : gametwo) {
            m = new HashMap<>();
            m.put("gameName", game);
            childDataItem.add(m);
        }
        childData.add(childDataItem);

        // создаем коллекцию элементов для третьей группы
        childDataItem = new ArrayList<>();
        for (String game : gamethree) {
            m = new HashMap<>();
            m.put("gameName", game);
            childDataItem.add(m);
        }
        childData.add(childDataItem);
        // создаем коллекцию элементов для третьей группы
        childDataItem = new ArrayList<>();
        for (String game : gamefour) {
            m = new HashMap<>();
            m.put("gameName", game);
            childDataItem.add(m);
        }
        childData.add(childDataItem);

        // список атрибутов элементов для чтения
        String[] childFrom = new String[] {"gameName"};
        // список ID view-элементов, в которые будет помещены атрибуты элементов
        int[] childTo = new int[] {android.R.id.text1};

        SimpleExpandableListAdapter adapter = new SimpleExpandableListAdapter(
                this,
                groupData,
                android.R.layout.simple_expandable_list_item_1,
                groupFrom,
                groupTo,
                childData,
                android.R.layout.simple_list_item_1,
                childFrom,
                childTo);

        elvMain = (ExpandableListView) findViewById(R.id.elvMain);
        elvMain.setAdapter(adapter);

        elvMain.setOnChildClickListener((ExpandableListView parent, View v, int groupPosition, int childPosition, long id) -> {
            Timber.d("groupPosition: " + groupPosition + " childPosition: " + childPosition);
            return false;
        });
    }
}
