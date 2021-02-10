package com.xtha.zujal.quotes

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.retrofittest.MainViewModelFactory


class QuoteFragment : Fragment() {

    private lateinit var viewModel: MainViewModel
    private lateinit var content_view:LinearLayout
    private lateinit var loading_view:FrameLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        content_view=view.findViewById<LinearLayout>(R.id.contentlayout)
        content_view.visibility=View.GONE
        loading_view=view.findViewById<FrameLayout>(R.id.loadingcontent)
        content_view.visibility=View.VISIBLE
        val repository = Repository()
        val viewModelFactory = MainViewModelFactory(repository)
        viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)
        viewModel.getPost();


        viewModel.myResponse.observe(this, Observer { response ->
            if(response.isSuccessful)
            {
                loading_view.visibility = View.GONE
                content_view.visibility = View.VISIBLE
//                Log.i("myResponse",response.body().toString())
//                Log.i("myResponse",response.body()?.id.toString())
////                Log.i("myResponse",response.body()?.tags.toString())
//                Log.i("myResponse",response.body()?.author.toString())
//                Log.i("myResponse",response.body()?.content.toString())
//                Log.i("myResponse",response.body()?.length.toString())

                if (response.body()?.length.toString().toInt()>200)
                {
                    view.findViewById<TextView>(R.id.quotecontentid).setTextSize(20F)
                }
                view.findViewById<TextView>(R.id.quotecontentid).setText(response.body()?.content.toString())
                view.findViewById<TextView>(R.id.quoteauthorid).setText(response.body()?.author.toString())
            }
            else{
               // Log.i("myResponse", response.errorBody().toString())

                Toast.makeText(activity,response.errorBody().toString(),Toast.LENGTH_SHORT).show()
//                textViewFirst.setText(response.errorBody().toString())
            }

        })

        view.findViewById<Button>(R.id.closeappbutton).setOnClickListener(View.OnClickListener {
            activity!!.finishAffinity();

        })



    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_quote, container, false)
    }



}