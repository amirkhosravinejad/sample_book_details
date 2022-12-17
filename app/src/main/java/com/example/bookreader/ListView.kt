package com.example.bookreader

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.bookreader.adapter.ItemAdapter
import com.example.bookreader.data.dataSource
import com.example.bookreader.databinding.FragmentFirstBinding

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class ListView : Fragment(), ItemAdapter.OnItemListener {

    private var _binding: FragmentFirstBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonFirst.setOnClickListener {
            findNavController().navigate(R.id.action_ListView_to_GridView)
        }
        // Initialize data.
        val myDataset = dataSource().loadData()

        val recyclerView = binding.recyclerView
        recyclerView.adapter = ItemAdapter(requireContext(), myDataset, this)

        // Use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        recyclerView.setHasFixedSize(true)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onItemClicked(position: Int) {
        //val item_pos = dataSource().loadData()[position]
        val intent = Intent(context, BookDetails::class.java)
        intent.putExtra("clickedID_frag1", position)
        startActivity(intent)
    }
}