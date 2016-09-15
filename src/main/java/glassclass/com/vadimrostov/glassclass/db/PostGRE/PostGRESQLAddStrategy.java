package main.java.glassclass.com.vadimrostov.glassclass.db.PostGRE;

import main.java.glassclass.com.vadimrostov.glassclass.db.DBAddStrategy;
import main.java.glassclass.com.vadimrostov.glassclass.db.MySQL.MySQLConnector;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import javax.swing.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Iterator;

/**
 * Created by Vad on 13.09.2016.
 */
public class PostGRESQLAddStrategy implements DBAddStrategy {

    @Override
    public void insertDB(Object frameo) {
        PostGREDataHandler frame = (PostGREDataHandler) frameo;
        String sql="INSERT INTO " + frame.getPgretablename() + " (LAST_NAME, FIRST_NAME, PARENT_NAME, YEARS, STREET, HOUSE, ROOM) VALUES (?, ?, ?, ?, ?, ?,?)";
        try(Connection connection=new PostGREConnector(frame).connect();
            PreparedStatement ps=connection.prepareStatement(sql)) {
            try(FileInputStream in = new FileInputStream("1.xls")){
                HSSFWorkbook wb = new HSSFWorkbook(in);
                HSSFSheet sheet = wb.getSheetAt(0);
                Iterator it = sheet.iterator();

                while(it.hasNext()) {
                    Row row = (Row)it.next();
                    Iterator cells = row.iterator();

                    while(cells.hasNext()) {
                        Cell cell = (Cell)cells.next();
                        int celli = cell.getColumnIndex();
                        if(celli == 0) {
                            ps.setString(1, cell.getStringCellValue());
                        } else if(celli == 1) {
                            ps.setString(2, cell.getStringCellValue());
                        } else if(celli == 2) {
                            ps.setString(3, cell.getStringCellValue());
                        } else if(celli == 3) {
                            ps.setDouble(4, cell.getNumericCellValue());
                        } else if(celli == 4) {
                            ps.setString(5, cell.getStringCellValue());
                        } else if(celli == 5) {
                            ps.setDouble(6, cell.getNumericCellValue());
                        } else if(celli == 6) {
                            ps.setDouble(7, cell.getNumericCellValue());
                        }
                    }

                    ps.executeUpdate();
                }
            }
        catch (FileNotFoundException fnf){
            Object[] options={"Ok"};
            JOptionPane.showOptionDialog(frame.frame, "Отсутствует файл", fnf.toString(), JOptionPane.NO_OPTION, 0, null,options,
                    options[0]);
        }
        catch (IOException e){
            Object[] options={"Ok"};
            JOptionPane.showOptionDialog(frame.frame, "Ошибка ввода-вывода", e.toString(), JOptionPane.NO_OPTION, 0, null,options,
                    options[0]);
        }

    }
    catch (SQLException sqle){
        Object[] options={"Ok"};
        JOptionPane.showOptionDialog(frame.frame, "Ошибка SQL", sqle.toString(), JOptionPane.NO_OPTION, 0, null,options,
                options[0]);

        throw new RuntimeException("dsad");
    }

    }
}
