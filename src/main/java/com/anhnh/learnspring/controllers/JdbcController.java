package com.anhnh.learnspring.controllers;

import com.anhnh.learnspring.entitys.ArtistEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/items")
public class JdbcController {

    private static final String SELECT_ALL_QUERY = "SELECT * FROM Artist";
    private static final String SELECT_BY_ID_QUERY = "SELECT * FROM items WHERE id = ?";
    private static final String INSERT_QUERY = "INSERT INTO items (name) VALUES (?)";
    private static final String UPDATE_QUERY = "UPDATE items SET name = ? WHERE id = ?";
    private static final String DELETE_QUERY = "DELETE FROM items WHERE id = ?";

    private final DataSource dataSource;

    @Autowired
    public JdbcController(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @GetMapping
    public List<ArtistEntity> getAllItems() throws SQLException {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(SELECT_ALL_QUERY);
             ResultSet resultSet = statement.executeQuery()) {

            List<ArtistEntity> items = new ArrayList<>();
            while (resultSet.next()) {
                items.add(mapResultSetToItem(resultSet));
            }
            return items;
        }
    }

    private ArtistEntity mapResultSetToItem(ResultSet resultSet) throws SQLException {
        ArtistEntity item = new ArtistEntity();
        item.setArtistId(resultSet.getLong("artistId"));
        item.setName(resultSet.getString("name"));
        // Add other fields as needed
        return item;
    }
}

