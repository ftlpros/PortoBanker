/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.porto.networkops;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Vector;
import java.util.concurrent.ExecutionException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.SwingWorker;

/**
 *
 * @author eipps
 */
public class NetworkWorker extends SwingWorker {
    public static final NetworkWorker INSTANCE = new NetworkWorker();
    private String urlData;
    private String url;
    private ArrayList<NetworkResponseListener> responseListeners = new ArrayList();

    public NetworkWorker getInstanceNetworkWorker() {
        if (INSTANCE != null) {
            return INSTANCE;
        } else {
            return new NetworkWorker();
        }
    }
    public void addResponseListener(NetworkResponseListener listener){
        responseListeners.add(listener);
    }
    public void removeResonseListener(NetworkResponseListener listener){
        responseListeners.remove(listener);
    }
    public void setURLParms(String urlData) {
        this.urlData = urlData;
    }

    public void setURL(String url) {
        this.url = url;
    }

    @Override
    protected Object doInBackground() throws Exception {
        URL URL_ = new URL(url+urlData);
        InputStream in = URL_.openConnection().getInputStream();
        BufferedReader bin = new BufferedReader(new InputStreamReader(in));
        String response = bin.readLine();
        bin.close();
        in.close();
        return response;
    }

    @Override
    protected void done() {
        try {
            String response = (String)get();
            for(int i=0;i<responseListeners.size();i++){
                responseListeners.get(i).getResponse(response);
            }
        } catch (InterruptedException ex) {
              ex.printStackTrace();
        } catch (ExecutionException ex) {
            ex.printStackTrace();
        }
    }
}
