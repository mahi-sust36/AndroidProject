package com.example.chattingapp.Adapters;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.chattingapp.Fragments.CallsFragment;
import com.example.chattingapp.Fragments.ChatsFragment;
import com.example.chattingapp.Fragments.StatusFragment;

public class FragmentsAdapter extends FragmentPagerAdapter {
    public FragmentsAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }



    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0: return new ChatsFragment() ;
            case 1: return new StatusFragment() ;
            case 2: return new CallsFragment();
            default:return new ChatsFragment() ;
        }
        //return null;
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        String title = null;
        if(position==0){
            title = "Chats" ;
        }else if(position==1){
            title = "Status" ;
        }else if(position==2){
            title = "Calls" ;
        }
        return title;
    }
}
