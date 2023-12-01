package ques1;

import java.io.*;

public class VacuumCleaner extends Cleaner implements Serializable{
    private String modelID;
    private static final long serialVersionUID = 42L;
    private final static int numModels = 10000;
    private Motor motor;

    VacuumCleaner(String id){
        this.modelID = id;
        this.motor = new Motor();
    }
    public String getModelID() {
        return modelID;
    }

    @Override
    public void clean() {
        this.motor.rotate();
        System.out.println("vacuum cleaner is cleaning");
    }

    public class Motor implements Rotator, Serializable {
        private static final long serialVersionUID = 20L;
        @Override
        public void rotate() {
            System.out.println("motor is rotating");
        }
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        VacuumCleaner vc = new VacuumCleaner("vc-1.0");
        ObjectOutputStream writer = null;
        try{
            writer = new ObjectOutputStream(new FileOutputStream("temp.txt"));
            writer.writeObject(vc);
        }
        finally {
            writer.close();
        }

        Cleaner c2 = null;
        ObjectInputStream reader = null;
        try{
            reader = new ObjectInputStream(new FileInputStream("temp.txt"));
            c2 = (VacuumCleaner) reader.readObject();
        }
        finally {
            reader.close();
        }

        System.out.printf("For cleaner_1: %s\n", vc.getModelID());
        vc.clean();
        System.out.println("\nFor cleaner_2:");
        c2.clean();
    }
}