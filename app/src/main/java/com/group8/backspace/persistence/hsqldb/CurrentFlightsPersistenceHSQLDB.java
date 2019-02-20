package com.group8.backspace.persistence.hsqldb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.group8.backspace.objects.CurrentFlights;
import com.group8.backspace.persistence.CurrentFlightsPersistence;

public class CurrentFlightsPersistenceHSQLDB implements CurrentFlightsPersistence
{
    private final Connection c;

    public CurrentFlightsPersistenceHSQLDB(final String dbPath) {
            try {
                this.c = DriverManager.getConnection("jdbc:hsqldb:file:" + dbPath, "SA", "");
            } catch (final SQLException e) {
                throw new PersistenceException(e);
            }
        }


    private CurrentFlights fromResultSet(final ResultSet rs) throws SQLException {
        final String FlightID = rs.getString("FlightID");
        final String Arrival = rs.getString("Arrival");
        final String price = rs.getString("price");
        final String perCentComplete = rs.getString("perCentComplete");
        final String Status = rs.getString("status");

        return new CurrentFlights(Arrival, Integer.parseInt(FlightID), Double.parseDouble(price), perCentComplete, Status);
    }

    @Override
    public List<CurrentFlights> getInfo ()
    {
        final List<CurrentFlights> list = new ArrayList<>();
        try
        {
            final Statement st = c.createStatement();
            final ResultSet rs = st.executeQuery("SELECT * FROM currentflights");
            while (rs.next())
            {
                final CurrentFlights cflights = fromResultSet(rs);
                list.add(cflights);
            }
            rs.close();
            st.close();

            return list;
        }
        catch (final SQLException e)
        {
            throw new PersistenceException(e);
        }
    }
}
