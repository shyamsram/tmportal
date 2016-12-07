package com.tm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootApplication
public class TmportalApplication  extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(TmportalApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(TmportalApplication.class, args);
	}

    @Autowired
    JdbcTemplate jdbcTemplate;

	@Bean
    public CommandLineRunner commandLineRunner() {
        return args -> {
            System.out.println("Creating tables");
            jdbcTemplate.execute("CREATE SCHEMA TMP");
            jdbcTemplate.execute("CREATE SEQUENCE TMP.TEAM_SEQ");
            jdbcTemplate.execute("DROP TABLE TMP.LEADS IF EXISTS");

            jdbcTemplate.execute("CREATE TABLE TMP.LEADS(" +
                    "id Integer, first_name VARCHAR(255), last_name VARCHAR(255))");

            jdbcTemplate.execute("DROP TABLE TMP.TEAM_DETAILS IF EXISTS");
            jdbcTemplate.execute("CREATE TABLE TMP.TEAM_DETAILS(" +
                    "id Integer, first_name VARCHAR(255), last_name VARCHAR(255),designation VARCHAR(100),supervisorid INTEGER)");

            // Split up the array of whole names into an array of first/last names
            List<Object[]> splitUpNames = Arrays.asList("John Doe").stream()
                    .map(name -> name.split(" "))
                    .collect(Collectors.toList());

            // Use a Java 8 stream to print out each tuple of the list
            splitUpNames.forEach(name -> System.out.println(String.format("Inserting LEADS record for %s %s", name[0], name[1])));
            splitUpNames.add(new Object[] {1});
            // Uses JdbcTemplate's batchUpdate operation to bulk load data
            jdbcTemplate.batchUpdate("INSERT INTO TMP.LEADS(first_name, last_name,id) VALUES (?,?,?)", splitUpNames);

            jdbcTemplate.execute("INSERT INTO TMP.TEAM_DETAILS(ID,FIRST_NAME,LAST_NAME,DESIGNATION,SUPERVISORID) VALUES(" +
                    "TMP.TEAM_SEQ.NEXTVAL,'Mike','Smith','Store Manager',1)");

            jdbcTemplate.execute("INSERT INTO TMP.TEAM_DETAILS(ID,FIRST_NAME,LAST_NAME,DESIGNATION,SUPERVISORID) VALUES(" +
                    "TMP.TEAM_SEQ.NEXTVAL,'Jane','Doe','Foreman',1)");

            jdbcTemplate.execute("INSERT INTO TMP.TEAM_DETAILS(ID,FIRST_NAME,LAST_NAME,DESIGNATION,SUPERVISORID) VALUES(" +
                    "TMP.TEAM_SEQ.NEXTVAL,'Richard','Roe','Trainee',1)");

            jdbcTemplate.execute("INSERT INTO TMP.TEAM_DETAILS(ID,FIRST_NAME,LAST_NAME,DESIGNATION,SUPERVISORID) VALUES(" +
                    "TMP.TEAM_SEQ.NEXTVAL,'Jane','Roe','Store Manager',1)");

            jdbcTemplate.execute("CREATE TABLE TMP.TEAM_EVALUATION(" +
                    "ID INTEGER, TEAM_ASSO_ID INTEGER, EVALUATION_STATUS VARCHAR(255))");
            jdbcTemplate.execute("INSERT INTO TMP.TEAM_EVALUATION(ID,TEAM_ASSO_ID,EVALUATION_STATUS) VALUES(" +
                    "TMP.TEAM_SEQ.NEXTVAL,1,'Completed')");
            jdbcTemplate.execute("INSERT INTO TMP.TEAM_EVALUATION(ID,TEAM_ASSO_ID,EVALUATION_STATUS) VALUES(" +
                    "TMP.TEAM_SEQ.NEXTVAL,2,'InProgress')");
            jdbcTemplate.execute("INSERT INTO TMP.TEAM_EVALUATION(ID,TEAM_ASSO_ID,EVALUATION_STATUS) VALUES(" +
                    "TMP.TEAM_SEQ.NEXTVAL,3,'InProgress')");
            jdbcTemplate.execute("INSERT INTO TMP.TEAM_EVALUATION(ID,TEAM_ASSO_ID,EVALUATION_STATUS) VALUES(" +
                    "TMP.TEAM_SEQ.NEXTVAL,4,'InProgress')");
        };
    }
}
