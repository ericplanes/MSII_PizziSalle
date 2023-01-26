package com.salle.persistence;

import com.salle.utilities.ConstantUtilities;

public class ConnectionRepository {
    private static ConnectionBBDD connection;

    static ConnectionBBDD getConnection() throws Exception {
        if (connection == null) {
            connection = new ConnectionBBDD(ConstantUtilities.UsernameBBDD, ConstantUtilities.PasswordBBDD, ConstantUtilities.UrlBDD);
        }
        return connection;
    }
}
