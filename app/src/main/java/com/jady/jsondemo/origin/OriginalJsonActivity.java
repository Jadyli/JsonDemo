package com.jady.jsondemo.origin;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.jady.jsondemo.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONStringer;
import org.json.JSONTokener;

public class OriginalJsonActivity extends AppCompatActivity implements View.OnClickListener {


    private TextView mTvOriginalJsonStr;
    /**
     * parse json string
     */
    private Button mBtnOriginalParseByJsonobject;
    /**
     * no content
     */
    private TextView mTvOriginalParseByJsonobject;
    /**
     * create json string
     */
    private Button mBtnOriginalCreateByJsonobject;
    /**
     * no content
     */
    private TextView mTvOriginalCreatedByJsonobject;
    /**
     * create json string
     */
    private Button mBtnOriginalCreateByJsonstringer;
    /**
     * no content
     */
    private TextView mTvOriginalCreatedByJsonstringer;
    /**
     * parse json by jsontokener
     */
    private Button mBtnOriginalParseByJsontokener;
    /**
     * no content
     */
    private TextView mTvOriginalParseByJsontokener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_original_json);
        initView();
        mTvOriginalJsonStr.setText("original json: \n" + "{\n" +
                "  \"students\": [\n" +
                "    {\n" +
                "      \"name\": \"jadyli\",\n" +
                "      \"gender\": \"male\",\n" +
                "      \"age\": 18\n" +
                "    },\n" +
                "    {\n" +
                "      \"name\": \"Juliet\",\n" +
                "      \"gender\": \"female\",\n" +
                "      \"age\": 20\n" +
                "    }\n" +
                "  ]\n" +
                "}");
    }

    private void initView() {
        mTvOriginalJsonStr = (TextView) findViewById(R.id.tv_original_json_str);
        mBtnOriginalParseByJsonobject = (Button) findViewById(R.id.btn_original_parse_by_jsonobject);
        mBtnOriginalParseByJsonobject.setOnClickListener(this);
        mTvOriginalParseByJsonobject = (TextView) findViewById(R.id.tv_original_parse_by_jsonobject);
        mBtnOriginalCreateByJsonobject = (Button) findViewById(R.id.btn_original_create_by_jsonobject);
        mBtnOriginalCreateByJsonobject.setOnClickListener(this);
        mTvOriginalCreatedByJsonobject = (TextView) findViewById(R.id.tv_original_created_by_jsonobject);
        mBtnOriginalCreateByJsonstringer = (Button) findViewById(R.id.btn_original_create_by_jsonstringer);
        mBtnOriginalCreateByJsonstringer.setOnClickListener(this);
        mTvOriginalCreatedByJsonstringer = (TextView) findViewById(R.id.tv_original_created_by_jsonstringer);
        mBtnOriginalParseByJsontokener = (Button) findViewById(R.id.btn_original_parse_by_jsontokener);
        mBtnOriginalParseByJsontokener.setOnClickListener(this);
        mTvOriginalParseByJsontokener = (TextView) findViewById(R.id.tv_original_parse_by_jsontokener);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_original_parse_by_jsonobject:
                try {
                    JSONObject jsonObject = new JSONObject("{\"students\":[" +
                            "{\"name\":\"jadyli\",\"gender\":\"male\",\"age\":18}," +
                            "{\"name\":\"Juliet\",\"gender\":\"female\",\"age\":20}]}");
                    JSONArray students = jsonObject.getJSONArray("students");
                    StringBuilder stringBuilder = new StringBuilder();
                    for (int i = 0; i < students.length(); i++) {
                        JSONObject student = students.getJSONObject(i);
                        stringBuilder.append("姓名：" + student.getString("name") + "\n");
                        stringBuilder.append("性别：" + student.getString("gender") + "\n");
                        stringBuilder.append("年龄：" + student.getInt("age") + "\n\n");
                    }
                    mTvOriginalParseByJsonobject.setText(stringBuilder.toString());
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                break;
            case R.id.btn_original_create_by_jsonobject:
                try {
                    JSONArray students = new JSONArray();

                    String[] names = {"jadyli", "Juliet"};
                    String[] genders = {"male", "female"};
                    int[] ages = {18, 20};
                    for (int i = 0; i < names.length; i++) {
                        JSONObject student = new JSONObject();
                        student.put("name", names[i]);
                        student.put("gender", genders[i]);
                        student.put("age", ages[i]);
                        students.put(student);
                    }
                    JSONObject jsonObject = new JSONObject();
                    jsonObject.put("students", students);

                    mTvOriginalCreatedByJsonobject.setText(jsonObject.toString(1));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                break;
            case R.id.btn_original_create_by_jsonstringer:
                try {
                    JSONStringer jsonStringer = new JSONStringer();
                    jsonStringer.object();

                    jsonStringer.key("students");
                    jsonStringer.array();
                    String[] names = {"jadyli", "Juliet"};
                    String[] genders = {"male", "female"};
                    int[] ages = {18, 20};
                    for (int i = 0; i < names.length; i++) {
                        jsonStringer.object();
                        jsonStringer.key("name");
                        jsonStringer.value(names[i]);
                        jsonStringer.key("gender");
                        jsonStringer.value(genders[i]);
                        jsonStringer.key("age");
                        jsonStringer.value(ages[i]);
                        jsonStringer.endObject();
                    }
                    jsonStringer.endArray();

                    jsonStringer.endObject();

                    System.out.println(jsonStringer.toString());
                    mTvOriginalCreatedByJsonstringer.setText(jsonStringer.toString());
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                break;
            case R.id.btn_original_parse_by_jsontokener:
                try {
                    JSONTokener jsonTokener = new JSONTokener("{\"students\":[" +
                            "{\"name\":\"jadyli\",\"gender\":\"male\",\"age\":18}," +
                            "{\"name\":\"Juliet\",\"gender\":\"female\",\"age\":20}]}");
//                    System.out.println(jsonTokener.next());
//                    jsonTokener.skipPast("name");
//                    System.out.println(jsonTokener.next());
                    JSONObject jsonObject = (JSONObject) jsonTokener.nextValue();
                    JSONArray students = jsonObject.getJSONArray("students");
                    StringBuilder stringBuilder = new StringBuilder();
                    for (int i = 0; i < students.length(); i++) {
                        JSONObject student = students.getJSONObject(i);
                        stringBuilder.append("姓名：" + student.getString("name") + "\n");
                        stringBuilder.append("性别：" + student.getString("gender") + "\n");
                        stringBuilder.append("年龄：" + student.getInt("age") + "\n\n");
                    }
                    mTvOriginalParseByJsontokener.setText(stringBuilder.toString());
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                break;
        }
    }
}
