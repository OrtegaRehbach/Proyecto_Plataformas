package com.uvg.spotifyrecommendations

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController

class LoginFragment : Fragment(R.layout.fragment_login) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

         view.findViewById<Button>(R.id.btnLogin).setOnClickListener {
             val action = LoginFragmentDirections.actionLoginFragmentToMainMenuFragment()
             findNavController().navigate(action)
         }
    }

}