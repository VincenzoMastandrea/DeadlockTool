/**
 * Copyright (c) 2009-2011, The HATS Consortium. All rights reserved. 
 * This file is licensed under the terms of the Modified BSD License.
 */
package analyser.detection;

import java.util.HashMap;
import java.util.Map;

import analyser.factory.Factory;
import analyser.factory.MainMethodContract;
import analyser.factory.MethodContract;

public abstract class DASolver {

    
    protected Boolean deadlock;
    protected Map<String, MethodContract> methodMap;
    protected MainMethodContract mmc;
    protected Factory df;
    protected Map<String, BigLam> lampMap;
    
    public DASolver(Factory f, Map<String, MethodContract> map, MainMethodContract mmc){
        this.df = f;
        this.methodMap = map;
                
        this.deadlock = false;
        
        this.mmc = mmc;
        
        this.lampMap = new HashMap<String, BigLam>();

        for(String mName : methodMap.keySet()){
            this.lampMap.put(mName, new BigLam(mName, methodMap.get(mName)));
        }
    }
    
    public boolean isDeadlockMain(){
        return this.deadlock;
    }
    
    public abstract void computeSolution();
    
    public abstract String getName();
}
