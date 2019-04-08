package atlantadragons.gatech.spacetrader.Model;

import android.util.Log;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class RepoHolder {

    private Repository repo;
    private Interactor interactor;

    public final static String DEFAULT_JSON_FILE_NAME = "data.json";

    private static RepoHolder holder = new RepoHolder();

    private RepoHolder() {
        repo = new Repository();
        createInteractor();
    }

    public void createInteractor() {
        interactor = new Interactor(repo);
    }

    public static RepoHolder getHolder() { return holder; }

    public Interactor getInteractor() { return interactor; }

    public boolean loadJson(File file) {
        try {
            BufferedReader input = new BufferedReader(new FileReader(file));
            //Since we saved the json as a string, we just read in the string normally
            String inString = input.readLine();
            Log.d("DEBUG", "JSON: " + inString);
            //Then we use the Gson library to recreate the object references and links automagically
            Gson gson = new Gson();

            repo = gson.fromJson(inString, Repository.class);

            input.close();
        } catch (IOException e) {
            Log.e("RepoHolder", "Failed to open/read the buffered reader for json");
            return false;
        }

        return true;

    }

    public boolean saveJson(File file ) {

        try {
            PrintWriter writer = new PrintWriter(file);
            /*
                We are using the Google Gson library to make things easy.  You will need to add the
                following line to your gradle file so the proper dependencies are set up:
                compile 'com.google.code.gson:gson:2.3'

                Gson, like object serialization will take a single object and save all the objects
                it refers to.  You can save everything by one reference, as long as it is the
                top-level reference.


             */
            Gson gson = new Gson();
            // convert our objects to a string for output
            String outString = gson.toJson(repo);
            Log.d("DEBUG", "JSON Saved: " + outString);
            //then just write the string
            writer.println(outString);
            writer.close();
        } catch (FileNotFoundException e) {
            Log.e("RepoHolder", "Failed to open json file for output");
            return false;
        }

        return true;
    }
}
