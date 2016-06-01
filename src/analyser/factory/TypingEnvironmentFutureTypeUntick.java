/**
 * Copyright (c) 2009-2011, The HATS Consortium. All rights reserved. 
 * This file is licensed under the terms of the Modified BSD License.
 */
package analyser.factory;

public class TypingEnvironmentFutureTypeUntick implements ITypingEnvironmentFutureType {

    IRecord r;

    public TypingEnvironmentFutureTypeUntick(IRecord r){
        this.r = r;
    }
    
    public IRecord getRecord(){return r;}
}
