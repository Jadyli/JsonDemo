package com.jady.jsondemo.thirdparty;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.jady.jsondemo.R;

import java.util.ArrayList;
import java.util.List;

import static com.jady.jsondemo.R.id.btn_third_party_parse_json_arr;

public class ThirdParthJsonActivity extends AppCompatActivity implements View.OnClickListener {


    protected TextView tvThirdPartyJsonStr;
    protected Button btnThirdPartyParseJson;
    protected TextView tvThirdPartyParseJson;
    protected Button btnThirdPartyParseJsonArr;
    protected TextView tvThirdPartyParseJsonArr;
    protected Button btnThirdPartyCreateJson;
    protected TextView tvThirdPartyCreateJson;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third_party_json);
        initView();
        tvThirdPartyJsonStr.setText("original json: \n" + "{\n" +
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
        tvThirdPartyJsonStr = (TextView) findViewById(R.id.tv_third_party_json_str);
        btnThirdPartyParseJson = (Button) findViewById(R.id.btn_third_party_parse_json);
        btnThirdPartyParseJson.setOnClickListener(ThirdParthJsonActivity.this);
        tvThirdPartyParseJson = (TextView) findViewById(R.id.tv_third_party_parse_json);
        btnThirdPartyParseJsonArr = (Button) findViewById(btn_third_party_parse_json_arr);
        btnThirdPartyParseJsonArr.setOnClickListener(ThirdParthJsonActivity.this);
        tvThirdPartyParseJsonArr = (TextView) findViewById(R.id.tv_third_party_parse_json_arr);
        btnThirdPartyCreateJson = (Button) findViewById(R.id.btn_third_party_create_json);
        btnThirdPartyCreateJson.setOnClickListener(ThirdParthJsonActivity.this);
        tvThirdPartyCreateJson = (TextView) findViewById(R.id.tv_third_party_create_json);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btn_third_party_parse_json) {

        } else if (view.getId() == btn_third_party_parse_json_arr) {

        } else if (view.getId() == R.id.btn_third_party_create_json) {

        }
        switch (view.getId()) {
            case R.id.btn_third_party_parse_json:
                String json = "{\"students\":[{\"name\":\"jadyli\",\"gender\":\"male\",\"age\":18},{\"name\":\"Juliet\",\"gender\":\"female\",\"age\":20}]}";
                StudentInfo studentInfo = new Gson().fromJson(json, StudentInfo.class);
                System.out.println(studentInfo.toString());
                tvThirdPartyParseJson.setText(studentInfo.toString());
                break;
            case R.id.btn_third_party_parse_json_arr:
                List<ClassInfo> classInfoList = new Gson().fromJson("[" +
                                "{\"students\":[{\"name\":\"jadyli\",\"gender\":\"male\",\"age\":18}," + "{\"name\":\"Juliet\",\"gender\":\"female\",\"age\":20}],\"class\":\"A\"}," +
                                "{\"students\":[{\"name\":\"jack\",\"gender\":\"male\",\"age\":27},{\"name\":\"Avril\",\"gender\":\"female\",\"age\":17}],\"class\":\"B\"}]",
                        new TypeToken<List<ClassInfo>>() {
                        }.getType());
                System.out.println(classInfoList.toString());
                tvThirdPartyParseJsonArr.setText(classInfoList.toString());
                break;
            case R.id.btn_third_party_create_json:
                String[] names = {"jadyli", "Juliet"};
                String[] genders = {"male", "female"};
                int[] ages = {18, 20};
                List<Student> students = new ArrayList<>();
                for (int i = 0; i < names.length; i++) {
                    Student student = new Student();
                    student.setName(names[i]);
                    student.setGender(genders[i]);
                    student.setAge(ages[i]);
                    students.add(student);
                }
                String jsonStr = new Gson().toJson(students);
                System.out.println(jsonStr);
                tvThirdPartyCreateJson.setText(jsonStr);
                break;
        }
    }
}
