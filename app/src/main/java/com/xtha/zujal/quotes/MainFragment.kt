package com.xtha.zujal.quotes

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment


class MainFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<Button>(R.id.getquotebutton).setOnClickListener(View.OnClickListener {
            var quoteFragment: QuoteFragment = QuoteFragment()

            activity!!.supportFragmentManager.beginTransaction().
            replace(R.id.rootid, quoteFragment)
                .commitAllowingStateLoss()

        })
    }

}