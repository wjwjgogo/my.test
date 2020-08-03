package com.wj.kotlinmvvm

//import androidx.appcompat.app.AppCompatActivity
//import android.os.Bundle
//
//class MainActivity : AppCompatActivity() {
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//    }
//}
import android.text.Editable
import android.text.TextWatcher
import com.wj.kotlinmvvm.view.BaseActivity
import com.wj.kotlinmvvm.databinding.ActivityMainBinding
import com.wj.kotlinmvvm.module.User
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity<ActivityMainBinding>() {
    private var user = User("hanyun")
    override fun getLayoutId(): Int = R.layout.activity_main
    override fun initData() {
            mDataBind.user = user
    }

    override fun initView() {
        editText.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                mDataBind.user = user.copy(name = editText.text.toString())
            }
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
        })
    }
}
