package com.example.cryptopro;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class Referadapter extends FragmentStateAdapter {



    public Referadapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        if (position == 1){
            return new DirectReferFragment();
        }
        return new Add_Fragment() ;
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}
