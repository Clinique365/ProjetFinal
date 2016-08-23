package com.codepath.clinique365;

import android.content.Context;

import com.backendless.Backendless;
import com.backendless.BackendlessUser;

/**
 * Created by SET JETRO on 8/18/2016.
 */
public class ClinicClient  {

    public static final String APP_ID = "8E03CCAA-E054-6D08-FF6B-BBCDFF930100" ;
    public static final String SECRET_KEY = "557A461D-A632-F486-FF5D-CBAF6F137600";
    public static final String VERSION = "v1";

    public ClinicClient(Context context){
        Backendless.initApp(context, APP_ID, SECRET_KEY, VERSION);
    }

    }
