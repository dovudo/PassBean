package com.dov.pass.service.testdatabase;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ThreadPool implements Runnable{

    private connectToDb db = new connectToDb();
    private static final Logger log = LoggerFactory.getLogger("Thread");

    @Override
    public void run(){
        System.out.println(Thread.currentThread().getId() + " Thread Started");
        db.sendPOST(db.getRndString(6),db.getRndString(9));
        System.out.println(Thread.currentThread().getId() + " Thread done");
    }


}
