package com.example.bookreader

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.bookreader.adapter.ItemAdapter
import com.example.bookreader.data.dataSource
import com.example.bookreader.databinding.FragmentSecondBinding

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class GridView : Fragment(), ItemAdapter.OnItemListener {

    private var _binding: FragmentSecondBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private var layoutManager: GridLayoutManager? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonSecond.setOnClickListener {
            findNavController().navigate(R.id.action_GridView_to_ListView)
        }

        layoutManager = GridLayoutManager(requireContext(), 3)
        binding.recyclerView2.layoutManager = layoutManager
        // Initialize data.
        val myDataset = dataSource().loadData()

        binding.recyclerView2.adapter = ItemAdapter(requireContext(), myDataset, this)
        binding.recyclerView2.setHasFixedSize(true)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onItemClicked(position: Int) {
        val intent = Intent(context, BookDetails::class.java)
        intent.putExtra("clickedID_frag2", position)
        startActivity(intent)
    }
}