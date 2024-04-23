package simple.restproject.dao;

import lombok.extern.slf4j.Slf4j;
import simple.restproject.model.Developer;
import simple.restproject.model.PhoneNumber;
import simple.restproject.model.PhoneType;
import simple.restproject.model.Project;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

@Slf4j
public class DeveloperDaoJDBC implements DeveloperDao {
    private final Connection connection;
    private final List<AllInfoMapper> allData;

    public DeveloperDaoJDBC(Connection connection) {
        this.connection = connection;
        this.allData = new ArrayList<>();
    }
    @Override
    public int insertDeveloper(Developer developer) throws SQLException {
        int generatedId = 0;

        try(PreparedStatement createDeveloper =
                    connection.prepareStatement(SQLQueries.INSERT_DEVELOPER.QUERY, PreparedStatement.RETURN_GENERATED_KEYS)) {
        createDeveloper.setString(1, developer.getName());
        createDeveloper.setInt(2, developer.getAge());
        createDeveloper.setString(3, developer.getEducation());
        createDeveloper.executeUpdate();

        try (ResultSet rs = createDeveloper.getGeneratedKeys()){
                rs.next();
                generatedId = rs.getInt("developer_id");
            return generatedId;
            }
        }
        catch (SQLException ex){
            log.error(ex.getMessage(), ex);
            throw ex;
        }
    }
    @Override
    public int updateDeveloper(Developer developer) throws SQLException {
        int rowsUpdated = 0;
        try (PreparedStatement updateDeveloper = connection.prepareStatement(SQLQueries.UPDATE_DEVELOPER_BY_ID.QUERY)) {
            updateDeveloper.setString(1, developer.getName());
            updateDeveloper.setInt(2, developer.getAge());
            updateDeveloper.setString(3, developer.getEducation());
            updateDeveloper.setInt(4, developer.getId());
            rowsUpdated = updateDeveloper.executeUpdate();

        } catch (SQLException ex) {
            log.error(ex.getMessage(), ex);
            throw ex;
        }
        return rowsUpdated;
    }

    @Override
    public int deleteDeveloperById(int id) throws SQLException {
        int updatedRows;
        try (PreparedStatement deleteDeveloper =
                        connection.prepareStatement(SQLQueries.DELETE_DEVELOPER_BY_ID.QUERY)
        ) {
            deleteDeveloper.setInt(1, id);
            updatedRows = deleteDeveloper.executeUpdate();
        } catch (SQLException e) {
            log.error(e.getMessage(), e);
            throw e;
    }
        return updatedRows;
    }

    @Override
    public Optional<Developer> findDeveloperById(int id) throws SQLException{
        Developer developer = null;
        try(
                PreparedStatement findAllInfo =
                        connection.prepareStatement(SQLQueries.SELECT_FULL_INFO.QUERY)
        ){
            findAllInfo.setInt(1, id);
            try(ResultSet rs = findAllInfo.executeQuery())
            {
                while (rs.next()){
                    AllInfoMapper allInfoMapper = new AllInfoMapper();
                    allInfoMapper.setDeveloperId(rs.getInt(1));
                    allInfoMapper.setDeveloperName(rs.getString(2));
                    allInfoMapper.setDeveloperAge(rs.getInt(3));
                    allInfoMapper.setDeveloperEducation(rs.getString(4));
                    allInfoMapper.setProjectId(rs.getInt(5));
                    allInfoMapper.setProjectTitle(rs.getString(6));
                    allInfoMapper.setPhoneID(rs.getInt(7));
                    allInfoMapper.setPhoneType((rs.getString(8) == null) ? PhoneType.UNKNOWN : PhoneType.valueOf(rs.getString(8)));
                    allInfoMapper.setPhoneNumber(rs.getString(9));
                    allData.add(allInfoMapper);
                }
            }catch (Exception ex){
                log.error(ex.getMessage(), ex);
                throw  ex;
            }
        }
        developer = getDeveloperFromAllData();
        allData.clear();
        return Optional.of(developer);
    }

      private List<String> findDevelopersOnProject(int id) throws SQLException {
        List<String> listOfDevelopersOnProject = new ArrayList<>();
        try(
            PreparedStatement selectDeveloperOnProject =
                    connection.prepareStatement(SQLQueries.SELECT_DEVELOPERS_ON_PROJECT.QUERY)
        ){
            selectDeveloperOnProject.setInt(1, id);
            try{
                ResultSet rs = selectDeveloperOnProject.executeQuery();
                while(rs.next()){
                listOfDevelopersOnProject.add(rs.getString(1));
                }

            } catch (SQLException e){
                e.printStackTrace();
            }
        }
        return listOfDevelopersOnProject;
    }


     private Developer getDeveloperFromAllData() throws SQLException {
        Developer developer = new Developer();
        developer.setId(allData.get(0).getDeveloperId());
        developer.setName(allData.get(0).getDeveloperName());
        developer.setAge(allData.get(0).getDeveloperAge());
        developer.setEducation(allData.get(0).getDeveloperEducation());
        Set<PhoneNumber> phoneNumbers = new HashSet<>();
        for(AllInfoMapper allInfoMapper : allData){
            PhoneNumber phoneNumber = new PhoneNumber();
            phoneNumber.setId(allInfoMapper.getPhoneID());
            phoneNumber.setPhoneType(allInfoMapper.getPhoneType());
            phoneNumber.setPhoneNumber(allInfoMapper.getPhoneNumber());
            phoneNumber.setOwnerID(allInfoMapper.getDeveloperId());
            phoneNumbers.add(phoneNumber);
        }
        developer.setPhones(new ArrayList<>(phoneNumbers));
        Set<Project> projects = new HashSet<>();
        for(AllInfoMapper allInfoMapper : allData){
            Project project = new Project();
            project.setId(allInfoMapper.getProjectId());
            project.setTitle(allInfoMapper.getProjectTitle());
            projects.add(project);
        }
        for(Project project : projects){
            List<String> listOfDevelopersOnProject =  findDevelopersOnProject(project.getId());
//            System.out.println(project.getId());
//            System.out.println("Developers list " + listOfDevelopersOnProject);
            project.setDeveloperList(listOfDevelopersOnProject);
        }
        developer.setProjects(new ArrayList<>(projects));
        return  developer;
    }
}
