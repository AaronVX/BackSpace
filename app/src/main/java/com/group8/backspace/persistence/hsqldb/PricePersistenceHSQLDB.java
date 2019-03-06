package com.group8.backspace.persistence.hsqldb;
import com.group8.backspace.persistence.PricePersistence;
import com.group8.backspace.objects.Price;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class PricePersistenceHSQLDB implements PricePersistence {

    private final String path;
    public PricePersistenceHSQLDB(final String path) {
        this.path = path;
    }


    private Connection connection() throws SQLException {
        return DriverManager.getConnection("jdbc:hsqldb:file:" + path, "SA", "");
    }

    @Override
    public Price getPrice(String name)
    {
        Price price = null;
        try (final Connection c = connection()) {
            final PreparedStatement st = c.prepareStatement("SELECT * FROM prices WHERE item = ?");
            st.setString(1, name);
            final ResultSet rs = st.executeQuery();
            while (rs.next()) {
                price = fromResultSet(rs);
            }
            rs.close();
            st.close();
            if (price==null) {
                throw new NullPointerException();
            }
            else {
                return price;
            }

            //return new Price("fasf","adag",20);
        } catch (final SQLException e) {
            throw new PersistenceException(e);
        }
    }

    private Price fromResultSet(final ResultSet rs) throws SQLException {
        String item = rs.getString("item");
        String type = rs.getString("type");
        int price = rs.getInt("price");
        return new Price(item,type,price);
    }
}
