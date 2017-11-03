package com.travazar.tour.packages.data;

import com.travazar.tour.packages.data.local.LocalRepository;
import com.travazar.tour.packages.data.remote.RemoteRepository;

/**
 * Created by kali_root on 10/31/2017.
 */

public class DataRepository {
    private LocalRepository mLocalRepository;
    private RemoteRepository mRemoteRepository;

    public DataRepository(LocalRepository mLocalRepository, RemoteRepository mRemoteRepository) {
        this.mLocalRepository = mLocalRepository;
        this.mRemoteRepository = mRemoteRepository;
    }
}
