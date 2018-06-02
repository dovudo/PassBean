package com.dov.pass.service.testdatabase;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class overloadTest implements Runnable{

    private static final Logger log = LoggerFactory.getLogger("Test log");
    private connectToDb db = new connectToDb();

    @Test
    public void genTestSendOneThread() {
        for (int i = 0; i < 50; i++)
            db.sendPOST(db.getRndString(6), db.getRndString(9));
    }

    @Test
    public void genTestSendMultiThreads() {
        System.out.println(" хуйня 1 зашла" );
        for (int i = 0; i < 5; i++) {
        Thread tread = new Thread(this);
        tread.start();
        }
    }

    public void run(){
        System.out.println(Thread.currentThread().getId() + " Thread Started");
        for (int i = 0; i < 10; i++)
            db.sendPOST(db.getRndString(6), db.getRndString(9));
        System.out.println(Thread.currentThread().getId() + " Thread done");
    }

}
