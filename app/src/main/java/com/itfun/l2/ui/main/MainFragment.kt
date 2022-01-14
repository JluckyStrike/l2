package com.itfun.l2.ui.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.FragmentTransaction
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.itfun.l2.Movie
import com.itfun.l2.R
import com.itfun.l2.RecyclerAdapter
import com.itfun.l2.fragment_nav.FavouriteFragment
import java.util.ArrayList

class MainFragment : Fragment(), RecyclerAdapter.onItemClickListener {

    companion object {
        fun newInstance() = MainFragment()
    }


    private lateinit var viewModel: MainViewModel
    private val movies: List<Movie>

    private var adapter: RecyclerView.Adapter<RecyclerAdapter.ViewHolder>? = null

    init {
        movies = listOf<Movie>(
            Movie(R.drawable.pirates1, "Pirates of the Caribbean One", 9.7),
            Movie(R.drawable.pirates2, "Pirates of the Caribbean Two", 9.4),
            Movie(R.drawable.pirates3, "Pirates of the Caribbean Three", 9.7),
            Movie(R.drawable.pirates4, "Pirates of the Caribbean Four", 9.4)
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.main_fragment, container, false)

        view.findViewById<RecyclerView>(R.id.recyclerView).layoutManager =
            LinearLayoutManager(activity)

        adapter = RecyclerAdapter(movies, this)
        view.findViewById<RecyclerView>(R.id.recyclerView).adapter = adapter

        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        // TODO: Use the ViewModel

    }

    override fun onItemClick(position: Int) {
        val fragment = DetailsFragment.newInstance(
            movies[position].titleMovie,
            movies[position].imageMovie,
            movies[position].ratingMovie
        )

        val transaction = requireActivity().supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container, fragment)
        transaction.commit()
    }
}