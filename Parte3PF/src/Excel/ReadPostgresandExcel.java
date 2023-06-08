package Excel;

import Entidad.Empleado;
import Entidad.detalle_nomina;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;

import javax.swing.*;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;

public class ReadPostgresandExcel {

    HSSFWorkbook workbook = new HSSFWorkbook();
    HSSFSheet spreadsheet = workbook.createSheet("Sheet1");

    public void escribirEmp(ArrayList<Empleado> emps){
        try{
            String[] headerS = {"Id","tpo_documento","documento","Nombre","id_cargo","salario_basics","estado"};
            HSSFRow header = spreadsheet.createRow(0);
            for (int x = 0;x<7;x++){
                Cell cellHeader = header.createCell(x);
                cellHeader.setCellValue(headerS[x]);
            }

            for (int i = 1; i<=emps.size();i++){
                HSSFRow row = spreadsheet.createRow(i);
                for (int j = 0; j <7;j++){
                    Cell cell = row.createCell(j);
                    if (j == 0){
                        cell.setCellValue(emps.get((i-1)).getId());

                    }else if (j ==1){
                        cell.setCellValue(emps.get((i-1)).getTpo_documento());

                    }else if (j ==2){
                        cell.setCellValue(emps.get((i-1)).getDocumento_cotizante());

                    }else if (j ==3){
                        cell.setCellValue(emps.get((i-1)).getNombre_cotizante());

                    }else if (j ==4){
                        cell.setCellValue(emps.get((i-1)).getId_cargo());

                    }else if (j ==5){
                        cell.setCellValue(emps.get((i-1)).getSalario_basico());

                    }else if (j ==6){
                        cell.setCellValue(emps.get((i-1)).isEstado());

                    }
                }
            }
            FileOutputStream out = new FileOutputStream(new File("Data//Empleados.xls"));
            workbook.write(out);
            out.close();
           // System.out.println("llego al final ");
        } catch(Exception e){
            JOptionPane.showMessageDialog(null, "Recuerde que para poder escribir en el archivo de excel que desea debe de estar cerrado", "ERROR", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
        //System.out.println("createworkbook.xls created!");
    }

    public void escribirNom(ArrayList<detalle_nomina> nominas){
        try{

            String[] headerS = {"Id","id_tpo_cotizante","id_subtpo_cotizante","id_empleado","id_cargo","periodo","periodo_salario","id_novedad","num_dias_trabajados","num_dias_incapacidad","num_dias_licencia","num_dias_permisos_remunerados","num_dias_permisos_no_remunerados","num_dias_vacaciones","num_dias_huelga","id_porcentaje_salud","id_porcentaje_pension"};
            HSSFRow header = spreadsheet.createRow(0);
            for (int x = 0;x<16;x++){
                Cell cellHeader = header.createCell(x);
                cellHeader.setCellValue(headerS[x]);
            }
            for (int i = 1; i<=nominas.size();i++){
                HSSFRow row = spreadsheet.createRow(i);
                for (int j = 0; j <16;j++){
                    Cell cell = row.createCell(j);
                    if (j == 0){
                        cell.setCellValue(nominas.get((i-1)).getId());

                    }else if (j ==1){
                        cell.setCellValue(nominas.get((i-1)).getId_tpo_cotizante());

                    }else if (j ==2){
                        cell.setCellValue(nominas.get((i-1)).getId_subtpo_cotizante());

                    }else if (j ==3){
                        cell.setCellValue(nominas.get((i-1)).getId_empleado());

                    }else if (j ==4){
                        cell.setCellValue(nominas.get((i-1)).getPeriodo());

                    }else if (j ==5){
                        cell.setCellValue(nominas.get((i-1)).getPeriodo_salario());

                    }else if (j ==6){
                        cell.setCellValue(nominas.get((i-1)).getId_novedad());

                    }else if (j ==7){
                        cell.setCellValue(nominas.get((i-1)).getNum_dias_trabajados());

                    }else if (j ==8){
                        cell.setCellValue(nominas.get((i-1)).getNum_dias_incapacidad());

                    }else if (j ==9){
                        cell.setCellValue(nominas.get((i-1)).getNum_dias_licencia());

                    }else if (j ==10){
                        cell.setCellValue(nominas.get((i-1)).getNum_dias_permisos_remunerados());

                    }else if (j ==11){
                        cell.setCellValue(nominas.get((i-1)).getNum_dias_permisos_no_remunerados());

                    }else if (j ==12){
                        cell.setCellValue(nominas.get((i-1)).getNum_dias_vacaciones());

                    }else if (j ==13){
                        cell.setCellValue(nominas.get((i-1)).getNum_dias_huelga());

                    }else if (j ==14){
                        cell.setCellValue(nominas.get((i-1)).getId_porcentaje_salud());

                    }else if (j ==15){
                        cell.setCellValue(nominas.get((i-1)).getId_porcentaje_pension());

                    }
                }
            }
            FileOutputStream out = new FileOutputStream(new File("Data//Nomina.xls"));
            workbook.write(out);
            out.close();
           // System.out.println("llego al final ");
        } catch(Exception e){
           /* e.printStackTrace();
            System.out.println("Error: " + e);*/
            JOptionPane.showMessageDialog(null, "Recuerde que para poder escribir en el archivo de excel que desea debe de estar cerrado", "ERROR", JOptionPane.ERROR_MESSAGE);

        }
        //System.out.println("createworkbook.xls created!");
    }
}
