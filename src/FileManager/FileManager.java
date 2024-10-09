/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FileManager;

import GUI.Home;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author andre
 */
public class FileManager {

    private String SAVED_DIRECTORY = ".saved";
    private File dataFile;

    public FileManager() {

    }

    private void writeInitialStructure() {
        String initialContent = "[General Params]\n"
                + "Duration=1000\n"
                + "Deadline=10\n\n"
                + "[HP]\n"
                + "Motherboard=1\n"
                + "CPU=1\n"
                + "RAM=1\n"
                + "PSU=1\n"
                + "GPU=1\n"
                + "Assemblers=1\n"
                + "MaxCapacity=25\n\n"
                + "[MSI]\n"
                + "Motherboard=1\n"
                + "CPU=1\n"
                + "RAM=1\n"
                + "PSU=1\n"
                + "GPU=1\n"
                + "Assemblers=1\n"
                + "MaxCapacity=25\n";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(dataFile))) {
            writer.write(initialContent);
            System.out.println("Estructura inicial escrita en el archivo data.txt");
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al escribir en el archivo.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void savedDirectoryExists() {
        try {
            Path savedDirectoryPath = Paths.get(this.SAVED_DIRECTORY);

            // Si la carpeta .saved no existe, la creamos
            if (!Files.exists(savedDirectoryPath)) {
                Files.createDirectory(savedDirectoryPath);
                System.out.println("Carpeta .saved creada en el directorio raiz");
            }

            // Crear el archivo data.txt dentro de la carpeta .saved si no existe
            this.dataFile = new File(savedDirectoryPath.toFile(), "data.txt");
            if (!dataFile.exists()) {
                boolean fileCreated = dataFile.createNewFile();
                if (fileCreated) {
                    System.out.println("Archivo data.txt creado dentro de la carpeta .saved");
                    this.writeInitialStructure(); // Escribir la estructura inicial en el archivo
                } else {
                    System.out.println("Error al crear el archivo data.txt");
                }
            } else {
                System.out.println("El archivo data.txt ya existe!");
            }
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al crear la carpeta o el archivo.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void loadParamsFromTxt() {
        String fileWithData = this.readFile(Home.getSelectedFile());
        int[] params = this.getGeneralParams(fileWithData);
        if (params != null && params.length >= 2) {
            Home.setDuration(params[0]);
            Home.setDeadline(params[1]);
        }
        // Añadir los parametros de las compañias con HOME
//        this.createCompany();
    }

    private String readFile(File file) {
        String line;
        String data = "";

        try {
            if (!file.exists()) {
                file.createNewFile();

            } else {
                FileReader fr = new FileReader(file);
                BufferedReader br = new BufferedReader(fr);

                while ((line = br.readLine()) != null) {
                    if (!(line.isEmpty())) {
                        data += line + "\n";
                    }
                }
                br.close();
            }
            return data;
        } catch (Exception e) {
        }
        return data;
    }

    private int[] getGeneralParams(String params) {
        int[] generalParams = new int[2];
        boolean inGeneralParams = false;
        boolean foundDuration = false;
        boolean foundDeadline = false;

        String[] lines = params.split("\n");

        for (String line : lines) {
            line = line.trim();

            // Si encontramos la etiqueta [General Params]
            if (line.equals("[General Params]")) {
                inGeneralParams = true;
            } else if (line.startsWith("[") && inGeneralParams) {
                // Si encontramos otra sección después de [General Params], salimos
                break;
            } else if (inGeneralParams) {
                if (line.startsWith("Duration=")) {
                    String durationValue = line.split("=")[1].trim();
                    if (!durationValue.isEmpty()) {
                        generalParams[0] = Integer.parseInt(durationValue);
                        foundDuration = true;
                    }
                } else if (line.startsWith("Deadline=")) {
                    String deadlineValue = line.split("=")[1].trim();
                    if (!deadlineValue.isEmpty()) {
                        generalParams[1] = Integer.parseInt(deadlineValue); // Extraemos y guardamos el valor de Deadline
                        foundDeadline = true; // Marcamos que se encontró un valor valido para Deadline
                    }
                }
            }
        }

        // Verificamos si encontramos [General Params]
        if (!inGeneralParams) {
            JOptionPane.showMessageDialog(null, "No se encontró la sección [General Params] en el archivo.", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            // Si no se encontraron valores validos, mostramos un mensaje de error
            if (!foundDuration || !foundDeadline) {
                String errorMessage = "Los parámetros no son válidos.";
                if (!foundDuration) {
                    errorMessage += "\nFaltante o inválido: Duration=";
                }
                if (!foundDeadline) {
                    errorMessage += "\nFaltante o inválido: Deadline=";
                }
                JOptionPane.showMessageDialog(null, errorMessage, "Error", JOptionPane.ERROR_MESSAGE);
            }
        }

        return generalParams;
    }
    
    // Para HP index = 0 y MSI = 1
    public void createCompany(){}
    // Buscar en data.txt los parametros de las etiquetas [HP] y [MSI]
    public void getCompanyValues(){}
    

//    private void printLoadedParams() {
//        System.out.println("Duración del día: " + dayDuration);
//        System.out.println("Fecha límite: " + deadline);
//        System.out.println("Capacidades de almacenes:");
//        System.out.println("Motherboard Warehouse: " + warehouseCapacities[0]);
//        System.out.println("CPU Warehouse: " + warehouseCapacities[1]);
//        System.out.println("RAM Warehouse: " + warehouseCapacities[2]);
//        System.out.println("PowerSupply Warehouse: " + warehouseCapacities[3]);
//        System.out.println("GPU Warehouse: " + warehouseCapacities[4]);
//    }
}
