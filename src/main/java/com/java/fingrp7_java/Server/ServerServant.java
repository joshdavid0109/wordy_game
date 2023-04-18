package com.java.fingrp7_java.Server;


import com.java.fingrp7_java.Server.WordyGame.CredentialsResult;
import com.java.fingrp7_java.Server.WordyGame.NoPlayersAvailable;
import com.java.fingrp7_java.Server.WordyGame.WordyGameServer;
import org.omg.CORBA.*;
import org.omg.CORBA.Object;
import org.omg.PortableServer.POA;
import org.omg.PortableServer.Servant;

import javax.security.auth.login.CredentialException;

public class ServerServant extends Servant implements WordyGameServer {
    @Override
    public CredentialsResult login(String username, String password) throws NoPlayersAvailable {
            if (username.equals("testuser") && password.equals("testuser"))
                return CredentialsResult.SUCCESS;


        return CredentialsResult.INVALID_CREDENTIALS;
    }

    @Override
    public CredentialsResult signUp() {
        return null;
    }

    @Override
    public void logout(String username) {

    }

    @Override
    public String[] playGame(String username) throws NoPlayersAvailable {


        throw new NoPlayersAvailable("Walang tao");
    }

    @Override
    public boolean checkWord(String word) {
        return false;
    }

    @Override
    public String[] getLongestWords() {
        return new String[0];
    }

    @Override
    public String[] getTopPlayers() {
        return new String[0];
    }

    @Override
    public boolean _is_a(String repositoryIdentifier) {
        return false;
    }

    @Override
    public boolean _is_equivalent(Object other) {
        return false;
    }

    @Override
    public boolean _non_existent() {
        return false;
    }

    @Override
    public int _hash(int maximum) {
        return 0;
    }

    @Override
    public Object _duplicate() {
        return null;
    }

    @Override
    public void _release() {

    }

    @Override
    public Object _get_interface_def() {
        return null;
    }

    @Override
    public String[] _all_interfaces(POA poa, byte[] objectId) {
        return new String[0];
    }

    @Override
    public Request _request(String operation) {
        return null;
    }

    @Override
    public Request _create_request(Context ctx, String operation, NVList arg_list, NamedValue result) {
        return null;
    }

    @Override
    public Request _create_request(Context ctx, String operation, NVList arg_list, NamedValue result, ExceptionList exclist, ContextList ctxlist) {
        return null;
    }

    @Override
    public Policy _get_policy(int policy_type) {
        return null;
    }

    @Override
    public DomainManager[] _get_domain_managers() {
        return new DomainManager[0];
    }

    @Override
    public Object _set_policy_override(Policy[] policies, SetOverrideType set_add) {
        return null;
    }
}
