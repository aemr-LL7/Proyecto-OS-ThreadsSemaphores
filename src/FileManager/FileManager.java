/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FileManager;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author andre
 */
public class FileManager {

    private final String SAVED_DIRECTORY = ".saved";

    private int dayDuration;
    private int deadline;
    private int[] warehouseCapacities = new int[5]; // Array para almacenar las capacidades de los warehouse

    public FileManager() {
        // Si se necesita - inicializar arrays o valores por defecto
    }

    /**
     *
     * Metodo para abrir los archivos txt y leer los datos
     */
    public void readParamsFromTxt() {
        File file = selectFile(); // Elegir el archivo txt

        if (file != null && file.getName().endsWith(".txt")) {
            try {
                FileReader fileReader = new FileReader(file);
                BufferedReader bufferedReader = new BufferedReader(fileReader);
                String line;
                int currentWarehouseIndex = -1;

                while ((line = bufferedReader.readLine()) != null) {
                    // Verificar si la linea se encuentra en la seccion de general
                    if (line.contains("DayDuration=")) {
                        dayDuration = Integer.parseInt(line.split("=")[1].trim());
                    } else if (line.contains("Deadline=")) {
                        deadline = Integer.parseInt(line.split("=")[1].trim());
                    }

                    // Seccion de cada almacen
                    if (line.contains("[Motherboard Warehouse]")) {
                        currentWarehouseIndex = 0;
                    } else if (line.contains("[CPU Warehouse]")) {
                        currentWarehouseIndex = 1;
                    } else if (line.contains("[RAM Warehouse]")) {
                        currentWarehouseIndex = 2;
                    } else if (line.contains("[PowerSupply Warehouse]")) {
                        currentWarehouseIndex = 3;
                    } else if (line.contains("[GPU Warehouse]")) {
                        currentWarehouseIndex = 4;
                    }

                    // Si la linea contiene "MaxCapacity" se extrae la capacidad, y se guarda en el array
                    if (line.contains("MaxCapacity=") && currentWarehouseIndex != -1) {
                        warehouseCapacities[currentWarehouseIndex] = Integer.parseInt(line.split("=")[1].trim());
                    }
                }

                bufferedReader.close();
                fileReader.close();

                JOptionPane.showMessageDialog(null, "Parámetros cargados exitosamente!");
                printLoadedParams();

            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Por favor, selecciona un archivo TXT válido.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    /*
    *   Metodo para mostrar los parámetros cargados (auxiliar)
    */ 
    private void printLoadedParams() {
        System.out.println("Duración del día: " + dayDuration);
        System.out.println("Fecha límite: " + deadline);
        System.out.println("Capacidades de almacenes:");
        System.out.println("Motherboard Warehouse: " + warehouseCapacities[0]);
        System.out.println("CPU Warehouse: " + warehouseCapacities[1]);
        System.out.println("RAM Warehouse: " + warehouseCapacities[2]);
        System.out.println("PowerSupply Warehouse: " + warehouseCapacities[3]);
        System.out.println("GPU Warehouse: " + warehouseCapacities[4]);
    }

    /*
    *   Metodo para abrir la ventana de seleccion
    */ 
    public File selectFile() {
        try {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setCurrentDirectory(new File(System.getProperty("user.dir")));
            fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
            fileChooser.setDialogTitle("Seleccione un archivo");
            fileChooser.setAcceptAllFileFilterUsed(false);
            fileChooser.addChoosableFileFilter(new javax.swing.filechooser.FileNameExtensionFilter("Archivos TXT (*.txt)", "txt"));

            int result = fileChooser.showOpenDialog(null);
            if (result == JFileChooser.APPROVE_OPTION) {
                return fileChooser.getSelectedFile();
            } else {
                JOptionPane.showMessageDialog(null, "No se ha seleccionado ningun archivo.", "Cancelar", JOptionPane.CANCEL_OPTION);
                return null;
            }
        } catch (Exception e) {
            System.out.println("Algo salio mal :(");
            return null;
        }
    }

    /*
    *   Getters y Setters para obtener los params leidos
    */ 
    public int getDayDuration() {
        return this.dayDuration;
    }

    public int getDeadline() {
        return this.deadline;
    }

    public int[] getWarehouseCapacities() {
        return this.warehouseCapacities;
    }
}
