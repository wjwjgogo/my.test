package com.wj.kotlinmvvm.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

abstract class BaseActivity<DB : ViewDataBinding> : AppCompatActivity() {
    lateinit var mDataBind: DB
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mDataBind = DataBindingUtil.setContentView<DB>(this,getLayoutId())
        initData()
        initView()
    }

    abstract fun getLayoutId(): Int
    abstract fun initData()
    abstract fun initView()

    override fun onDestroy() {
        super.onDestroy()
        mDataBind.unbind()
    }
}