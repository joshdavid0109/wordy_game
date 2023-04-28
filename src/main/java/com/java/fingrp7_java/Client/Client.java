package com.java.fingrp7_java.Client;

import WordyGame.NoPlayersAvailable;
import WordyGame.WordyGamePlayer;
import WordyGame.WordyGameServer;
import WordyGame.WordyGameServerHelper;
import org.omg.CORBA.ORB;
import org.omg.CORBA.ORBPackage.InvalidName;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;
import org.omg.CosNaming.NamingContextPackage.CannotProceed;
import org.omg.CosNaming.NamingContextPackage.NotFound;
import org.omg.SendingContext.RunTime;

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

            int id = 2323423;
            String gameId = wordyGameServer.playGame(44455544);

            orb.run();
        } catch (InvalidName | org.omg.CosNaming.NamingContextPackage.InvalidName | CannotProceed | NotFound |
                 NoPlayersAvailable |RuntimeException e) {
            if (e instanceof RuntimeException) {
                System.out.println(((RuntimeException) e).getCause());
            } else if (e instanceof NoPlayersAvailable) {
                System.out.println(((NoPlayersAvailable) e).reason);
            }
            
            e.printStackTrace();
        }
    }
}
