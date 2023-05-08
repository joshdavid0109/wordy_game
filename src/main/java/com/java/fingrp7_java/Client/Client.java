package com.java.fingrp7_java.Client;

import WordyGame.*;
/*import com.sun.jmx.snmp.internal.SnmpSubSystem;*/
import org.omg.CORBA.ORB;
import org.omg.CORBA.ORBPackage.InvalidName;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;
import org.omg.CosNaming.NamingContextPackage.CannotProceed;
import org.omg.CosNaming.NamingContextPackage.NotFound;
import org.omg.SendingContext.RunTime;

import java.util.Scanner;

public class Client {
    static WordyGameServer wordyGameServer;
    static WordyGamePlayer wordyGamePlayer;
    static Scanner scanner;
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

            scanner = new Scanner(System.in);

//            int id;
//            System.out.print("ID: ");
//            id = scanner.nextInt();
//            System.out.println(id);
//            int gameId =0;
//            try {
//                gameId = wordyGameServer.playGame(id);
//            } catch (NoPlayersAvailable noPlayersAvailable) {
//                System.out.println(noPlayersAvailable.reason);
//            }
//
//                if (gameId !=0) {
//                    System.out.println("Type R.");
//                    if (scanner.next().equalsIgnoreCase("R")) {
////                        System.out.println(wordyGameServer.ready(id, gameId));
//                        System.out.println(wordyGameServer.requestLetters(gameId));
//                    }
//                }

            System.out.print("USERNAME: ");
            String username = scanner.nextLine();
            System.out.print("PASSWORD: ");
            String password = scanner.nextLine();

            try {
                wordyGameServer.login(username, password);
            } catch (ServerUnavailable e) {
                throw new RuntimeException(e);
            } catch (UserAlreadyLoggedIn e) {
                throw new RuntimeException(e);
            } catch (InvalidCredentials e) {
                throw new RuntimeException(e);
            } catch (InvalidPassword e) {
                throw new RuntimeException(e);
            }

        } catch (InvalidName | org.omg.CosNaming.NamingContextPackage.InvalidName | CannotProceed | NotFound |
                 RuntimeException e) {
            e.printStackTrace();
        }
    }
}
