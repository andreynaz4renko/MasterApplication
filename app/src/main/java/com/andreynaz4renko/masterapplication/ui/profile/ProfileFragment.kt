package com.andreynaz4renko.masterapplication.ui.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.andreynaz4renko.masterapplication.databinding.FragmentProfileBinding
import com.bumptech.glide.Glide
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProfileFragment : Fragment() {

    private lateinit var binding: FragmentProfileBinding

    private val viewModel: ProfileViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentProfileBinding.inflate(inflater, container, false)

        viewModel.profileData.observe(viewLifecycleOwner) {
            binding.nameView.text = it.name
            // binding.emailView.text = it.email
            Glide.with(this).load(it.avatar).into(binding.avatarView)
        }

        viewModel.getProfileData()

        return binding.root
    }
}