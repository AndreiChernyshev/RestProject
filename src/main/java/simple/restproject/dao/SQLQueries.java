package simple.restproject.dao;

public enum SQLQueries {
    INSERT_DEVELOPER("INSERT INTO developer(developer_name, age, education) VALUES (?, ?, ?)"),
    SELECT_DEVELOPERS_ON_PROJECT("SELECT d.developer_name FROM developer d " +
            "JOIN project2developer p2d ON p2d.developer_id = d.developer_id " +
            "WHERE p2d.project_id = (?)"),
    SELECT_FULL_INFO("SELECT d.developer_id, d.developer_name, d.age, d.education, p.project_id, p.title, ph.phone_id, ph.phone_type, ph.phone_number " +
            "FROM developer d " +
            "LEFT JOIN project2developer p2d ON p2d.developer_id = d.developer_id " +
            "LEFT JOIN Project p on p.project_id = p2d.project_id " +
            "LEFT JOIN  phone ph on ph.developer_id = d.developer_id " +
            "WHERE d.developer_id = (?) " +
            "ORDER BY ph.phone_id"),
    UPDATE_DEVELOPER_BY_ID("UPDATE developer SET developer_name=(?),age=(?),education=(?) WHERE developer_id = (?)"),
    DELETE_DEVELOPER_BY_ID("DELETE FROM developer WHERE developer_id = (?)");
    public final String QUERY;
    SQLQueries(String QUERY ){
        this.QUERY = QUERY;
    }

}
