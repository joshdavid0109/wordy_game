package com.java.fingrp7_java.Server;

import com.java.fingrp7_java.Server.WordyGameServer.WordyGameServer;
import com.java.fingrp7_java.Server.WordyGameServer.WordyGameServerHelper;
// `import org.omg.CORBA.ORB;` is importing the `ORB` class from the `org.omg.CORBA` package. The `ORB` class is used to
// initialize and configure the CORBA (Common Object Request Broker Architecture) runtime environment. It provides methods
// for creating object references, registering and activating object implementations, and managing communication between
// distributed objects.
import org.omg.CORBA.ORB;
import org.omg.CORBA.ORBPackage.InvalidName;
import org.omg.CosNaming.NameComponent;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;
import org.omg.CosNaming.NamingContextPackage.CannotProceed;
import org.omg.CosNaming.NamingContextPackage.NotFound;
import org.omg.PortableServer.POA;
import org.omg.PortableServer.POAHelper;
import org.omg.PortableServer.POAManagerPackage.AdapterInactive;
import org.omg.PortableServer.POAPackage.ServantNotActive;
import org.omg.PortableServer.POAPackage.WrongPolicy;

public class Server {
    public static void main(String[] args) {
        try {

            /**
             * Default codes for
             */
            // create and initialize ORB
            ORB orb = ORB.init(args, null);

            // get reference to rootPOA & activate POAManager
            POA rootPOA = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
            rootPOA.the_POAManager().activate();

            // create servant and register it with the ORB
            ServerServant servant = new ServerServant();

            // get the object reference from the servant
            org.omg.CORBA.Object ref = rootPOA.servant_to_reference(servant);
            WordyGameServer href = WordyGameServerHelper.narrow(ref);

            // get the root naming context
            org.omg.CORBA.Object objectRef = orb.resolve_initial_references("NameService");

            // Use NamingContextExt which is part of the Interoperable Naming Service (INS) specs
            NamingContextExt namingContextExt = NamingContextExtHelper.narrow(objectRef);

            // bind the Object reference in Naming
            String stub = "Hello";

            stub.compareTo("Hi");
            NameComponent[] path = namingContextExt.to_name(stub);
            namingContextExt.rebind(path, href);
            System.out.println("HelloServer is now operating..");

            orb.run();
        } catch (WrongPolicy | InvalidName | org.omg.CosNaming.NamingContextPackage.InvalidName | AdapterInactive |
                 ServantNotActive | CannotProceed | NotFound e) {
            throw new RuntimeException(e);
        }
    }
}
