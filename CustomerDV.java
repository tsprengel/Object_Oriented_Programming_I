import java.util.ArrayList;
import java.io.*;



public final class CustomerDB {

    private static final String FILENAME = "customers.txt";
    private static final String COL_SEP = "\t";    

    public static ArrayList<Customer> getAll() {
        var customers = new ArrayList<Customer>();
        try (BufferedReader in = new BufferedReader(new FileReader(FILENAME))) {
            
            String line = in.readLine();
            
            while (line != null) {
                String [] columns = line.split(COL_SEP);
                String firstName = columns [0];
                String lastName = columns [1];
                String email = columns [2];
                
                Customer c = new Customer (firstName, lastName, email);
                customers.add(c);
                
                line = in.readLine();
            }
            
            return customers;
        }
        
        catch (FileNotFoundException e) {
            System.out.println (FILENAME + " does not exist.");
            return null;
        }
        
        catch (IOException e) {
            System.out.println(e);
            return null;
        }
    }

    public static void saveAll(ArrayList<Customer> customers) {
        try (PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(FILENAME)))) {
        for (Customer c : customers) {
            out.print(c.getFirstName() + COL_SEP);
            out.print(c.getLastName() + COL_SEP);
            out.print (c.getEmail() + COL_SEP);
        }
    }
        catch (IOException e) {
            System.out.println(e);
            
        }
    }
}
