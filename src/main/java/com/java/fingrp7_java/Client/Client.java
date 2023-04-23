package com.java.fingrp7_java.Client;

import org.omg.CORBA.ORB;
import org.omg.CORBA.ORBPackage.InvalidName;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;
import org.omg.CosNaming.NamingContextPackage.CannotProceed;
import org.omg.CosNaming.NamingContextPackage.NotFound;

public class Client {
    static WordyGameServer wordyGameServer;
    static WordyGamePlayer wordyGamePlayer;
    public static void main(String[] args) {
        try {

            /**
             * Default codes for
             */
            // create and initialize ORB
            ORB orb = ORB.init(args, null);

            // get the root naming context
            org.omg.CORBA.Object objectRef = orb.resolve_initial_references("NameService");

            // Use NamingContextExt which is part of the Interoperable Naming Service (INS) specs
            NamingContextExt namingContextExt = NamingContextExtHelper.narrow(objectRef);

            // bind the Object reference in Namin
            String stub = "Hello";
            wordyGameServer = WordyGameServerHelper.narrow(namingContextExt.resolve_str(stub));

            wordyGameServer.
                    login("testuser", "testuser");

            System.out.println(wordyGameServer.login("testuser", "testuser"));
//            System.out.println(helloImpl.);

            orb.run();
        } catch (InvalidName | org.omg.CosNaming.NamingContextPackage.InvalidName | CannotProceed | NotFound |
                 NoPlayersAvailable e) {
            throw new RuntimeException(e);
        }
    }
}
